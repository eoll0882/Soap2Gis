package com.ric.st.builder.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.quartz.CronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.cmn.Utl;
import com.ric.bill.dao.TaskDAO;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.TaskParMng;
import com.ric.bill.model.exs.Task;
import com.ric.bill.model.exs.TaskPar;
import com.ric.bill.model.exs.TaskToTask;
import com.ric.st.builder.TaskBuilders;

import lombok.extern.slf4j.Slf4j;

/**
 * Сервисы обслуживания задач
 * @author lev
 *
 */
@Slf4j
@Service
public class TaskBuilder implements TaskBuilders {

    @PersistenceContext
    private EntityManager em;
    //@Autowired
    //private TaskParMng taskParMng;
    @Autowired
    private TaskDAO taskDao;
    // хранилище старых и новых ID
	//private HashMap<Task, Task> mapTask;
	// Расписания
	List<TaskPar> lstSched;
	// Список сработавших событий в расписании
	List<Integer> lstTrg = new ArrayList<Integer>();
	// Список обработанных событий в расписании
	List<Integer> lstTrgProc = new ArrayList<Integer>();
	
	// класс расписания задачи
    /*private class Schedule {
    	Task task;
    	TaskPar taskPar;
    	Integer trgBySched; // установлено/снято загрузчиком расписаний
    	Integer trgByCtrl; // установлено/снято обработчиком заданий 
    	
    	// конструктор
    	public Schedule (Task task, TaskPar taskPar) {
    		this.task = task;
    		this.taskPar = taskPar;
    	}
		public Task getTask() {
			return task;
		}
		public TaskPar getTaskPar() {
			return taskPar;
		}
		public Integer getTrgBySched() {
			return trgBySched;
		}
		public void setTrgBySched(Integer trgBySched) {
			this.trgBySched = trgBySched;
		}
		public Integer getTrgByCtrl() {
			return trgByCtrl;
		}
		public void setTrgByCtrl(Integer trgByCtrl) {
			this.trgByCtrl = trgByCtrl;
		}
		
    }*/

    /**
     * Активация повторяемого задания
     * @param - task - повторяемое задание
     * @throws WrongGetMethod 
     */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void activateRptTask(Task task) throws WrongGetMethod {
		Task foundTask = em.find(Task.class, task.getId());
		log.info("******* Task.id={}, Повторяемое задание", foundTask.getId());
		/* найти все связи с зависимыми записями, в заданиях которых нет родителя (главные),
		   а так же если у этих заданий либо не имеется зависимых заданий, либо имеются и 
		   они НЕ находятся в статусах INS, ACK (т.е. на обработке)   
		   (по определённому типу связи)
		*/
		foundTask.getInside().stream()
		.filter(t-> t.getTp().getCd().equals("Связь повторяемого задания"))
	    .filter(t-> t.getChild().getParent() == null) // только главные
	    .filter(t-> t.getChild().getMaster() == null) // только независимые
	    .forEach(t-> {
	    	// ведущее задание
			Task master = t.getChild().getMaster();
			// зависимые задания
			List<Task> slave = t.getChild().getSlave();
			// текущее задание
			Task current = t.getChild();
			if (!Utl.in(current.getState(), "INS", "ACK" )) {
				// если не выполняется 
				if (master == null && slave.size() == 0) {
					// нет зависимых по DEP_ID заданий
			    	log.info("------------Основное задание Task.id={} НЕТ Зависимых заданий, ВКЛ!", current.getId());
			    	// и нет зависимых заданий, то поставить на выполнение
			    	current.setState("INS");
				} else {
		    		// есть зависимые задания, проверить их статусы
			    	log.info("------------Основное задание Task.id={} Есть Зависимые задания!", current.getId());
					if(slave.stream()
					    .filter(e -> Utl.in(e.getState(), "INS", "ACK" )).count() == 0L) {
				    	// зависимые задания, не выполняются, поставить на выполнение основное и зависимые
				    	log.info("------------Основное задание Task.id={} Зависимые задания НЕ выполняются, ВКЛ!", current.getId());
				    	current.setState("INS");
				    	slave.stream().forEach(e -> {
					    	log.info("------------Зависимое задание Task.id={}, ВКЛ!", e.getId());
					    	e.setState("INS");
				    	});
					} else {
				    	log.info("------------Основное задание Task.id={} Зависимые задания выполняются, НЕ ВКЛ!", current.getId());
					}
				}
				
			}
				
	    });
		
		/*foundTask.getInside().stream()
			.filter(t-> t.getTp().getCd().equals("Связь повторяемого задания"))
		    .filter(t-> t.getChild().getParent() == null)
		    .forEach(t-> {
		    	// получить основные задания
			    if (!t.getChild().getState().equals("INS") && !t.getChild().getState().equals("ACK")) {
			    	log.info("------------Найдено основное задание Task.id={}", t.getId());
			    	// если не выполняется 
			    	if (t.getSlave().size() == 0) {
				    	log.info("------------Основное задание Task.id={} НЕТ зависимых заданий, ВКЛ!", t.getChild().getId());
				    	// и нет зависимых заданий, то поставить на выполнение
			    		t.getChild().setState("INS");
			    	} else {
			    		// есть зависимые задания, проверить их статусы
				    	log.info("------------Основное задание Task.id={} Есть зависимые задания!", t.getChild().getId());
			    		if (t.getChild().getInside().stream()
							.filter(e-> e.getTp().getCd().equals("Связь повторяемого задания"))
						    .filter(e-> e.getChild().getParent() == null)
						    .filter(e -> e.getChild().getState().equals("INS") || // выполняются 
						    		e.getChild().getState().equals("ACK"))
				    		.count() == 0L ) {
					    	// дочерние задания, не выполняются, поставить на выполнение основное
				    		t.getChild().setState("INS");
					    	log.info("------------Основное задание Task.id={} Дочерние задания НЕ выполняются, ВКЛ!", t.getChild().getId());
				    		// поставить на выполнение дочерние
				    		t.getChild().getInside().stream()
							.filter(e-> e.getTp().getCd().equals("Связь повторяемого задания"))
						    .filter(e-> e.getChild().getParent() == null)
						    .forEach(e-> {
							    		e.getChild().setState("INS");
								    	log.info("------------Дочернее задание Task.id={} ВКЛ!", e.getChild().getId());
						    		});
				    		
			    		} else {
					    	log.info("------------Основное задание Task.id={} Дочерние задания выполняются, НЕ ВКЛ!", t.getChild().getId());
			    		}
			    		
			    	}
				    //log.info("******* Задание поставлено на выполнение: Task.id={}, state={}", t.getChild().getId(), t.getChild().getState());
			    }
		}) ;*/
	}

	/**
	 * Создать дочерние задания
	 * @param src - задание - шаблон
	 * @param parent - родительское задание
	 * @param tp - тип выполнения, 0 - скопировать задания, параметры, 1 - скопировать связи
	 */
	/*private void copyTask(Task src, Task parent, int tp) {
		Task foundElem = null;
		if (tp==0) {
			// скопировать задание
			foundElem = em.find(Task.class, src.getId());
			em.detach(foundElem);
			foundElem.setId(null);
			// указать нового родителя
			foundElem.setParent(parent);
			// установить статус
			foundElem.setState("INS");
			// почистить коллекции
			foundElem.setAppTp(7);
			foundElem.setChild(null);
			foundElem.setInside(null);
			foundElem.setOutside(null);
			foundElem.setTaskPar(null);
			foundElem.setMsgGuid(null);
			foundElem.setTguid(null);
			foundElem.setUpdDt(null);
			foundElem.setDepTask(null);
			// сохранить
			em.persist(foundElem);
			// копировать параметры
			copyTaskPar(src, foundElem);
			// сохранить соответствие старого задания - новому
			mapTask.put(src, foundElem);
		} else {
			// скопировать связи
			copyChldTaskLink(src);
		}

		// Найти все дочерние задания, обработать их
		for (Task t :src.getChild()) {
			// рекурсивно вызвать себя же
			copyTask(t, foundElem, tp);
		};
		
	}*/

	/**
	 * Копировать параметры задания
	 * @param src - источник
	 * @param dst - назначение
	 */
    /*private void copyTaskPar(Task src, Task dst) {
    	src.getTaskPar().stream().forEach(t-> {
        	TaskPar foundElem = em.find(TaskPar.class, t.getId());
        	em.detach(foundElem);
        	foundElem.setId(null);
        	foundElem.setTask(dst);
        	em.persist(foundElem);
    	});
    }*/
    
	/**
	 * Копировать дочерние связи задания, зависимости
	 * @param src - источник
	 */
   /*private void copyChldTaskLink(Task src) {
    	// скопировать зависимости по DEP_ID
    	if (src.getDepTask() != null) {
    		// Получить новый Task по старому
    		Task crTask = mapTask.get(src);
    		// Получить новый зависимый Task по старому
    		Task crDepTask = mapTask.get(src.getDepTask());
    		if (crDepTask!=null) {
        		crTask.setDepTask(crDepTask);
    		} else {
    			// зависимое задание из другой иерархии, вне данного копирования
        		crTask.setDepTask(src.getDepTask());
    			log.info("Элемент зависимости возможно относится к другой иерархии, не связанной с текущим копированием Task id={}", 
    					src.getDepTask().getId());
    			
    		}
    	}
    	
    	// скопировать связи по TASKXTASK
    	src.getInside().stream().forEach(t-> {
    		TaskToTask foundElem = em.find(TaskToTask.class, t.getId());
        	em.detach(foundElem);
        	foundElem.setId(null);
    		// получить новый элемент по старому
    		Task parent = mapTask.get(src);
        	foundElem.setParent(parent);
    		// получить новый элемент по старому
    		Task chld = mapTask.get(t.getChild());

    		if (chld == null) {
    			log.info("Элемент связи возможно относится к другой иерархии, не связанной с текущим копированием Task id={}", t.getChild().getId());
        		foundElem.setChild(t.getChild());
    		} else {
        		foundElem.setChild(chld);
    		}

    		em.persist(foundElem);
    	});
    	
    }*/
    
    /**
     * Загрузка списка запланированных задач
     */
    @Scheduled(fixedDelay =20000)
    public void timer() {
    	loadSchedules();
    }
    
    /**
     * Загрузка списка запланированных задач
     */
    @Scheduled(fixedDelay =2000)
    public void timer2() {
    	//log.info("cheeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
    }

    /**
     * Определить статусы заданий
     * @throws java.text.ParseException 
     */
    @Scheduled(fixedDelay =1000)
    public void checkSchedule() throws java.text.ParseException {
        Date dt = new Date();
        if (lstSched!=null) {
		for (TaskPar t: lstSched){
		    	//log.info("Expression TaskPar.id={} s1={}", t.getId(), t.getS1()); 
	    		CronExpression exp = new CronExpression(t.getS1());
	    		// либо удовлетворено условие по дате-времени, либо ручной запуск state --> "INS"
	    		if (exp.isSatisfiedBy(dt) || t.getTask().getState().equals("INS")) {
	    			//log.info("Запустить задание!");
	    			// Запустить задание, если уже не запущено
	    			if (!lstTrg.contains(t.getId())) {
	        			//log.info("Задание запущено!");
	    				// добавить отметку о необходимости выполнения
	        			lstTrg.add(t.getId());
	    			} else {
	        			//log.info("Уже запущено!");
	    			}
	    		} else {
	    			// Убрать все отметки если есть отметка о выполнении задания
	    	    	if (lstTrgProc.contains(t.getId())) {
	        			//log.info("Убрать отметки!");
	
		    			for (Iterator<Integer> iter = lstTrg.listIterator(); iter.hasNext(); ) {
							if (iter.next().equals(t.getId())) {
								iter.remove();
							}
						}
		    			for (Iterator<Integer> iter = lstTrgProc.listIterator(); iter.hasNext(); ) {
							if (iter.next().equals(t.getId())) {
								iter.remove();
							}
						}
	    	    	}
	    		}
	    	}
        }

    }
    
    
    /**
     * Проверить, выполнять ли задание
     * @param task
     * @return 
     * @return 
     */
    public TaskPar getTrgTask(Task task) {
    	// проверить, если поступило в обработку, но еще не выполнено
    	for (TaskPar t : task.getTaskPar().stream()
    			.filter(t-> t.getPar().getCd().equals("ГИС ЖКХ.Crone"))
    			.collect(Collectors.toList())) {
        	if (lstTrg.contains(t.getId()) && !lstTrgProc.contains(t.getId())) {
            	//log.info("..............Выполнить задание TaskPar.id={}", t.getId());
        		return t;
        	}
    	};
    	return null;
    }
    
    /**
     * Отметить выполненное задание
     * @param task
     * @return 
     */
    public void setProcTask(TaskPar taskPar) {
    	//log.info("..............Попытка отметить что выполнено задание!"); 
    	//log.info("..............Попытка отметить что выполнено задание TaskPar.id={}", taskPar.getId());
    	// проверить, что еще не выполнено 
    	if (!lstTrgProc.contains(taskPar.getId())) {
    		// добавить отметку о выполнении
        	lstTrgProc.add(taskPar.getId());
        	//log.info("..............Отмечено что выполнено задание TaskPar.id={}", taskPar.getId());
        	//log.info("..............Отмечено что выполнено задание!"); 
    	}
    }

    /**
     * Загрузить расписания работы всех заданий типа GIS_SYSTEM_RPT
     */
    private void loadSchedules() {
    	// Получить все параметры определённого типа по всем задачам
    	lstSched = taskDao.getByTp("GIS_SYSTEM_RPT").stream().flatMap(t-> t.getTaskPar().stream())
    			.filter(d-> d.getPar().getCd().equals("ГИС ЖКХ.Crone"))
    			.collect(Collectors.toList());
    }
    
}