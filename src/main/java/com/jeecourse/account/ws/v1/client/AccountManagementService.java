
package com.jeecourse.account.ws.v1.client;

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
@WebServiceClient(name = "accountManagementService", targetNamespace = "http://www.jeecourse.com/account/v1", wsdlLocation = "file:/C:/Data/account-manager/src/main/resources/com/jeecourse/account/ws/v1/accountService-v1.0.wsdl")
public class AccountManagementService
    extends Service
{

    private final static URL ACCOUNTMANAGEMENTSERVICE_WSDL_LOCATION;
    private final static WebServiceException ACCOUNTMANAGEMENTSERVICE_EXCEPTION;
    private final static QName ACCOUNTMANAGEMENTSERVICE_QNAME = new QName("http://www.jeecourse.com/account/v1", "accountManagementService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Data/account-manager/src/main/resources/com/jeecourse/account/ws/v1/accountService-v1.0.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ACCOUNTMANAGEMENTSERVICE_WSDL_LOCATION = url;
        ACCOUNTMANAGEMENTSERVICE_EXCEPTION = e;
    }

    public AccountManagementService() {
        super(__getWsdlLocation(), ACCOUNTMANAGEMENTSERVICE_QNAME);
    }

    public AccountManagementService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ACCOUNTMANAGEMENTSERVICE_QNAME, features);
    }

    public AccountManagementService(URL wsdlLocation) {
        super(wsdlLocation, ACCOUNTMANAGEMENTSERVICE_QNAME);
    }

    public AccountManagementService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ACCOUNTMANAGEMENTSERVICE_QNAME, features);
    }

    public AccountManagementService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AccountManagementService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AccountManagementApi
     */
    @WebEndpoint(name = "accountManagementApiSoap11")
    public AccountManagementApi getAccountManagementApiSoap11() {
        return super.getPort(new QName("http://www.jeecourse.com/account/v1", "accountManagementApiSoap11"), AccountManagementApi.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AccountManagementApi
     */
    @WebEndpoint(name = "accountManagementApiSoap11")
    public AccountManagementApi getAccountManagementApiSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.jeecourse.com/account/v1", "accountManagementApiSoap11"), AccountManagementApi.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ACCOUNTMANAGEMENTSERVICE_EXCEPTION!= null) {
            throw ACCOUNTMANAGEMENTSERVICE_EXCEPTION;
        }
        return ACCOUNTMANAGEMENTSERVICE_WSDL_LOCATION;
    }

}