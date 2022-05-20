/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anwo.Modelo;

import java.util.ArrayList;

/**
 *
 * @author cgomezvega
 */
public class AnwoProductoLista extends ArrayList<AnwoProducto> {
 
    @Override
    public String toString() {
        String s = "";
        for (AnwoProducto prod:this) {
            s += prod.toString() + "\n"; 
        };
        return s;
    }
}
