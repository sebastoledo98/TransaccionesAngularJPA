package com.web.dao;

import java.util.List;

import com.web.modelo.Cliente;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ClienteDAO{

    @PersistenceContext
    private EntityManager em;

    public void insert(Cliente cliente){
        em.persist(cliente);
    }

    public void update(Cliente cliente){
        em.merge(cliente);
    }

    public void remove(int id){
        Cliente cliente = em.find(Cliente.class, id);
        em.remove(cliente);
    }

    public Cliente read(int id){
        Cliente cliente = em.find(Cliente.class, id);
        return cliente;
    }

    public List<Cliente> getAll(){
        String jpql = "SELECT c FROM Cliente c";
        Query q = em.createQuery(jpql, Cliente.class);
        return q.getResultList();
    }

    public Cliente getClientePorCedula(String cedula){
        String jpql = "SELECT c FROM Cliente c WHERE c.dni = :cedula";
        Query q = em.createQuery(jpql, Cliente.class);
        q.setParameter("cedula", cedula);
        List<Cliente> clientes = q.getResultList();
        if(clientes.size() > 0)
            return clientes.get(0);
        return null;
    }

    public Cliente getClientePorId(int id){
        String jpql = "SELECT c FROM Cliente c WHERE c.id = :id";
        Query q = em.createQuery(jpql, Cliente.class);
        q.setParameter("id", id);
        List<Cliente> clientes = q.getResultList();
        if(clientes.size() > 0)
            return clientes.get(0);
        return null;
    }
} 
