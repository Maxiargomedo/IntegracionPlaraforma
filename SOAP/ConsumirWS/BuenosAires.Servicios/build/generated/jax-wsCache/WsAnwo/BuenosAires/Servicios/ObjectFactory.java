
package BuenosAires.Servicios;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the BuenosAires.Servicios package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsultaProductosDisponibles_QNAME = new QName("http://servicios.anwo.anwo.com/", "ConsultaProductosDisponibles");
    private final static QName _ConsultaProductosDisponiblesResponse_QNAME = new QName("http://servicios.anwo.anwo.com/", "ConsultaProductosDisponiblesResponse");
    private final static QName _Hello_QNAME = new QName("http://servicios.anwo.anwo.com/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://servicios.anwo.anwo.com/", "helloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: BuenosAires.Servicios
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link ConsultaProductosDisponibles }
     * 
     */
    public ConsultaProductosDisponibles createConsultaProductosDisponibles() {
        return new ConsultaProductosDisponibles();
    }

    /**
     * Create an instance of {@link ConsultaProductosDisponiblesResponse }
     * 
     */
    public ConsultaProductosDisponiblesResponse createConsultaProductosDisponiblesResponse() {
        return new ConsultaProductosDisponiblesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaProductosDisponibles }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios.anwo.anwo.com/", name = "ConsultaProductosDisponibles")
    public JAXBElement<ConsultaProductosDisponibles> createConsultaProductosDisponibles(ConsultaProductosDisponibles value) {
        return new JAXBElement<ConsultaProductosDisponibles>(_ConsultaProductosDisponibles_QNAME, ConsultaProductosDisponibles.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaProductosDisponiblesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios.anwo.anwo.com/", name = "ConsultaProductosDisponiblesResponse")
    public JAXBElement<ConsultaProductosDisponiblesResponse> createConsultaProductosDisponiblesResponse(ConsultaProductosDisponiblesResponse value) {
        return new JAXBElement<ConsultaProductosDisponiblesResponse>(_ConsultaProductosDisponiblesResponse_QNAME, ConsultaProductosDisponiblesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios.anwo.anwo.com/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios.anwo.anwo.com/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

}
