
package ru.gosuslugi.dom.schema.integration.device_metering_service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * Сервис управления приборами учета и передачей показаний
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "DeviceMeteringService", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/device-metering-service/", wsdlLocation = "file:/C:/Progs/Soap2Gis/wsdl/hcs_wsdl_xsd_v.11.13.0.11/device-metering/hcs-device-metering-service.wsdl")
public class DeviceMeteringService
    extends Service
{

    private final static URL DEVICEMETERINGSERVICE_WSDL_LOCATION;
    private final static WebServiceException DEVICEMETERINGSERVICE_EXCEPTION;
    private final static QName DEVICEMETERINGSERVICE_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/device-metering-service/", "DeviceMeteringService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Progs/Soap2Gis/wsdl/hcs_wsdl_xsd_v.11.13.0.11/device-metering/hcs-device-metering-service.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DEVICEMETERINGSERVICE_WSDL_LOCATION = url;
        DEVICEMETERINGSERVICE_EXCEPTION = e;
    }

    public DeviceMeteringService() {
        super(__getWsdlLocation(), DEVICEMETERINGSERVICE_QNAME);
    }

    public DeviceMeteringService(WebServiceFeature... features) {
        super(__getWsdlLocation(), DEVICEMETERINGSERVICE_QNAME, features);
    }

    public DeviceMeteringService(URL wsdlLocation) {
        super(wsdlLocation, DEVICEMETERINGSERVICE_QNAME);
    }

    public DeviceMeteringService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DEVICEMETERINGSERVICE_QNAME, features);
    }

    public DeviceMeteringService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DeviceMeteringService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns DeviceMeteringPortTypes
     */
    @WebEndpoint(name = "DeviceMeteringPort")
    public DeviceMeteringPortTypes getDeviceMeteringPort() {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/device-metering-service/", "DeviceMeteringPort"), DeviceMeteringPortTypes.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DeviceMeteringPortTypes
     */
    @WebEndpoint(name = "DeviceMeteringPort")
    public DeviceMeteringPortTypes getDeviceMeteringPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/device-metering-service/", "DeviceMeteringPort"), DeviceMeteringPortTypes.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DEVICEMETERINGSERVICE_EXCEPTION!= null) {
            throw DEVICEMETERINGSERVICE_EXCEPTION;
        }
        return DEVICEMETERINGSERVICE_WSDL_LOCATION;
    }

}
