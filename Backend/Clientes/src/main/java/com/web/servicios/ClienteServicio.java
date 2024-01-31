package com.web.servicios;

import com.web.gestion.GestionCliente;
import com.web.modelo.Cliente;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("clientes")
public class ClienteServicio{

    @Inject
    private GestionCliente gCliente;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Cliente cliente){
        try{
            gCliente.guardarCliente(cliente);
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
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizar(Cliente cliente){
        try{
            gCliente.actualizarCliente(cliente);
            return Response.ok(cliente).build();
        } catch (Exception e){
            ErrorMessage error = new ErrorMessage(99, e.getMessage());
            return Response.status(Response.Status.NOT_FOUND)
                .entity(error)
                .build();
        }
    }

    @DELETE
    @Produces
    public String borrar(@QueryParam("id") int id){
        try{
            System.out.println("id = " + id);
            gCliente.borrarCliente(id);
            return "OK";
        } catch (Exception e){
            return "Error";
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Produces("application/json")
    public Response leerId(@QueryParam("id") int id) {
        try{
            System.out.println("id = " + id);
            Cliente cli = gCliente.getClientePorId(id);
            return Response.ok(cli).build();
        } catch (Exception e) {
            ErrorMessage error = new ErrorMessage(4, "Cliente no existe");
            return Response.status(Response.Status.NOT_FOUND)
                .entity(error)
                .build();
        }
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Produces("application/json")
    public Response leer(@QueryParam("dni") String cedula, @QueryParam("nombre") String nombre) {
        try{
            System.out.println("cedula " +  cedula + " nom=" + nombre);
            Cliente cli = gCliente.getClientePorCedula(cedula);
            return Response.ok(cli).build();
        } catch (Exception e) {
            ErrorMessage error = new ErrorMessage(4, "Cliente no existe");
            return Response.status(Response.Status.NOT_FOUND)
                .entity(error)
                .build();
        }
    }

    @GET
    @Path("{dni}/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    //@Produces("application/json")
    public Response leer2(@PathParam("dni") String cedula, @PathParam("nombre") String nombre) {
        try{
            System.out.println("cedula " +  cedula + " nom=" + nombre);
            Cliente cli = gCliente.getClientePorCedula(cedula);
            return Response.ok(cli).build();
        }catch (Exception e) {
            ErrorMessage error = new ErrorMessage(4, "Cliente no existe");
            return Response.status(Response.Status.NOT_FOUND)
                .entity(error)
                .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("list")
    public Response getClientes(){
        List<Cliente> clientes = gCliente.getClientes();
        if(clientes.size()>0)
            return Response.ok(clientes).build();
        ErrorMessage error = new ErrorMessage(6, "No se registran clientes");
        return Response.status(Response.Status.NOT_FOUND)
            .entity(error)
            .build();
    }

}
