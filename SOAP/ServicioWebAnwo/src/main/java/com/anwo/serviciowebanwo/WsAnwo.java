package com.anwo.serviciowebanwo;

import database.AnwoStoreProcedures;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.AnwoProducto;
import model.AnwoProductoLista;

@WebService(serviceName = "WsAnwo")
public class WsAnwo {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "ConsultaProductosDisponibles")
    public String ConsultaProductosDisponibles() {

        AnwoProductoLista lista = new AnwoStoreProcedures().LISTAR_PRODUCTOS();
        XMLSerializer xmlSerializer = new XMLSerializer();
        return xmlSerializer.toXMLString(lista);
    }
}
