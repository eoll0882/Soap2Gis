
package ru.gosuslugi.dom.schema.integration.licenses_service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import ru.gosuslugi.dom.schema.integration.licenses.ExportDisqualifiedPersonRequest;
import ru.gosuslugi.dom.schema.integration.licenses.ExportDisqualifiedPersonResult;
import ru.gosuslugi.dom.schema.integration.licenses.ExportLicenseRequest;
import ru.gosuslugi.dom.schema.integration.licenses.ExportLicenseResult;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "LicensePortsTypes", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/licenses-service/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.licenses.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.nsi_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.organizations_registry_base.ObjectFactory.class,
    org.w3._2000._09.xmldsig_.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.individual_registry_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.organizations_base.ObjectFactory.class
})
public interface LicensePortsTypes {


    /**
     * 
     * @param exporttLicenseRequestType
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.licenses.ExportLicenseResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportLicense")
    @WebResult(name = "exportLicenseResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/licenses/", partName = "exportLicenseResult")
    public ExportLicenseResult exportLicense(
        @WebParam(name = "exportLicenseRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/licenses/", partName = "exporttLicenseRequestType")
        ExportLicenseRequest exporttLicenseRequestType)
        throws Fault
    ;

    /**
     * 
     * @param exportDisqualifiedPersonRequestType
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.licenses.ExportDisqualifiedPersonResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportDisqualifiedPerson")
    @WebResult(name = "exportDisqualifiedPersonResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/licenses/", partName = "exportDisqualifiedPersonResultType")
    public ExportDisqualifiedPersonResult exportDisqualifiedPerson(
        @WebParam(name = "exportDisqualifiedPersonRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/licenses/", partName = "exportDisqualifiedPersonRequestType")
        ExportDisqualifiedPersonRequest exportDisqualifiedPersonRequestType)
        throws Fault
    ;

}