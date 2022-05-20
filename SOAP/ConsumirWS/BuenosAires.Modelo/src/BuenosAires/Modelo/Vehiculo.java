/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuenosAires.Modelo;

/**
 *
 * @author cgomezvega
 */
public class Vehiculo {
    private String patente;
    private String marca;
    private String modelo;
    private String imagen;
    private int categoria;

    public Vehiculo() {
    }

    public Vehiculo(String patente, String marca, String modelo, String imagen, int categoria) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.imagen = imagen;
        this.categoria = categoria;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "patente=" + patente + ", marca=" + marca + ", modelo=" + modelo + ", imagen=" + imagen + ", categoria=" + categoria + '}';
    }
}
