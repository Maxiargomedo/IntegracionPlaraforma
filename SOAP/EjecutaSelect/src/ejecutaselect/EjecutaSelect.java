package ejecutaselect;

import database.AnwoStoreProcedures;
import database.OracleDataBaseConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.AnwoProducto;
import model.AnwoProductoLista;
import model.XMLSerializer;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class EjecutaSelect {

    public static void main(String[] args) {
        
        AnwoProductoLista lista = new AnwoStoreProcedures().LISTAR_PRODUCTOS();

        // Mostrar en consola los datos obtenidos del procedimiento almacenado
//        printMessage("LISTA DE PRODUCTOS ANWO LUEGO DE EJECUTAR STORE PROCEDURE");
//        lista.forEach((prod) -> {
//            System.out.println(prod.toString()); 
//        });
//        System.out.println();
        
        try {
            XMLSerializer xmlSerializer = new XMLSerializer();
            
            // Crear objeto de AnwoProducto de prueba
            AnwoProducto producto = new AnwoProducto(1, "Aire acondicionado", 350);
            
            // Guardar en archivos los textos en XML de los objetos
            String folder = "C:\\_EjemplosIPY5101\\_ArchivosXML\\";
            String xmlFile1 = folder + "xml_AnwoProducto.txt";
            String xmlFile2 = folder + "xml_AnwoProductoLista.txt";
            xmlSerializer.writeXMLFile(producto, xmlFile1);
            xmlSerializer.writeXMLFile(lista, xmlFile2);
            
            // Serializar los objetos en un String en XML
            String xml1 = xmlSerializer.toXMLString(producto);
            String xml2 = xmlSerializer.toXMLString(lista);
            
            // Deserializar los String en XML para crear los objetos
            AnwoProducto obj1 = (AnwoProducto)xmlSerializer.fromXMLString(xml1);
            AnwoProductoLista obj2 = (AnwoProductoLista)xmlSerializer.fromXMLString(xml2);
            
            // Mostar los datos de los objetos reconstituidos usando toString()
            printMessage("OBJETO AnwoProducto DESEREALIZADO");
            System.out.println(obj1.toString());
            System.out.println();
            printMessage("OBJETO AnwoProductoLista DESEREALIZADO");
            System.out.println(obj2.toString());

        } 
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void printMessage(String message) {
        System.out.println("=========================================================");
        System.out.println(message);
        System.out.println("=========================================================");
    }
}