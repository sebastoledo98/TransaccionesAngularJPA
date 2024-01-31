package com.web.modelo;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class Factura{

    @Id
    @GeneratedValue
    private int id;
    private String numero;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    private double total;
    private Date fecha;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "codigo_factura")
    private List<Detalle> detalles;

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNumero(){
        return this.numero;
    }

    public void setNumero(String numero){
        this.numero = numero;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public double getTotal(){
        return this.total;
    }

    public void setTotal(double total){
        this.total = total;
    }

    public Date getFecha(){
        return this.fecha;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    public void addDetalle(Detalle detalle){
        if(detalles == null)
            detalles = new ArrayList<Detalle>();
        detalles.add(detalle);
    }

    public List<Detalle> getDetalles(){
        return this.detalles;
    }

    @Override
    public String toString(){
            return "Factura [codigo = " + id + ", numero = " + numero + ", fecha = " + fecha + ", cliente = " + cliente + ", total = " + total + ", detalles = " + detalles + "]";
    }
}
