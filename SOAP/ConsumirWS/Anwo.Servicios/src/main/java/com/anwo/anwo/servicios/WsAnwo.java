/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anwo.anwo.servicios;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import Anwo.DataBase.AnwoStoreProcedures;
import Anwo.Herramientas.XMLSerializer;
import Anwo.Modelo.AnwoProducto;
import Anwo.Modelo.AnwoProductoLista;

/**
 *
 * @author cgomezvega
 */
@WebService(serviceName = "WsAnwo")
public class WsAnwo {

    /**
     * This is a sample web service operation
     */
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
