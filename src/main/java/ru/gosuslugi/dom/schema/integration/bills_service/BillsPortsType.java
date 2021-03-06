
package ru.gosuslugi.dom.schema.integration.bills_service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import ru.gosuslugi.dom.schema.integration.base.ImportResult;
import ru.gosuslugi.dom.schema.integration.bills.ExportInsuranceProductRequest;
import ru.gosuslugi.dom.schema.integration.bills.ExportInsuranceProductResult;
import ru.gosuslugi.dom.schema.integration.bills.ExportNotificationsOfOrderExecutionPaginalRequest;
import ru.gosuslugi.dom.schema.integration.bills.ExportNotificationsOfOrderExecutionPaginalResult;
import ru.gosuslugi.dom.schema.integration.bills.ExportNotificationsOfOrderExecutionRequest;
import ru.gosuslugi.dom.schema.integration.bills.ExportNotificationsOfOrderExecutionResult;
import ru.gosuslugi.dom.schema.integration.bills.ExportPaymentDocumentRequest;
import ru.gosuslugi.dom.schema.integration.bills.ExportPaymentDocumentResult;
import ru.gosuslugi.dom.schema.integration.bills.ExportSettlementsRequest;
import ru.gosuslugi.dom.schema.integration.bills.ExportSettlementsResult;
import ru.gosuslugi.dom.schema.integration.bills.ImportAcknowledgmentRequest;
import ru.gosuslugi.dom.schema.integration.bills.ImportIKUSettlementsRequest;
import ru.gosuslugi.dom.schema.integration.bills.ImportInsuranceProductRequest;
import ru.gosuslugi.dom.schema.integration.bills.ImportPaymentDocumentRequest;
import ru.gosuslugi.dom.schema.integration.bills.ImportRSOSettlementsRequest;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "BillsPortsType", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/bills-service/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.bills.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.organizations_registry_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.payments_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.nsi_base.ObjectFactory.class,
    org.w3._2000._09.xmldsig_.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.account_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.bills_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.individual_registry_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.organizations_base.ObjectFactory.class
})
public interface BillsPortsType {


    /**
     * ВИ_ИЛС_ПД_ИМП. импорт платежных документов
     * 
     * @param importPaymentDocumentDataRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.ImportResult
     * @throws Fault
     */
    @WebMethod(action = "urn:importPaymentDocumentData")
    @WebResult(name = "ImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "importPaymentDocumentDataResult")
    public ImportResult importPaymentDocumentData(
        @WebParam(name = "importPaymentDocumentRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/bills/", partName = "importPaymentDocumentDataRequest")
        ImportPaymentDocumentRequest importPaymentDocumentDataRequest)
        throws Fault
    ;

    /**
     * ВИ_ИЛС_ПД_ЭКСП. экспорт платежных документов
     * 
     * @param exportPaymentDocumentDataRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.bills.ExportPaymentDocumentResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportPaymentDocumentData")
    @WebResult(name = "exportPaymentDocumentResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/bills/", partName = "exportPaymentDocumentDataResult")
    public ExportPaymentDocumentResult exportPaymentDocumentData(
        @WebParam(name = "exportPaymentDocumentRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/bills/", partName = "exportPaymentDocumentDataRequest")
        ExportPaymentDocumentRequest exportPaymentDocumentDataRequest)
        throws Fault
    ;

    /**
     * Экспорт извещений о принятии к исполнению распоряжений с результатами квитирования
     * 
     * @param exportNotificationsOfOrderExecutionRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.bills.ExportNotificationsOfOrderExecutionResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportNotificationsOfOrderExecution")
    @WebResult(name = "exportNotificationsOfOrderExecutionResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/bills/", partName = "exportNotificationsOfOrderExecutionResult")
    public ExportNotificationsOfOrderExecutionResult exportNotificationsOfOrderExecution(
        @WebParam(name = "exportNotificationsOfOrderExecutionRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/bills/", partName = "exportNotificationsOfOrderExecutionRequest")
        ExportNotificationsOfOrderExecutionRequest exportNotificationsOfOrderExecutionRequest)
        throws Fault
    ;

    /**
     * ВИ_ОПЛАТА_ИМКВИТ. Импорт пакета документов "Запрос на квитирование"
     * 
     * @param importAcknowledgmentRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.ImportResult
     * @throws Fault
     */
    @WebMethod(action = "urn:importAcknowledgment")
    @WebResult(name = "ImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "importAcknowledgmentResult")
    public ImportResult importAcknowledgment(
        @WebParam(name = "importAcknowledgmentRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/bills/", partName = "importAcknowledgmentRequest")
        ImportAcknowledgmentRequest importAcknowledgmentRequest)
        throws Fault
    ;

    /**
     * Импорт страховых продуктов
     * 
     * @param importInsuranceProductRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.ImportResult
     * @throws Fault
     */
    @WebMethod(action = "urn:importInsuranceProduct")
    @WebResult(name = "ImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "importInsuranceProductResult")
    public ImportResult importInsuranceProduct(
        @WebParam(name = "importInsuranceProductRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/bills/", partName = "importInsuranceProductRequest")
        ImportInsuranceProductRequest importInsuranceProductRequest)
        throws Fault
    ;

    /**
     * Экспорт страховых продуктов
     * 
     * @param exportInsuranceProductRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.bills.ExportInsuranceProductResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportInsuranceProduct")
    @WebResult(name = "exportInsuranceProductResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/bills/", partName = "exportInsuranceProductResult")
    public ExportInsuranceProductResult exportInsuranceProduct(
        @WebParam(name = "exportInsuranceProductRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/bills/", partName = "exportInsuranceProductRequest")
        ExportInsuranceProductRequest exportInsuranceProductRequest)
        throws Fault
    ;

    /**
     * Импорт информации о состоянии расчетов от имени РСО
     * 
     * @param importRSOSettlementsRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.ImportResult
     * @throws Fault
     */
    @WebMethod(action = "urn:importRSOSettlements")
    @WebResult(name = "ImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "importRSOSettlementsResult")
    public ImportResult importRSOSettlements(
        @WebParam(name = "importRSOSettlementsRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/bills/", partName = "importRSOSettlementsRequest")
        ImportRSOSettlementsRequest importRSOSettlementsRequest)
        throws Fault
    ;

    /**
     * Импорт информации о состоянии расчетов от имени организации - исполнителя коммунальных услуг (УО, ТСЖ и тд)
     * 
     * @param importIKUSettlementsRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.ImportResult
     * @throws Fault
     */
    @WebMethod(action = "urn:importIKUSettlements")
    @WebResult(name = "ImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "importIKUSettlementsResult")
    public ImportResult importIKUSettlements(
        @WebParam(name = "importIKUSettlementsRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/bills/", partName = "importIKUSettlementsRequest")
        ImportIKUSettlementsRequest importIKUSettlementsRequest)
        throws Fault
    ;

    /**
     * Экспорт информации о расчетах по ДРСО
     * 
     * @param exportSettlementsRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.bills.ExportSettlementsResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportSettlements")
    @WebResult(name = "exportSettlementsResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/bills/", partName = "exportSettlementsResult")
    public ExportSettlementsResult exportSettlements(
        @WebParam(name = "exportSettlementsRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/bills/", partName = "exportSettlementsRequest")
        ExportSettlementsRequest exportSettlementsRequest)
        throws Fault
    ;

    /**
     * Экспорт извещений о принятии к исполнению распоряжений с результатами квитирования (постраничная выгрузка)
     * 
     * @param exportNotificationsOfOrderExecutionPaginalRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.bills.ExportNotificationsOfOrderExecutionPaginalResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportNotificationsOfOrderExecutionPaginal")
    @WebResult(name = "exportNotificationsOfOrderExecutionPaginalResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/bills/", partName = "exportNotificationsOfOrderExecutionPaginalResult")
    public ExportNotificationsOfOrderExecutionPaginalResult exportNotificationsOfOrderExecutionPaginal(
        @WebParam(name = "exportNotificationsOfOrderExecutionPaginalRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/bills/", partName = "exportNotificationsOfOrderExecutionPaginalRequest")
        ExportNotificationsOfOrderExecutionPaginalRequest exportNotificationsOfOrderExecutionPaginalRequest)
        throws Fault
    ;

}
