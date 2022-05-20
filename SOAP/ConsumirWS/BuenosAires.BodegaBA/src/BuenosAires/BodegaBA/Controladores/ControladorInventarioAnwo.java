/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuenosAires.BodegaBA.Controladores;

import BuenosAires.BodegaBA.Vistas.VistaInventarioAnwo;
import BuenosAires.Herramientas.JsonSerializer;
import BuenosAires.Herramientas.XMLSerializer;
import Anwo.Modelo.AnwoProducto;
import Anwo.Modelo.AnwoProductoLista;
import BuenosAires.Servicios.ServicioSOAPWsAnwo;
import BuenosAires.Modelo.Vehiculo;
import BuenosAires.Modelo.VehiculoLista;
import BuenosAires.Servicios.ServicioApiRestTiendaStark;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cgomezvega
 */
public class ControladorInventarioAnwo implements ActionListener {
    
    private AnwoProductoLista modelo;
    private VehiculoLista modeloVehiculoLista;
    private VistaInventarioAnwo vista;
    
    public ControladorInventarioAnwo(
            AnwoProductoLista modelo, 
            VehiculoLista modeloVehiculoLista, 
            VistaInventarioAnwo vista) {
        
        // Crear conexion con los modelos
        this.modelo = modelo;
        this.modeloVehiculoLista = modeloVehiculoLista;
        
        // Crear conexion con las vistas
        this.vista = vista;
        
        // Preparar vista para mostrar Lista de Productos Anwo
        this.vista.btnMostrarInventario.addActionListener(this);
        String col[] = {"ID Producto", "Nombre Producto", "Precio"};
        DefaultTableModel modeloTabla = new DefaultTableModel(col, 0);
        this.vista.jtAnwoProductoLista.setModel(modeloTabla);
        
        // Preparar vista para mostrar Lista de Vehículos
        this.vista.btnMostrarListaVehiculos.addActionListener(this);
        String colVehiculoLista[] = {"Patente", "Marca", "Modelo", "Imagen", "Categoría"};
        DefaultTableModel modeloTablaVehiculoLista = new DefaultTableModel(colVehiculoLista, 0);
        this.vista.jtVehiculoLista.setModel(modeloTablaVehiculoLista);
        
        // Abrir la vista y hacerla visible
        this.vista.setTitle("Prueba de Servicios Web");
        this.vista.setVisible(true);        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch(((JButton)ae.getSource()).getActionCommand()) {
            case "Mostrar inventario Anwo": mostrarInventarioAnwo(); break;
            case "Mostrar lista vehículos": mostrarVehiculoLista(); break;
        }
    }
    
    // TRABAJAR CON LA LISTA DE PRODUCTOS ANWO
    // OBTENIENDO LOS DATOS DESDE UN SERVICIO SOAP
    
    public AnwoProductoLista obtenerInventarioAnwo() {
        try {
            ServicioSOAPWsAnwo ws = new ServicioSOAPWsAnwo();
            String xml = ws.consultaProductosDisponibles();
            XMLSerializer xmlSerializer = new XMLSerializer();
            AnwoProductoLista lista = (AnwoProductoLista)xmlSerializer.fromXMLString(xml);
            return lista;
        } 
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void mostrarInventarioAnwo() {
        String col[] = {"ID Producto", "Nombre Producto", "Precio"};
        DefaultTableModel modeloTabla = new DefaultTableModel(col, 0);
        AnwoProductoLista lista = obtenerInventarioAnwo();
        if (lista == null) {
            modeloTabla.setRowCount(0);
            this.vista.jtAnwoProductoLista.setModel(modeloTabla);
            JOptionPane.showMessageDialog(null, "No fue posible cargar el inventario de Anwo, revise que el Servicio Web SOAP de Anwo este levantado.");
        } else {
            for (AnwoProducto prod : lista) {
                Object[] fila = new Object[8];
                fila[0] = prod.getIdProducto();
                fila[1] = prod.getNomProducto();
                fila[2] = prod.getPrecio();
                modeloTabla.addRow(fila);
            }
            this.vista.jtAnwoProductoLista.setModel(modeloTabla);
        }
    }
    
    // TRABAJAR CON LA LISTA DE VEHICOS DE TIENDA STARK
    // OBTENIENDO LOS DATOS DESDE UN SERVICIO API REST
    
    public VehiculoLista obtenerVehiculoLista() {
        try {
            ServicioApiRestTiendaStark ws = new ServicioApiRestTiendaStark();
            String json = ws.consultaListaVehiculos();
            JsonSerializer jsonSerializer = new JsonSerializer();
            VehiculoLista lista = (VehiculoLista)jsonSerializer.fromJsonString(json, VehiculoLista.class);
            return lista;
        } 
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void mostrarVehiculoLista() {
        String colVehiculoLista[] = {"Patente", "Marca", "Modelo", "Imagen", "Categoría"};
        DefaultTableModel modeloTablaVehiculoLista = new DefaultTableModel(colVehiculoLista, 0);
        VehiculoLista lista = obtenerVehiculoLista();
        if (lista == null) {
            modeloTablaVehiculoLista.setRowCount(0);
            this.vista.jtVehiculoLista.setModel(modeloTablaVehiculoLista);
            JOptionPane.showMessageDialog(null, "No fue posible cargar la lista de vehículos de Tienda Stark, revise que el Servicio Web API Rest de Tienda Stark este levantado.");
        } else {
            for (Vehiculo vehiculo : lista) {
                Object[] fila = new Object[8];
                fila[0] = vehiculo.getPatente();
                fila[1] = vehiculo.getMarca();
                fila[2] = vehiculo.getModelo();
                fila[3] = vehiculo.getImagen();
                fila[4] = vehiculo.getCategoria();
                modeloTablaVehiculoLista.addRow(fila);
            }
            this.vista.jtVehiculoLista.setModel(modeloTablaVehiculoLista);
        }
    }
}
