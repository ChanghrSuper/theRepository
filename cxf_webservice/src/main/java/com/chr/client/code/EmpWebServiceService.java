
package com.chr.client.code;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "EmpWebServiceService", targetNamespace = "http://webservice.hhb.com/", wsdlLocation = "http://192.168.0.47:8899/cxf_webservice_ser/cxf/es?wsdl")
public class EmpWebServiceService
    extends Service
{

    private final static URL EMPWEBSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException EMPWEBSERVICESERVICE_EXCEPTION;
    private final static QName EMPWEBSERVICESERVICE_QNAME = new QName("http://webservice.hhb.com/", "EmpWebServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.0.47:8899/cxf_webservice_ser/cxf/es?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        EMPWEBSERVICESERVICE_WSDL_LOCATION = url;
        EMPWEBSERVICESERVICE_EXCEPTION = e;
    }

    public EmpWebServiceService() {
        super(__getWsdlLocation(), EMPWEBSERVICESERVICE_QNAME);
    }

    public EmpWebServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), EMPWEBSERVICESERVICE_QNAME, features);
    }

    public EmpWebServiceService(URL wsdlLocation) {
        super(wsdlLocation, EMPWEBSERVICESERVICE_QNAME);
    }

    public EmpWebServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, EMPWEBSERVICESERVICE_QNAME, features);
    }

    public EmpWebServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EmpWebServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns EmpWebService
     */
    @WebEndpoint(name = "EmpWebServicePort")
    public EmpWebService getEmpWebServicePort() {
        return super.getPort(new QName("http://webservice.hhb.com/", "EmpWebServicePort"), EmpWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EmpWebService
     */
    @WebEndpoint(name = "EmpWebServicePort")
    public EmpWebService getEmpWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservice.hhb.com/", "EmpWebServicePort"), EmpWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (EMPWEBSERVICESERVICE_EXCEPTION!= null) {
            throw EMPWEBSERVICESERVICE_EXCEPTION;
        }
        return EMPWEBSERVICESERVICE_WSDL_LOCATION;
    }

}
