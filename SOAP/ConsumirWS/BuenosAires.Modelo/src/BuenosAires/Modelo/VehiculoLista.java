/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuenosAires.Modelo;

import java.util.ArrayList;

/**
 *
 * @author cgomezvega
 */
public class VehiculoLista extends ArrayList<Vehiculo> {
 
    @Override
    public String toString() {
        String s = "";
        for (Vehiculo vehiculo:this) {
            s += vehiculo.toString() + "\n"; 
        };
        return s;
    }
}
