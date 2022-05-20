/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuenosAires.Servicios;

import BuenosAires.Herramientas.ApiRestController;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author cgomezvega
 */
public class ServicioApiRestTiendaStark {
    
    public ServicioApiRestTiendaStark() {
        
    }
    
    public static String consultaListaVehiculos() {
        return new ApiRestController().get("http://127.0.0.1:8000/api/vehiculo_read_all/");
    }
    
    public static String consultaVehiculo(String patente) {
        return new ApiRestController().get("http://127.0.0.1:8000/api/vehiculo_read/" + patente + "/");
    }
}
