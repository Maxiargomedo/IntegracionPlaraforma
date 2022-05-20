/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author cgomezvega
 */
public class AnwoProducto {
    private int idProducto;
    private String nomProducto;
    private float precio;

    public AnwoProducto() {
    }

    public AnwoProducto(int idProducto, String nomProducto, float precio) {
        this.idProducto = idProducto;
        this.nomProducto = nomProducto;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "AnwoProducto{" + "idProducto=" + idProducto + ", nomProducto=" + nomProducto + ", precio=" + precio + '}';
    }
}