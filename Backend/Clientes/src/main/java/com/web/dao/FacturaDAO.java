package com.web.dao;

import java.util.ArrayList;
import java.util.List;

import com.web.modelo.CantidadFacturaCliente;
import com.web.modelo.Factura;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class FacturaDAO{

    @PersistenceContext
    private EntityManager em;

    public void insert(Factura factura){
        em.persist(factura);
    }

    public void update(Factura factura){
        em.merge(factura);
    }

    public void remove(int id){
        Factura factura = em.find(Factura.class, id);
        em.remove(factura);
    }

    public Factura read(int id){
        Factura factura = em.find(Factura.class, id);
        return factura;
    }

    public List<Factura> getAll(){
        String jpql = "SELECT f FROM Factura f";
        Query q = em.createQuery(jpql, Factura.class);
        return q.getResultList();
    }

    public Factura getFacturaPorId(int id){
        String jpql = "SELECT f FROM Factura f WHERE f.id = :id";
        Query q = em.createQuery(jpql, Factura.class);
        q.setParameter("id", id);
        List<Factura> facturas = q.getResultList();
        if(facturas.size() > 0)
            return facturas.get(0);
        return null;
    }

    public List<CantidadFacturaCliente> getTotalFacturas(){
        String sql = "SELECT id_cliente, nombre, count(f.id) "
            + "FROM Factura f, Cliente c "
            + "WHERE f.id_cliente = c.id GROUP BY id_cliente, nombre";
        Query q = em.createNativeQuery(sql);
        List<Object[]> list = q.getResultList(); 
        List<CantidadFacturaCliente> datos = new ArrayList<CantidadFacturaCliente>();
        for(Object[] result : list){
            datos.add(new CantidadFacturaCliente(((Number) result[0]).intValue(),
                        result[1].toString(),
                        ((Number) result[2]).intValue()));
        }
        return datos;
    }

} 
