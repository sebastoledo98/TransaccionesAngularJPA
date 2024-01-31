package com.web.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Producto{

    @Id
    private int id;

    private String descripcion;
    private double precio;
    private int stock;

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

        public double getPrecio(){
        return this.precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public int getStock(){
        return this.stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    @Override
    public String toString(){
        return "Producto [codigo = " + id + ", descripcion = " + descripcion + ", precio = " + precio + ", stock = " + stock + "]";
    }
}
