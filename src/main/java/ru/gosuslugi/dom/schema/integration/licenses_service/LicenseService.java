
package ru.gosuslugi.dom.schema.integration.licenses_service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * Cервис управления экспортом 
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "LicenseService", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/licenses-service/", wsdlLocation = "file:/C:/Progs/Soap2Gis/wsdl/hcs_wsdl_xsd_v.11.13.0.11/licenses/hcs-licenses-service.wsdl")
public class LicenseService
    extends Service
{

    private final static URL LICENSESERVICE_WSDL_LOCATION;
    private final static WebServiceException LICENSESERVICE_EXCEPTION;
    private final static QName LICENSESERVICE_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/licenses-service/", "LicenseService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Progs/Soap2Gis/wsdl/hcs_wsdl_xsd_v.11.13.0.11/licenses/hcs-licenses-service.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        LICENSESERVICE_WSDL_LOCATION = url;
        LICENSESERVICE_EXCEPTION = e;
    }

    public LicenseService() {
        super(__getWsdlLocation(), LICENSESERVICE_QNAME);
    }

    public LicenseService(WebServiceFeature... features) {
        super(__getWsdlLocation(), LICENSESERVICE_QNAME, features);
    }

    public LicenseService(URL wsdlLocation) {
        super(wsdlLocation, LICENSESERVICE_QNAME);
    }

    public LicenseService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, LICENSESERVICE_QNAME, features);
    }

    public LicenseService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LicenseService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns LicensePortsTypes
     */
    @WebEndpoint(name = "LicensesPort")
    public LicensePortsTypes getLicensesPort() {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/licenses-service/", "LicensesPort"), LicensePortsTypes.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LicensePortsTypes
     */
    @WebEndpoint(name = "LicensesPort")
    public LicensePortsTypes getLicensesPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/licenses-service/", "LicensesPort"), LicensePortsTypes.class, features);
    }

    private static URL __getWsdlLocation() {
        if (LICENSESERVICE_EXCEPTION!= null) {
            throw LICENSESERVICE_EXCEPTION;
        }
        return LICENSESERVICE_WSDL_LOCATION;
    }

}
