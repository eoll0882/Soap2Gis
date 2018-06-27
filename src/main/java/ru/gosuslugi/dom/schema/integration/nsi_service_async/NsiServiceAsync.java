
package ru.gosuslugi.dom.schema.integration.nsi_service_async;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * Асинхронный сервис экспорта общих справочников подсистемы НСИ
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "NsiServiceAsync", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/nsi-service-async/", wsdlLocation = "file:/C:/Progs/Soap2Gis/wsdl/hcs_wsdl_xsd_v.11.13.0.11/nsi/hcs-nsi-service-async.wsdl")
public class NsiServiceAsync
    extends Service
{

    private final static URL NSISERVICEASYNC_WSDL_LOCATION;
    private final static WebServiceException NSISERVICEASYNC_EXCEPTION;
    private final static QName NSISERVICEASYNC_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/nsi-service-async/", "NsiServiceAsync");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Progs/Soap2Gis/wsdl/hcs_wsdl_xsd_v.11.13.0.11/nsi/hcs-nsi-service-async.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NSISERVICEASYNC_WSDL_LOCATION = url;
        NSISERVICEASYNC_EXCEPTION = e;
    }

    public NsiServiceAsync() {
        super(__getWsdlLocation(), NSISERVICEASYNC_QNAME);
    }

    public NsiServiceAsync(WebServiceFeature... features) {
        super(__getWsdlLocation(), NSISERVICEASYNC_QNAME, features);
    }

    public NsiServiceAsync(URL wsdlLocation) {
        super(wsdlLocation, NSISERVICEASYNC_QNAME);
    }

    public NsiServiceAsync(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NSISERVICEASYNC_QNAME, features);
    }

    public NsiServiceAsync(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NsiServiceAsync(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns NsiPortsTypeAsync
     */
    @WebEndpoint(name = "NsiPortAsync")
    public NsiPortsTypeAsync getNsiPortAsync() {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/nsi-service-async/", "NsiPortAsync"), NsiPortsTypeAsync.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns NsiPortsTypeAsync
     */
    @WebEndpoint(name = "NsiPortAsync")
    public NsiPortsTypeAsync getNsiPortAsync(WebServiceFeature... features) {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/nsi-service-async/", "NsiPortAsync"), NsiPortsTypeAsync.class, features);
    }

    private static URL __getWsdlLocation() {
        if (NSISERVICEASYNC_EXCEPTION!= null) {
            throw NSISERVICEASYNC_EXCEPTION;
        }
        return NSISERVICEASYNC_WSDL_LOCATION;
    }

}
