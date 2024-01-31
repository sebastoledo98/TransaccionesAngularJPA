package com.web.servicios;

public class ErrorMessage{

    private int codigo;
    private String mensaje;

    public ErrorMessage(int codigo, String mensaje){
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public String getMensaje(){
        return this.mensaje;
    }

    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }
}
