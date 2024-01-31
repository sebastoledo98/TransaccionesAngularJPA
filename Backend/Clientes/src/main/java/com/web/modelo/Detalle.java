package com.web.modelo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

@Entity
public class Detalle{

    public Detalle(){}

    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto")
    private Producto producto;

    private int cantidad;

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public Producto getProducto(){
        return this.producto;
    }

    public void setProducto(Producto producto){
        this.producto = producto;
    }

    public int getCantidad(){
        return this.cantidad;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    @Override
    public String toString(){
        return "Detalle [codigo = " + id + ", producto = " + producto + ", cantidad = " + cantidad + "]";
    }
}
