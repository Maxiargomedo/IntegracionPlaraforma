/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuenosAires.Herramientas;

import com.google.gson.Gson;

/**
 *
 * @author cgomezvega
 */
public class JsonSerializer {
    
    public static String toJsonString(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    public static <T> T fromJsonString(String str, Class<T> tipo) {
        Gson gson = new Gson();
        return (T)gson.fromJson(str, tipo);
    }
}
