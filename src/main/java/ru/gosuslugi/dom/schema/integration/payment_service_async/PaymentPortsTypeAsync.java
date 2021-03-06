
package ru.gosuslugi.dom.schema.integration.payment_service_async;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import ru.gosuslugi.dom.schema.integration.base.AckRequest;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.payment.ExportPaymentDocumentDetailsRequest;
import ru.gosuslugi.dom.schema.integration.payment.GetStateResult;
import ru.gosuslugi.dom.schema.integration.payment.ImportNotificationsOfOrderExecutionCancellationRequest;
import ru.gosuslugi.dom.schema.integration.payment.ImportNotificationsOfOrderExecutionRequest;
import ru.gosuslugi.dom.schema.integration.payment.ImportSupplierNotificationsOfOrderExecutionRequest;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PaymentPortsTypeAsync", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/payment-service-async/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.payment.ObjectFactory.class,
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
public interface PaymentPortsTypeAsync {


    /**
     * ВИ_ОПЛАТА_ИЗВ. Передать перечень документов "Извещение о принятии к исполнению распоряжения"
     * 
     * @param importNotificationsOfOrderExecutionRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importNotificationsOfOrderExecution")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest importNotificationsOfOrderExecution(
        @WebParam(name = "importNotificationsOfOrderExecutionRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/payment/", partName = "importNotificationsOfOrderExecutionRequest")
        ImportNotificationsOfOrderExecutionRequest importNotificationsOfOrderExecutionRequest)
        throws Fault
    ;

    /**
     * ВИ_ ОПЛАТА_ИЗВАН. Импорт документов "Извещение об аннулировании извещения о принятии к исполнению распоряжения"
     * 
     * @param importNotificationsOfOrderExecutionCancellationRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importNotificationsOfOrderExecutionCancellation")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest importNotificationsOfOrderExecutionCancellation(
        @WebParam(name = "importNotificationsOfOrderExecutionCancellationRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/payment/", partName = "importNotificationsOfOrderExecutionCancellationRequest")
        ImportNotificationsOfOrderExecutionCancellationRequest importNotificationsOfOrderExecutionCancellationRequest)
        throws Fault
    ;

    /**
     * Получить статус обработки запроса
     * 
     * @param getRequestState
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.payment.GetStateResult
     * @throws Fault
     */
    @WebMethod(action = "urn:getState")
    @WebResult(name = "getStateResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/payment/", partName = "getRequestStateResult")
    public GetStateResult getState(
        @WebParam(name = "getStateRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "getRequestState")
        GetStateRequest getRequestState)
        throws Fault
    ;

    /**
     * 
     * @param exportPaymentDocumentDetailsRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:exportPaymentDocumentDetails")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest exportPaymentDocumentDetails(
        @WebParam(name = "exportPaymentDocumentDetailsRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/payment/", partName = "exportPaymentDocumentDetailsRequest")
        ExportPaymentDocumentDetailsRequest exportPaymentDocumentDetailsRequest)
        throws Fault
    ;

    /**
     * Импорт пакета документов «Извещение о принятии к исполнению распоряжения», размещаемых исполнителем 
     * 
     * @param importSupplierNotificationsOfOrderExecutionRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importSupplierNotificationsOfOrderExecution")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest importSupplierNotificationsOfOrderExecution(
        @WebParam(name = "importSupplierNotificationsOfOrderExecutionRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/payment/", partName = "importSupplierNotificationsOfOrderExecutionRequest")
        ImportSupplierNotificationsOfOrderExecutionRequest importSupplierNotificationsOfOrderExecutionRequest)
        throws Fault
    ;

}
