
package ru.gosuslugi.dom.schema.integration.infrastructure_service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * Сервис управления ОКИ
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "InfrastructureService", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/infrastructure-service/", wsdlLocation = "file:/C:/Progs/Soap2Gis/wsdl/hcs_wsdl_xsd_v.11.13.0.11/infrastructure/hcs-infrastructure-service.wsdl")
public class InfrastructureService
    extends Service
{

    private final static URL INFRASTRUCTURESERVICE_WSDL_LOCATION;
    private final static WebServiceException INFRASTRUCTURESERVICE_EXCEPTION;
    private final static QName INFRASTRUCTURESERVICE_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/infrastructure-service/", "InfrastructureService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Progs/Soap2Gis/wsdl/hcs_wsdl_xsd_v.11.13.0.11/infrastructure/hcs-infrastructure-service.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        INFRASTRUCTURESERVICE_WSDL_LOCATION = url;
        INFRASTRUCTURESERVICE_EXCEPTION = e;
    }

    public InfrastructureService() {
        super(__getWsdlLocation(), INFRASTRUCTURESERVICE_QNAME);
    }

    public InfrastructureService(WebServiceFeature... features) {
        super(__getWsdlLocation(), INFRASTRUCTURESERVICE_QNAME, features);
    }

    public InfrastructureService(URL wsdlLocation) {
        super(wsdlLocation, INFRASTRUCTURESERVICE_QNAME);
    }

    public InfrastructureService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, INFRASTRUCTURESERVICE_QNAME, features);
    }

    public InfrastructureService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public InfrastructureService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns InfrastructurePortsType
     */
    @WebEndpoint(name = "InfrastructurePort")
    public InfrastructurePortsType getInfrastructurePort() {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/infrastructure-service/", "InfrastructurePort"), InfrastructurePortsType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns InfrastructurePortsType
     */
    @WebEndpoint(name = "InfrastructurePort")
    public InfrastructurePortsType getInfrastructurePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/infrastructure-service/", "InfrastructurePort"), InfrastructurePortsType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (INFRASTRUCTURESERVICE_EXCEPTION!= null) {
            throw INFRASTRUCTURESERVICE_EXCEPTION;
        }
        return INFRASTRUCTURESERVICE_WSDL_LOCATION;
    }

}
