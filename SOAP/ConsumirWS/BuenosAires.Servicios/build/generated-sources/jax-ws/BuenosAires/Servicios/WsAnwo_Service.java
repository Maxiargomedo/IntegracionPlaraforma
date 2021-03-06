
package BuenosAires.Servicios;

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
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WsAnwo", targetNamespace = "http://servicios.anwo.anwo.com/", wsdlLocation = "http://localhost:8080/Anwo.Servicios/WsAnwo?wsdl")
public class WsAnwo_Service
    extends Service
{

    private final static URL WSANWO_WSDL_LOCATION;
    private final static WebServiceException WSANWO_EXCEPTION;
    private final static QName WSANWO_QNAME = new QName("http://servicios.anwo.anwo.com/", "WsAnwo");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/Anwo.Servicios/WsAnwo?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSANWO_WSDL_LOCATION = url;
        WSANWO_EXCEPTION = e;
    }

    public WsAnwo_Service() {
        super(__getWsdlLocation(), WSANWO_QNAME);
    }

    public WsAnwo_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSANWO_QNAME, features);
    }

    public WsAnwo_Service(URL wsdlLocation) {
        super(wsdlLocation, WSANWO_QNAME);
    }

    public WsAnwo_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSANWO_QNAME, features);
    }

    public WsAnwo_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WsAnwo_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WsAnwo
     */
    @WebEndpoint(name = "WsAnwoPort")
    public WsAnwo getWsAnwoPort() {
        return super.getPort(new QName("http://servicios.anwo.anwo.com/", "WsAnwoPort"), WsAnwo.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WsAnwo
     */
    @WebEndpoint(name = "WsAnwoPort")
    public WsAnwo getWsAnwoPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://servicios.anwo.anwo.com/", "WsAnwoPort"), WsAnwo.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSANWO_EXCEPTION!= null) {
            throw WSANWO_EXCEPTION;
        }
        return WSANWO_WSDL_LOCATION;
    }

}
