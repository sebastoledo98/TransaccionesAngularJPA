package com.web.modelo;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Cliente{

    @Id
    private int id;
    private String dni;
    private String nombre;
    private String direccion;
    private double saldo;

    public Cliente(){}

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getDni(){
        return this.dni;
    }

    public void setDni(String dni){
        this.dni = dni;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getDireccion(){
        return this.direccion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    @Override
    public String toString(){
        return "Cliente [codigo = " + id + ", dni = " + dni + ", nombre = " + nombre + ", direccion = " + direccion + ", saldo = " + saldo + "]";
    }

}
