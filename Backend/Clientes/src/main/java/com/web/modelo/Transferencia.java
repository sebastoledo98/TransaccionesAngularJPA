package com.web.modelo;

public class Transferencia{

    private int id1;
    private int id2;
    private double monto;

    public int getId1(){
        return this.id1;
    }

    public void setId1(int id1){
        this.id1 = id1;
    }

    public int getId2(){
        return this.id2;
    }

    public void setId2(int id2){
        this.id2 = id2;
    }

    public double getMonto(){
        return this.monto;
    }

    public void setMonto(double monto){
        this.monto = monto;
    }
}
