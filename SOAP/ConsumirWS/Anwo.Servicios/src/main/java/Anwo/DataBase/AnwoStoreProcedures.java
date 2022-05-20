/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anwo.DataBase;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import Anwo.Modelo.AnwoProducto;
import Anwo.Modelo.AnwoProductoLista;

/**
 *
 * @author cgomezvega
 */
public class AnwoStoreProcedures {
    
    // Para ejecutar el store procedure en SQL Developer usar:
    // variable rc refcursor;
    // exec LISTAR_PRODUCTOS( :rc );
    
    public AnwoProductoLista LISTAR_PRODUCTOS() {
        try {
            Connection conn = new OracleDataBaseConnection().getConnection();
            CallableStatement stmt = conn.prepareCall("BEGIN LISTAR_PRODUCTOS(?); END;");
            stmt.registerOutParameter(1, OracleTypes.CURSOR); // Tipo de dato Oracle refcusor
            stmt.execute();
            ResultSet rs = ((OracleCallableStatement)stmt).getCursor(1);
            AnwoProductoLista lista = new AnwoProductoLista();
            while (rs.next()) {
                lista.add(new AnwoProducto(
                        rs.getInt("ID_PRODUCTO"), 
                        rs.getString("NOM_PRODUCTO"), 
                        rs.getFloat("PRECIO")));
            }
            rs.close();
            rs = null;
            stmt.close();
            stmt = null;
            conn.close();
            conn = null;
            return lista;
        }
        catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }
}