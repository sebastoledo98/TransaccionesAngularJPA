package com.web.servicios;

import java.util.List;

import com.web.modelo.Cliente;
import com.web.modelo.Transferencia;
import com.web.gestion.GestionCliente;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;

@Path("transferencia")
public class TransferenciaServicio{

    @Inject
    private GestionCliente gCliente;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response transferir(Transferencia transferencia){
        try{
            System.out.println("id1 = " + transferencia.getId1());
            System.out.println("id2 = " + transferencia.getId2());
            System.out.println("monto = " + transferencia.getMonto());
            realizarTransferencia(transferencia.getId1(), transferencia.getId2(), transferencia.getMonto());
            ErrorMessage error = new ErrorMessage(1, "OK");
            return Response.status(Response.Status.CREATED)
                .entity(error)
                .build();
        } catch (Exception e){
            ErrorMessage error = new ErrorMessage(99, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(error)
                .build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response transferirParams(@QueryParam("id1") int id1, @QueryParam("id2") int id2, @QueryParam("monto") double monto){
        try{
            System.out.println("id1 = " + id1);
            System.out.println("id2 = " + id2);
            System.out.println("monto = " + monto);
            realizarTransferencia(id1, id2, monto);
            ErrorMessage error = new ErrorMessage(1, "OK");
            return Response.status(Response.Status.CREATED)
                .entity(error)
                .build();
        } catch (Exception e){
            ErrorMessage error = new ErrorMessage(99, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(error)
                .build();
        }
    }

    public void realizarTransferencia(int id1, int id2, double monto) throws Exception{
        Cliente cliente1 = gCliente.getClientePorId(id1);
        System.out.println(cliente1);
        Cliente cliente2 = gCliente.getClientePorId(id2);
        System.out.println(cliente2);
        if(cliente1 != null && cliente2 != null){
            cliente1.setSaldo(cliente1.getSaldo() - monto);
            System.out.println(cliente1);
            gCliente.actualizarCliente(cliente1);
            cliente2.setSaldo(cliente2.getSaldo() + monto);
            System.out.println(cliente2);
            gCliente.actualizarCliente(cliente2);
        }
    }

}
