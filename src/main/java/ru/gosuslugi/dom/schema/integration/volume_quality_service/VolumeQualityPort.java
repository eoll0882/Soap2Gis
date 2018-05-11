
package ru.gosuslugi.dom.schema.integration.volume_quality_service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import ru.gosuslugi.dom.schema.integration.base.ImportResult;
import ru.gosuslugi.dom.schema.integration.volume_quality.ImportIntervalRequest;
import ru.gosuslugi.dom.schema.integration.volume_quality.ImportVolumeAndQualityInformationRequest;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "VolumeQualityPort", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/volume-quality-service/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.volume_quality.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.organizations_registry_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.nsi_base.ObjectFactory.class,
    org.w3._2000._09.xmldsig_.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.account_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.bills_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.individual_registry_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.metering_device_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.organizations_base.ObjectFactory.class
})
public interface VolumeQualityPort {


    /**
     * Импорт информации об объеме и качестве КР и КУ
     * 
     * @param importVolumeAndQualityInformationRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.ImportResult
     * @throws Fault
     */
    @WebMethod(action = "urn:importVolumeAndQualityInformation")
    @WebResult(name = "ImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "importVolumeAndQualityInformationResult")
    public ImportResult importVolumeAndQualityInformation(
        @WebParam(name = "importVolumeAndQualityInformationRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/volume-quality/", partName = "importVolumeAndQualityInformationRequest")
        ImportVolumeAndQualityInformationRequest importVolumeAndQualityInformationRequest)
        throws Fault
    ;

    /**
     * Импорт информации о перерывах
     * 
     * @param importIntervalRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.ImportResult
     * @throws Fault
     */
    @WebMethod(action = "urn:importInterval")
    @WebResult(name = "ImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "importIntervalResult")
    public ImportResult importInterval(
        @WebParam(name = "importIntervalRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/volume-quality/", partName = "importIntervalRequest")
        ImportIntervalRequest importIntervalRequest)
        throws Fault
    ;

}