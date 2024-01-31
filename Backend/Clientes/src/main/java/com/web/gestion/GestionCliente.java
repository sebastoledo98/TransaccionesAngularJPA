package com.web.gestion;

import java.util.List;

import com.web.modelo.Cliente;
import com.web.dao.ClienteDAO;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCliente{

    @Inject
    private ClienteDAO clienteDAO;

    public void guardarCliente(Cliente cliente){
        Cliente cli = clienteDAO.read(cliente.getId());
        if ( cli != null)
            clienteDAO.update(cliente);
        else
            clienteDAO.insert(cliente);
    }

    public void actualizarCliente(Cliente cliente) throws Exception{
        Cliente cli = clienteDAO.read(cliente.getId());
        if( cli != null )
            clienteDAO.update(cliente);
        else
            throw new Exception("Cliente no existe");
    }

    public Cliente getClientePorCedula(String cedula) throws Exception{
        if(cedula.length() != 10)
            throw new Exception("Cedula incorrecta");
        return clienteDAO.getClientePorCedula(cedula);
    }

    public Cliente getClientePorId(int id) throws Exception{
        return clienteDAO.getClientePorId(id);
    }

    public void borrarCliente(int id){
        clienteDAO.remove(id);
    }

    public List<Cliente> getClientes(){
        return clienteDAO.getAll();
    }

}
