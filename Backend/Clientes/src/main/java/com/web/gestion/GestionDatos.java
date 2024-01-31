package com.web.gestion;

import com.web.modelo.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.web.dao.*;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos{

    @Inject
    private ClienteDAO clienteDAO;
    @Inject
    private FacturaDAO facturaDAO;

    @PostConstruct
    public void init(){
        System.out.println("INICIANDO SERVICIOS");

        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setDni("0123456789");
        cliente.setDireccion("Av. Don Bosco");
        cliente.setNombre("Pepito Perez");
        cliente.setSaldo(500.00);
        clienteDAO.insert(cliente);
        //cleinte 2
        cliente = new Cliente();

        cliente.setId(2);
        cliente.setDni("0987654321");
        cliente.setDireccion("El Vado");
        cliente.setNombre("Diego Gomez");
        cliente.setSaldo(300.00);
        clienteDAO.insert(cliente);

        Producto producto = new Producto();
        producto.setDescripcion("Carne de cerdo");
        producto.setPrecio((float)10.0);
        producto.setStock(20);
        //productoDAO.insert(producto);

        Detalle detalle = new Detalle();
        detalle.setProducto(producto);
        detalle.setCantidad(5);

        Factura factura = new Factura();
        factura.setNumero("001-001-0001");

        cliente = clienteDAO.read(1);

        factura.setCliente(cliente);
        factura.setFecha(new Date());
        factura.setTotal(detalle.getCantidad() * producto.getPrecio());
        factura.addDetalle(detalle);

        facturaDAO.insert(factura);

        detalle = new Detalle();
        detalle.setProducto(producto);
        detalle.setCantidad(7);

        factura = new Factura();
        factura.setNumero("002-002-0002");
        
        cliente = clienteDAO.read(2);

        factura.setCliente(cliente);
        factura.setFecha(new Date());
        factura.setTotal(detalle.getCantidad() * producto.getPrecio());
        factura.addDetalle(detalle);

        facturaDAO.insert(factura);

        System.out.println("======================LISTA CLIENTES======================");
        List<Cliente> clientes = clienteDAO.getAll();
        for(Cliente c : clientes){
            System.out.println(c);
        }

        System.out.println("======================LISTA FACTURAS======================");
        List<Factura> facturas = facturaDAO.getAll();
        for(Factura f : facturas){
            System.out.println(f);
        }

        System.out.println("======================LISTA CANTIDAD FACTURAS======================");
        List<CantidadFacturaCliente> facturas2 = facturaDAO.getTotalFacturas();
        for(CantidadFacturaCliente ca : facturas2){
            System.out.println(ca);
        }
    }
}
