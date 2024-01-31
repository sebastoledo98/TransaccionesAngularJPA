package com.web.modelo;

public class CantidadFacturaCliente{
    private int codigo_cliente;
    private String nombre;
    private int cantidad_factura;

    public CantidadFacturaCliente(int codigo_cliente, String nombre, int cantidad_factura){
        this.codigo_cliente = codigo_cliente;
        this.nombre = nombre;
        this.cantidad_factura = cantidad_factura;
    }

    public int getCodigo_cliente(){
        return this.codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente){
        this.codigo_cliente = codigo_cliente;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getCantidad_factura(){
        return this.cantidad_factura;
    }

    public void setCantidad_factura(int cantidad_factura){
        this.cantidad_factura = cantidad_factura;
    }

    @Override
    public String toString() {
        return "CantidadFacturasCliente [codigo_cliente=" + codigo_cliente + ", nombre=" + nombre
            + ", cantidad_factura=" + cantidad_factura + "]";
    }
}
