package com.ric.st.builder.impl;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.BindingProvider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ric.bill.Config;
import com.ric.bill.dao.EolinkDAO;
import com.ric.bill.dao.TaskDAO;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.excp.WrongParam;
import com.ric.bill.mm.EolinkMng;
import com.ric.bill.mm.EolinkParMng;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.TaskEolinkParMng;
import com.ric.bill.mm.TaskMng;
import com.ric.bill.mm.TaskParMng;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Task;
import com.ric.bill.model.exs.TaskPar;
import com.ric.cmn.Utl;
import com.ric.st.ReqProps;
import com.ric.st.SoapConfigs;
import com.ric.st.TaskControllers;
import com.ric.st.builder.DeviceMeteringAsyncBindingBuilders;
import com.ric.st.builder.PseudoTaskBuilders;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.impl.SoapBuilder;
import com.ric.st.mm.UlistMng;
import com.sun.xml.ws.developer.WSBindingProvider;

import lombok.extern.slf4j.Slf4j;
import ru.gosuslugi.dom.schema.integration.base.AckRequest;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType.Error;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.device_metering.ElectricCurrentMeteringValueExportType;
import ru.gosuslugi.dom.schema.integration.device_metering.ElectricMeteringValueImportType;
import ru.gosuslugi.dom.schema.integration.device_metering.ExportMeteringDeviceHistoryRequest;
import ru.gosuslugi.dom.schema.integration.device_metering.ExportMeteringDeviceHistoryResultType;
import ru.gosuslugi.dom.schema.integration.device_metering.GetStateResult;
import ru.gosuslugi.dom.schema.integration.device_metering.ImportMeteringDeviceValuesRequest;
import ru.gosuslugi.dom.schema.integration.device_metering.ImportMeteringDeviceValuesRequest.MeteringDevicesValues;
import ru.gosuslugi.dom.schema.integration.device_metering.ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue;
import ru.gosuslugi.dom.schema.integration.device_metering.ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue;
import ru.gosuslugi.dom.schema.integration.device_metering.OneRateCurrentMeteringValueExportType;
import ru.gosuslugi.dom.schema.integration.device_metering.OneRateMeteringValueImportType;
import ru.gosuslugi.dom.schema.integration.device_metering_service_async.DeviceMeteringPortTypesAsync;
import ru.gosuslugi.dom.schema.integration.device_metering_service_async.DeviceMeteringServiceAsync;
import ru.gosuslugi.dom.schema.integration.device_metering_service_async.Fault;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;

@Slf4j
@Service
public class DeviceMeteringAsyncBindingBuilder implements DeviceMeteringAsyncBindingBuilders {

	@Autowired
	private ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;
	@Autowired
	UlistMng ulistMng;
	@Autowired
	private TaskParMng taskParMng;
	@Autowired
	private TaskMng taskMng;
	@Autowired
	private TaskDAO taskDao;
	@Autowired
	private EolinkMng eolinkMng;
	@Autowired
	private EolinkDAO eolinkDao;
	@Autowired
	private TaskEolinkParMng teParMng;
	@Autowired
	private EolinkParMng eolinkParMng;
	@Autowired
	private ReqProps reqProp;
	@Autowired
	private LstMng lstMng;
	@Autowired
	private SoapConfigs soapConfig;
	@Autowired
	private Config config;
	@Autowired
	private PseudoTaskBuilders ptb;
	@Autowired
	TaskControllers taskCtrl;
    @Autowired
    private AmqpTemplate amqp;

    @Value("${amqpOn:true}")
    private boolean amqpOn;
	@Value("${appTp}")
	private String appTp;
	@Value("${pathCounter}")
	private String pathCounter;
	@Value("${logQueue:soap2gis-log}")
	private String logQueue;

	private DeviceMeteringServiceAsync service;
	private DeviceMeteringPortTypesAsync port;
	private SoapBuilder sb;

	/**
	 * Инициализация - создать сервис и порт
	 * @throws CantSendSoap
	 */
	@Override
	public void setUp() throws CantSendSoap {
		service = new DeviceMeteringServiceAsync();
    	port = service.getDeviceMeteringPortAsync();

    	// подоготовительный объект для SOAP
    	sb = ctx.getBean(SoapBuilder.class);
		sb.setUp((BindingProvider) port, (WSBindingProvider) port, true);

		// логгинг запросов
    	sb.setTrace(reqProp.getFoundTask()!=null? reqProp.getFoundTask().getTrace().equals(1): false);
	}


	/**
	 * Получить состояние запроса
	 * @param task - задание
	 * @return
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public GetStateResult getState2(Task task) {

		// Признак ошибки
		Boolean err = false;
		// Признак ошибки в CommonResult
		Boolean errChld = false;
		String errStr = null;
		ru.gosuslugi.dom.schema.integration.device_metering.GetStateResult state = null;

		GetStateRequest gs = new GetStateRequest();
		gs.setMessageGUID(task.getMsgGuid());
		sb.setSign(false); // не подписывать запрос состояния!

		sb.makeRndMsgGuid();
		try {
			state = port.getState(gs);
		} catch (Fault e) {
			e.printStackTrace();
			err = true;
			errStr = "Запрос вернул ошибку!";
		}

		if (state != null && state.getRequestState() != 3) {
			// вернуться, если задание всё еще не выполнено
			log.trace("Статус запроса={}, Task.id={}", state.getRequestState(), task.getId());
			return null;
		}

		// Показать ошибки, если есть
		if (err) {
			// Ошибки во время выполнения
			log.trace(errStr);
			task.setState("ERR");
			task.setResult(errStr);
		} else if (!err && state.getErrorMessage() != null
				&& state.getErrorMessage().getErrorCode() != null
				&& !(task.getAct().getCd().equals("GIS_EXP_METER_VALS") // не ситуация, когда экспорт счетчиков и ошибка "Нет объектов для экспорта"
						&& state.getErrorMessage().getErrorCode().equals("INT002012"))
				) {
			// Ошибки контролей или бизнес-процесса
			err = true;
			errStr = state.getErrorMessage().getDescription();
			log.trace("Ошибка выполнения запроса errStr={}, errCode={}", errStr, state.getErrorMessage().getErrorCode());
			task.setState("ERR");
			task.setResult(errStr);
		} else {

			for (CommonResultType e : state.getImportResult()) {
					for (Error f: e.getError()) {
						// Найти элемент задания по Транспортному GUID
						Task task2 = taskMng.getByTguid(task, e.getTransportGUID());
						// Установить статусы ошибки по заданиям
						task2.setState("ERR");
						errStr = String.format("Error code=%s, Description=%s", f.getErrorCode(), f.getDescription());
						task2.setResult(errStr);
						log.error(errStr);

						errChld = true;
					};
			}
		}

		if (!err) {
			// если в главном задании нет ошибок, но в любом дочернем задании обнаружена ошибка - статус - "Ошибка"
			// и если уже не установлен признак ошибки
			if (errChld && !task.getState().equals("ERR")
					 && !task.getState().equals("ERS")) {
				task.setState("ERS");
				task.setResult(errStr);
				log.error("Ошибки в элементе CommonResult");
			}
		}

		return state;

	}

    /**
     * Получить состояние запроса
     * @param msgGuid - guid сообщения
     * @return
     */
    private GetStateResult getStateSrv(String msgGuid) {

        ru.gosuslugi.dom.schema.integration.device_metering.GetStateResult state = null;

        GetStateRequest gs = new GetStateRequest();
        gs.setMessageGUID(msgGuid);
        sb.setSign(false); // не подписывать запрос состояния!
        sb.makeRndMsgGuid();
        try {
            state = port.getState(gs);
        } catch (Fault e) {
            e.printStackTrace();
            ampqLog("ERROR: GetStateSrv, port.getState fault:"+e.getMessage());
            return null;
        } catch (Exception e) {
            ampqLog("ERROR: getStateSvr, port.getState:"+e.getMessage());
        }

        if (state != null && state.getRequestState() != 3) {
            // вернуться, если задание всё еще не выполнено
            ampqLog("Статус запроса для "+msgGuid+" :"+state.getRequestState());
            return null;
        }

        if (state.getErrorMessage() != null
                && state.getErrorMessage().getErrorCode() != null) {
            // Ошибки контролей или бизнес-процесса
            ampqLog(String.format("ERROR: getStateSrv: errCode: %s, errStr: %s",
                    state.getErrorMessage().getErrorCode(),
                    state.getErrorMessage().getDescription()));
            }
        for (CommonResultType e : state.getImportResult()) {
            for (Error f: e.getError()) {
                 ampqLog(String.format("Список ощибок:\nError code=%s, Description=%s", f.getErrorCode(), f.getDescription()));
            }
        }

        return state;

    }
	/**
	 * Импортировать показания счетчиков
	 *
	 * @param task - задание
	 * @throws WrongGetMethod
	 * @throws DatatypeConfigurationException
	 * @throws CantPrepSoap
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Boolean importMeteringDeviceValues(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap {
		//log.info("******* Task.id={}, импорт показаний счетчиков, вызов", task.getId());
		taskMng.logTask(task, true, null);

		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		// Трассировка XML
		sb.setTrace(reqProp.getFoundTask()!=null? reqProp.getFoundTask().getTrace().equals(1): false);
		AckRequest ack = null;
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;

		ImportMeteringDeviceValuesRequest req = new ImportMeteringDeviceValuesRequest();

		req.setId("foo");
		req.setVersion(req.getVersion());
		req.setFIASHouseGuid(reqProp.getHouseGuid());

		List<Task> lstTask = taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "СчетчикФизический", null, reqProp.getAppTp()).stream()
				.filter(t-> t.getAct().getCd().equals("GIS_ADD_METER_VAL")).collect(Collectors.toList());
		for (Task t: lstTask) {
			// Транспортный GUID
			String tguid = Utl.getRndUuid().toString();
	    	t.setTguid(tguid);

			// счетчик физический (корневой)
			Eolink meter = t.getEolink();

			Date dtGet = taskParMng.getDate(t, "Счетчик.ДатаСнятияПоказания");
			MeteringDevicesValues val = new MeteringDevicesValues();
			val.setMeteringDeviceRootGUID(meter.getGuid());
			//val.setMeteringDeviceVersionGUID(meterVers.getGuid());

			if (ulistMng.getResType(meter.getUsl()) == 1) {
				ElectricDeviceValue elVal = new ElectricDeviceValue();
				ElectricMeteringValueImportType currElVal = new ElectricMeteringValueImportType();

				// Дата снятия показания
				currElVal.setDateValue(Utl.getXMLDate(dtGet));

				// показания по тарифам
				Double metVal = taskParMng.getDbl(t, "Счетчик.Показ(Т1)");
				currElVal.setMeteringValueT1(String.valueOf(metVal));
				metVal = taskParMng.getDbl(t, "Счетчик.Показ(Т2)");
				if (metVal != null) {
					currElVal.setMeteringValueT2(String.valueOf(metVal));
				}
				metVal = taskParMng.getDbl(t, "Счетчик.Показ(Т3)");
				if (metVal != null) {
					currElVal.setMeteringValueT3(String.valueOf(metVal));
				}

				currElVal.setTransportGUID(tguid);
				elVal.setCurrentValue(currElVal);
				// эл.энерг.
				val.setElectricDeviceValue(elVal );
			} else if (ulistMng.getResType(meter.getUsl()) == 0) {
				OneRateDeviceValue oneRateVal = new OneRateDeviceValue();
				OneRateMeteringValueImportType currOneRateVal =
						new OneRateMeteringValueImportType();
				currOneRateVal.setDateValue(Utl.getXMLDate(dtGet));

				// показания по тарифам
				Double metVal = taskParMng.getDbl(t, "Счетчик.Показ(Т1)");
				currOneRateVal.setMeteringValue(String.valueOf(metVal));

				// Получить ресурс по коду USL
				NsiRef mres = ulistMng.getResourceByUsl(meter.getUsl());

				currOneRateVal.setMunicipalResource(mres);
				currOneRateVal.setTransportGUID(tguid);
				oneRateVal.getCurrentValue().add(currOneRateVal);
				// г.в., х.в.
				val.setOneRateDeviceValue(oneRateVal );
			}
			req.getMeteringDevicesValues().add(val);
		}
		try {
			ack = port.importMeteringDeviceValues(req);
		} catch (Fault e) {
			e.printStackTrace();
			err = true;
			errMainStr = e.getFaultInfo().getErrorMessage();
		}

		if (err) {
			reqProp.getFoundTask().setState("ERR");
			reqProp.getFoundTask().setResult("Ошибка при отправке XML: "+errMainStr);
			taskMng.logTask(task, false, false);

		} else {
			// Установить статус "Запрос статуса"
			reqProp.getFoundTask().setState("ACK");
			reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
			taskMng.logTask(task, false, true);

		}
		return err;

	}

	/**
	 * Получить результат импорта показаний счетиков
	 * @param task - задание
	 * @throws CantPrepSoap
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void importMeteringDeviceValuesAsk(Task task) throws CantPrepSoap {
		//log.info("******* Task.id={}, импорт показаний счетчиков, запрос ответа", task.getId());
		taskMng.logTask(task, true, null);

		// Установить параметры SOAP
		reqProp.setProp(task, sb);

		// получить состояние
		GetStateResult retState = getState2(reqProp.getFoundTask());

		if (retState == null) {
			// не обработано
			return;
		} else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
			retState.getImportResult().stream().forEach(t -> {
				log.trace("После импорта объектов по Task.id={} и TGUID={}, получены следующие параметры:",
						reqProp.getFoundTask().getId(), t.getTransportGUID());
				log.trace("UniqueNumber={}, Дата обновления={}", t.getUniqueNumber(), Utl.getDateFromXmlGregCal(t.getUpdateDate()));
				// Найти элемент задания по Транспортному GUID
				Task task2 = taskMng.getByTguid(reqProp.getFoundTask(), t.getTransportGUID());
				// Переписать значения параметров в eolink из task
				teParMng.acceptPar(task2);
				task2.setState("ACP");

			});

			// Установить статус выполнения задания
			reqProp.getFoundTask().setState("ACP");
			taskMng.logTask(task, false, true);


		}
	}

	/**
	 * Экспортировать показания счетчиков по дому
	 *
	 * @param task - задание
	 * @throws CantPrepSoap
	 * @throws WrongGetMethod
	 * @throws DatatypeConfigurationException
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Boolean exportMeteringDeviceValues(Task task) throws CantPrepSoap, WrongGetMethod, DatatypeConfigurationException {
		//log.info("******* Task.id={}, экспорт показаний счетчиков, вызов", task.getId());
		taskMng.logTask(task, true, null);

		//sb.setTrace2(reqProp.getFoundTask().getTrace().equals(1));
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		// Трассировка XML
		sb.setTrace(reqProp.getFoundTask()!=null? reqProp.getFoundTask().getTrace().equals(1): false);
		AckRequest ack = null;
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;

		ExportMeteringDeviceHistoryRequest req = new ExportMeteringDeviceHistoryRequest();

		req.setId("foo");
		req.setVersion(req.getVersion());
		req.setFIASHouseGuid(reqProp.getHouseGuid());

		// опции проверки
		Boolean checkOneOpt=false;
		Boolean checkTwoOpt=false;
		// Добавить параметры фильтрации показаний
		for (TaskPar p :task.getTaskPar()) {

			// Фильтр - Тип - виды приборов учета
			if (p.getPar().getCd().equals("Счетчик.Тип")) {
				checkOneOpt=true;
				log.trace("Тип прибора учета1={}", p.getS1());
				NsiRef tp = ulistMng.getNsiElem("NSI", 27, "Тип прибора учета", p.getS1());
				req.getMeteringDeviceType().add(tp);
			}
			// Фильтр - Вид коммунального ресурса
			if (p.getPar().getCd().equals("Счетчик.ВидКоммунРесурса")) {
				if (checkOneOpt) {
					throw new CantPrepSoap("Некорректное количество критериев запроса!");
				}
				checkTwoOpt=true;
				//log.trace("Вид коммун ресурса1={}", p.getS1());
				NsiRef tp = ulistMng.getNsiElem("NSI", 2, "Вид коммунального ресурса", p.getS1());
				//log.trace("Вид коммун ресурса2={}", tp.getName());
				req.getMunicipalResource().add(tp);
			}
		}

		// Фильтр - приборы учета по RootGuid, кроме дочерних временных заданий
		for (Task t: task.getChild().stream().filter(t-> t.getAct().getCd().equals("GIS_EXP_METER_VAL"))
				.collect(Collectors.toList())) {
			if (checkOneOpt || checkTwoOpt) {
				throw new CantPrepSoap("Некорректное количество критериев запроса!");
			}
			req.getMeteringDeviceRootGUID().add(t.getEolink().getGuid());
		}

		// Искать ли архивные
		req.setSerchArchived(false);
		// Отключить показания отправленные информационной системой
		req.setExcludeISValues(true);
		// дата с которой получить показания
		req.setInputDateFrom(Utl.getXMLDate(taskCtrl.getReqConfig().getCurDt1()));

		try {
			ack = port.exportMeteringDeviceHistory(req);
		} catch (Fault e) {
			e.printStackTrace();
			err = true;
			errMainStr = e.getFaultInfo().getErrorMessage();
		}

		if (err) {
			reqProp.getFoundTask().setState("ERR");
			reqProp.getFoundTask().setResult("Ошибка при отправке XML: "+errMainStr);
			taskMng.logTask(task, false, false);

		} else {
			// Установить статус "Запрос статуса"
			reqProp.getFoundTask().setState("ACK");
			reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
			taskMng.logTask(task, false, true);

		}
		return err;

	}

	/**
	 * Получить результат экспорта показаний счетиков
	 * @param task - задание
	 * @throws WrongGetMethod
	 * @throws IOException
	 * @throws CantPrepSoap
	 * @throws WrongParam
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void exportMeteringDeviceValuesAsk(Task task) throws WrongGetMethod, IOException, CantPrepSoap, WrongParam {
		//log.info("******* Task.id={}, экспорт показаний счетчиков, запрос ответа", task.getId());
		taskMng.logTask(task, true, null);

		sb.setTrace(reqProp.getFoundTask()!=null? reqProp.getFoundTask().getTrace().equals(1): false);
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		// получить состояние запроса
		GetStateResult retState = getState2(reqProp.getFoundTask());

		if (retState == null) {
			// не обработано
			return;
		} else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
				// пользователь
				Integer userId = soapConfig.getCurUser().getId();
				Lst actVal = lstMng.getByCD("GIS_TMP");
				for (ExportMeteringDeviceHistoryResultType t : retState.getExportMeteringDeviceHistoryResult()) {
				// найти счетчик по GUID
				Eolink meter = eolinkDao.getEolinkByGuid(t.getMeteringDeviceRootGUID());
				if (meter == null) {
					// счетчик не найден, создать задание на его выгрузку из ГИС (в нём же выгрузятся показания)
					log.trace("При выгрузке показаний, счетчик с GUID={} НЕ НАЙДЕН, ожидается его экспорт из ГИС",
							t.getMeteringDeviceRootGUID());

					/*ptb.setUp(reqProp.getFoundTask().getEolink(), null, "GIS_EXP_METERS", "INS");
					ptb.addTaskPar("ГИС ЖКХ.Включая архивные", null, null, false, null);
					ptb.save();*/
				} else {
					// счетчик найден, выгрузить по нему последние показания
					if (t.getOneRateDeviceValue() != null) {
						for (OneRateCurrentMeteringValueExportType e :
								t.getOneRateDeviceValue().getValues().getCurrentValue()) {
							log.trace("показания по OneRateDeviceValue: GUID={} date={}, enter={}, val={}", t.getMeteringDeviceRootGUID(), e.getDateValue(), e.getEnterIntoSystem(),
									e.getMeteringValue());
							// записать объем по счетчику в EOLINK
							saveVal(task, meter, userId, actVal, t.getMeteringDeviceRootGUID(), e.getMeteringValue(),
									Utl.getDateFromXmlGregCal(e.getDateValue()), Utl.getDateFromXmlGregCal(e.getEnterIntoSystem()));
						}
					}
					if (t.getElectricDeviceValue() != null) {
						for (ElectricCurrentMeteringValueExportType e :
							t.getElectricDeviceValue().getValues().getCurrentValue()) {
							log.trace("показания по ElectricDeviceValue: GUID={} date={}, enter={}, val={}", t.getMeteringDeviceRootGUID(), e.getDateValue(), e.getEnterIntoSystem(),
									e.getMeteringValueT1());
							//log.trace("TGUID={}", e.s);
							// записать объем по счетчику в EOLINK
							saveVal(task, meter, userId, actVal, t.getMeteringDeviceRootGUID(), e.getMeteringValueT1(),
									Utl.getDateFromXmlGregCal(e.getDateValue()), Utl.getDateFromXmlGregCal(e.getEnterIntoSystem()));
						}

					}

				}
				}
				// Установить статус выполнения задания
				reqProp.getFoundTask().setState("ACP");
				taskMng.logTask(task, false, true);

			}


			/*Path path = null;
			if (Utl.nvl(taskParMng.getBool(task, "ГИС ЖКХ.Выгрузить в файл"), false)) {
				// создать файл
				path = Paths.get(config.getPathCounter());
				if (Files.exists(path)) {
					Files.delete(path);
				}
				Path writer = Files.createFile(path);
			}*/


	}

	/**
	 * Отправляет строку в лог ampq
	 */
	//TODO: сделать нормальный класс
	private void ampqLog(String s) {
	    if (amqpOn) amqp.convertAndSend(logQueue, s);
	}

	/**
	 * Получает из jsonNode значение поля в виде строки
	 */
	private String jsonGetStr(JsonNode json, String field) {
	    JsonNode node = json.get(field);
	    if (node == null || !node.isValueNode()) return null;
	    return node.asText();
	}

	@Override
	public String exportMeteringDeviceValuesSrv(JsonNode json) {
	    String ret = "error";
	    ObjectMapper mapper = new ObjectMapper();

	    log.trace("******* ampq экспорт показаний счетчиков");
	    ampqLog("Экспорт показаний");
	    try {
	        ampqLog(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json));
	    } catch (Exception e) {
	        ampqLog("ERROR: mapper:"+e.getMessage());
	    }

        AckRequest ack = null;
        // для обработки ошибок
        boolean err = false;
        String errMainStr = null;
        // Параметры запроса
        String FIASHouseGuid = jsonGetStr(json, "FIASHouseGuid");
        String meteringType = jsonGetStr(json, "meteringType");
        String resourceType = jsonGetStr(json, "resourceType");
        String rootGuid = jsonGetStr(json, "rootGuid");
        String messageGuid = jsonGetStr(json, "messageGuid");
        String orgGuid = jsonGetStr(json, "orgGuid");
        String dateStr = jsonGetStr(json, "date");
        String archiveDateFrom = jsonGetStr(json, "archiveDateFrom");
        String archiveDateTo = jsonGetStr(json, "archiveDateTo");
        String getArchive = jsonGetStr(json, "getArchive");
        String excludeISValues = jsonGetStr(json, "excludeISValues");
        ampqLog(String.format("Parsing results:\n%s:%s;\n%s:%s;\n%s:%s;\n%s:%s;\n%s:%s;\n%s:%s;\n"+
                              "%s:%s;\n%s:%s;\n%s:%s;\n%s:%s;\n%s:%s;\n",
                "FIASHouseGuid", FIASHouseGuid,
                "meteringType", meteringType,
                "resourceType", resourceType,
                "rootGuid", rootGuid,
                "messageGuid", messageGuid,
                "orgGuid", orgGuid,
                "date", dateStr,
                "achiveDateFrom", archiveDateFrom,
                "achiveDateTo", archiveDateTo,
                "getAchive", getArchive,
                "excludeISValues", excludeISValues
                ));
        boolean achive = getArchive != null && getArchive.equals("true");
        boolean excludeIS = excludeISValues != null && excludeISValues.equals("true");

        sb.setTrace(reqProp.getFoundTask()!=null? reqProp.getFoundTask().getTrace().equals(1): false);
        if (orgGuid != null) {
            sb.setPpGuid(orgGuid);
        } else {
            ampqLog("Error: нужен orgGuid");
        }

        if (messageGuid != null) {
            //переходник
            ampqLog("Получен messageGuid");
            // получить состояние запроса
            GetStateResult retState = getStateSrv(messageGuid);
            if (retState == null) {
                ampqLog("ERROR: exportMeteringDeviceValuesSrv resState : NULL");
                return ret;
            }
            try {
                ret = mapper.writeValueAsString(
                      retState.getExportMeteringDeviceHistoryResult());
                ampqLog("JSON :" + ret);
            } catch (Exception e) {
                ampqLog("ERROR: mapper.writeValueAsString:"+e.getMessage());
            }
        } else if (FIASHouseGuid != null) {
            ampqLog("Получен FIASHouseGuid");
            ExportMeteringDeviceHistoryRequest req = new ExportMeteringDeviceHistoryRequest();

            req.setId("foo");
            req.setVersion(req.getVersion());
            req.setFIASHouseGuid(FIASHouseGuid);

            boolean ok = false;
            NsiRef tp = null;
            if (meteringType != null) {
                ampqLog("Тип прибора учета1="+meteringType);
                tp = ulistMng.getNsiElem("NSI", 27, "Тип прибора учета", meteringType);
                req.getMeteringDeviceType().add(tp);
                ok = true;
            } else if (resourceType != null) {
                ampqLog("Тип ресурса="+resourceType);
                tp = ulistMng.getNsiElem("NSI", 2, "Вид коммунального ресурса", resourceType);
                req.getMunicipalResource().add(tp);
                ok = true;
            } else if (rootGuid != null) {
                ampqLog("Корневой guid="+rootGuid);
                req.getMeteringDeviceRootGUID().add(rootGuid);
                ok = true;
            }
            if (!ok) {
                ampqLog("ERROR: Ошибка в формате входящего json.");
                return ret;
                //error, return
            }
            // Искать ли архивные
            req.setSerchArchived(achive);

            SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy");
            if (archiveDateFrom != null && archiveDateTo != null) {
                try {
                    Date dtAchiveFrom = parser.parse(archiveDateFrom);
                    Date dtAchiveTo = parser.parse(archiveDateTo);
                    req.setArchiveDateFrom(Utl.getXMLDate(dtAchiveFrom));
                    req.setArchiveDateTo(Utl.getXMLDate(dtAchiveTo));
                } catch (Exception e) {
                    ampqLog("ERROR: acrive date parse:"+e.getMessage());
                }

            }

            // Отключить показания отправленные информационной системой
            req.setExcludeISValues(excludeIS);
            // дата с которой получить показания

            try {
                Date dt = dateStr != null ?
                        parser.parse(dateStr) :
                        taskCtrl.getReqConfig().getCurDt1();
                req.setInputDateFrom(Utl.getXMLDate(dt));
            } catch (Exception e) {
                ampqLog("ERROR: reqInputDateFrom:"+e.getMessage());
            }


            try {
                ack = port.exportMeteringDeviceHistory(req);
            } catch (Fault e) {
                e.printStackTrace();
                err = true;
                errMainStr = e.getFaultInfo().getErrorMessage();
            } catch (Exception e) {
                ampqLog("ERROR: "+e.getMessage());
                err = true;
                errMainStr = "Java exception";
            }

            if (err) {
                ampqLog("ERROR: Ошибка при отправке XML: "+errMainStr);
            } else {
                // Установить статус "Запрос статуса"
                //reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
                ret = "{\"messageGuid\":\""+ack.getAck().getMessageGUID()+"\"}";
                ampqLog("JSON :" + ret);
            }
        }
        return ret;
    }


	/**
	 * Записать показание по счетчику в EOLINK
	 * @param task - текущее задание
	 * @param meter - счетчик
	 * @param userId - Id пользователя
	 * @param actVal - тип задания
	 * @param rootGUID - Root GUID счетчика
	 * @param val - принятое от ГИС показание
	 * @param dtVal - дата снятия
	 * @param dtEnter - дата внесения в ГИС
	 * @throws WrongGetMethod
	 * @throws IOException
	 * @throws WrongParam
	 */
	private void saveVal(Task task, Eolink meter, Integer userId, Lst actVal, String rootGUID,
			String val, Date dtVal, Date dtEnter) throws WrongGetMethod, IOException, WrongParam {
		if (val != null) {
			Double valD = Double.parseDouble(val);
			// последняя дата снятия показания
			Date dtVal2 = eolinkParMng.getDate(meter, "Счетчик.ДатаСнятияПоказания");
			// дата внесения показания в ГИС
			Date dtEnter2 = eolinkParMng.getDate(meter, "ГИС ЖКХ.Счетчик.ДатаВнесенияПоказания");
			//log.trace("date1={}, date2={}", dtVal, dtVal2);
			log.trace("дата-время снятия из ГИС={}, дата-время из Базы={}", dtVal.getTime(), dtVal2.getTime());
			log.trace("дата-время внесения из ГИС={}, дата-время из Базы={}", dtVal.getTime(), dtVal2.getTime());
			if (dtVal2 == null || Utl.truncDate(dtVal).compareTo(Utl.truncDate(dtVal2)) > 0 // дата новее в ГИС
					 || Utl.truncDate(dtVal).compareTo(Utl.truncDate(dtVal2)) == 0 // дата та же в ГИС, дата внесения новее
					 	&& dtEnter.getTime() > dtEnter2.getTime()
					) {
					// получить текущие показания по счетчику
					Double prevVal = eolinkParMng.getDbl(meter, "Счетчик.Показ(Т1)");
					if (prevVal == null || prevVal!= valD) {
						// Если показания изменились, записать в Eolink
						// дочернее псевдозадание, хранящее принятые показания по счетчику
						log.trace("Попытка по счетчику rootGUID={}, принять следующие показания:T1={}, дата снятия={}, дата внесения в ГИС={}",
								rootGUID, val, dtVal, dtEnter);

						eolinkParMng.setDbl(meter, "Счетчик.ПоказПредыдущее(Т1)", prevVal);
						eolinkParMng.setDbl(meter, "Счетчик.Показ(Т1)", valD);
						eolinkParMng.setDate(meter, "Счетчик.ДатаСнятияПоказания", dtVal);
						eolinkParMng.setDate(meter, "ГИС ЖКХ.Счетчик.ДатаВнесенияПоказания", dtEnter);
						eolinkParMng.setDbl(meter, "ГИС ЖКХ.Счетчик.СтатусОбработкиПоказания", 1D);
					}

			}
		}
	}

	/**
	 * Записать показания по счетчикам в файл
	 * @param task - задание
	 * @throws IOException
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void saveValToFile(Task task) throws WrongGetMethod, IOException {
		log.trace("******* Task.id={}, Выгрузка показаний приборов учета в файл path={}", task.getId(), appTp, pathCounter);
		Task foundTask = em.find(Task.class, task.getId());
		if (appTp.equals("0")) {
			File file = new File(pathCounter);
			FileWriter fw = null;
			BufferedWriter bw = null;
			boolean fileLinked = false;

			for (Eolink meter : eolinkDao.getValsNotSaved()) {
					// ЗАПИСАТЬ показания во внешний файл
					Integer cLskId = null;
					// найти первый попавшийся лицевой счет (по словам Андрейки ред. 22.09.18)
					for (Eolink t :meter.getParentLinked()){
						cLskId = t.getCLskId();
						break;
					}
					Integer tp = null;
					switch (meter.getUsl()) {
					case "011":
						tp = 1;
						break;
					case "015":
						tp = 2;
						break;
					case "024":
						tp = 3;
						break;
					}
					if (cLskId == null) {
						log.error("К счетчику не привязан лицевой счет, Eolink.id={}", meter.getId());
					} else if (tp != null) {
					// предыдущее показание
					Double prevVal = eolinkParMng.getDbl(meter, "Счетчик.ПоказПредыдущее(Т1)");
					// текущее показание
					Double val = eolinkParMng.getDbl(meter, "Счетчик.Показ(Т1)");
					// объем = новое показание - предыдущее показание
					Double vol = Utl.nvl(val, 0D) - Utl.nvl(prevVal, 0D);
					String log_id = "";
					if (val != null) {
					    try {
					    	if (!fileLinked) {
								if (!file.exists()) file.createNewFile();
								fw = new FileWriter(file.getAbsoluteFile());
								bw = new BufferedWriter(fw);
								fileLinked = true;
							}
							log.trace("Показания по Eolink.id={}", meter.getId());
							log_id = em.createNativeQuery("Select exs.seq_log.nextval from dual").getSingleResult().toString();
							String str = log_id+"|"+cLskId+"|"+tp+"|"+eolinkParMng.getDbl(meter, "Счетчик.Показ(Т1)")+"|"+vol+"|"+
									Utl.getStrFromDate(new Date(), "dd.MM.yyyy HH:mm:ss")+"|"+Utl.nvl(meter.getIdGrp(),"0")+"|"+Utl.nvl(meter.getIdCnt(),"0");
					    	log.trace(str);
							bw.write(str);
							bw.newLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (WrongGetMethod e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					// пометить сохранённым в файл
					eolinkParMng.setDbl(meter, "ГИС ЖКХ.Счетчик.СтатусОбработкиПоказания", 0D);
					}
			}
			if (bw != null)
				bw.close();

			if (fw != null)
				fw.close();
		}
		// Установить статус выполнения задания
		foundTask.setState("ACP");
	}

	/**
	 * Проверить наличие заданий на выгрузку показаний по счетчикам, по домам
	 * и если их нет, - создать
	 * @param task
	 * @throws WrongParam
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void checkPeriodicTask(Task task) throws WrongParam {
		//log.trace("******* Task.id={}, проверка наличия заданий на выгрузку показаний по счетчикам, по домам, вызов", task.getId());
		Task foundTask = em.find(Task.class, task.getId());
		// создать по всем домам задания, если их нет
		String actTp = "GIS_EXP_METER_VALS";
		String parentCD = "SYSTEM_RPT_MET_EXP_VAL";
		// создавать по 10 штук, иначе -блокировка Task (нужен коммит)
		int a=1;
		for (Eolink e: eolinkDao.getEolinkByTpWoTaskTp("Дом", actTp, parentCD)) {
			// статус - STP, остановлено (будет запускаться другим заданием)
			ptb.setUp(e, null, actTp, "STP");
			ptb.addTaskPar("Счетчик.ВидКоммунРесурса", null, "Холодная вода", null, null);
			ptb.addTaskPar("Счетчик.ВидКоммунРесурса", null, "Горячая вода", null, null);
			ptb.addTaskPar("Счетчик.ВидКоммунРесурса", null, "Электрическая энергия", null, null);
			// добавить как дочернее задание к системному повторяемому заданию
			ptb.addAsChild(parentCD);
			ptb.save();
			log.trace("Добавлено задание на выгрузку показаний приборов учета по Дому Eolink.id={}", e.getId());
			a++;
			if (a>=100) {
				break;
			}
		};
		// Установить статус выполнения задания
		foundTask.setState("ACP");
		//log.trace("******* Task.id={}, проверка наличия заданий на выгрузку показаний по счетчикам, по домам, выполнено!", task.getId());

	}

}
