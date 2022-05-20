/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuenosAires.Servicios;

/**
 *
 * @author cgomezvega
 */
public class ServicioSOAPWsAnwo {
    
    public ServicioSOAPWsAnwo() {
        
    }

    public static String consultaProductosDisponibles() {
        BuenosAires.Servicios.WsAnwo_Service service = new BuenosAires.Servicios.WsAnwo_Service();
        BuenosAires.Servicios.WsAnwo port = service.getWsAnwoPort();
        return port.consultaProductosDisponibles();
    }
}
