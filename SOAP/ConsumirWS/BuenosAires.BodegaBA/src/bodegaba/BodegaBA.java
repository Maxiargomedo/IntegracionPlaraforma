package bodegaba;

import Anwo.Modelo.AnwoProductoLista;
import BuenosAires.BodegaBA.Controladores.ControladorInventarioAnwo;
import BuenosAires.BodegaBA.Vistas.VistaInventarioAnwo;
import BuenosAires.Modelo.*;
import BuenosAires.Herramientas.*;
import BuenosAires.Servicios.*;
import BuenosAires.Modelo.Vehiculo;
import BuenosAires.Modelo.VehiculoLista;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//import org.codehaus.jackson.JsonGenerationException;
//import org.codehaus.jackson.map.JsonMappingException;
//import org.codehaus.jackson.map.ObjectMapper;

public class BodegaBA {

    public static void main(String[] args) {
        
        // Abrir ventana con Lista de Inventario
        ControladorInventarioAnwo con = new ControladorInventarioAnwo(
                  new AnwoProductoLista()
                , new VehiculoLista()
                , new VistaInventarioAnwo());
    }
    
    public static void ProbarApiConDeserealizacion() {
        // Obtener 1 solo vehiculo
        String json = getApiRest("http://127.0.0.1:8000/api/vehiculo_read/JOHN80/");
        // Deserializar el texto Json en un objeto de Vehiculo
        Gson gson = new Gson();
        Vehiculo obj = gson.fromJson(json, Vehiculo.class);
        System.out.println(obj.toString());
        
        System.out.println("");
        
        // Obtener una lista de vehiculos
        json = getApiRest("http://127.0.0.1:8000/api/vehiculo_read_all/");
        // Deserializar el texto Json en un objeto de VehiculoLista
        gson = new Gson();
        VehiculoLista lista = gson.fromJson(json, VehiculoLista.class);
        System.out.println(lista.toString());
    }
    
    public static String getApiRest(String apiUrl) {
        String json = "";
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
                json += output;
            }
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
        return json;
    }
}