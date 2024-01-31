import { Component, OnInit } from '@angular/core';
import { FacturasService } from 'src/app/service/facturas.service';
import { ClienteService } from 'src/app/service/cliente.service';
import { Factura } from 'src/app/domain/factura';
import { Detalle } from 'src/app/domain/detalle';
import { Producto } from 'src/app/domain/producto';
import { Cliente } from 'src/app/domain/cliente';

@Component({
  selector: 'app-facturas',
  templateUrl: './facturas.component.html',
  styleUrls: ['./facturas.component.css']
})
export class FacturasComponent implements OnInit{

  facturas: any;
  detalles: any | null;

  factura: Factura = new Factura();
  detalle: Detalle = new Detalle();
  producto: Producto = new Producto();
  cliente: Cliente = new Cliente();

  constructor(private facturaService: FacturasService, private clienteService: ClienteService){}

  ngOnInit():void {
    this.facturas = this.facturaService.getFacturas();
    //this.facturaService.getDetalles().subscribe(res => this.detalles = res);
    //this.facturaService.getFacturas().subscribe(res => this.facturas = res);
    //console.log(this.facturas);
    //this.detalle.subtotal = 0.0;
  }

  guardar(){
    this.clienteService.buscarClientes(this.cliente.id).subscribe(data => {
      //console.log('cliente');
      //console.log(data);
      this.cliente = data;
      this.factura.cliente = data;
    });
    this.facturaService.getProducto(this.producto.id).subscribe(data => {
      //console.log('producto');
      //console.log(data);
      this.producto = data;
      this.detalle.producto! = data;
      this.factura.detalle = this.detalle;
      //console.log('this.prodicto');
      //console.log(this.producto);
      //console.log('detalle.producto');
      //console.log(this.detalle.producto);
    });
    //this.facturaService.saveDetalle(this.detalle);
/*
    this.facturaService.saveDetalle(this.detalle).subscribe(data => {
      console.log(data);
      if(data.codigo == 1)
        this.factura.detalle = this.detalle;
      else
        alert("Error al insertar " + data.mensaje);
    });
*/
    this.facturaService.saveFactura(this.factura).subscribe(data => {
      console.log(data);
      if(data.codigo == 1)
        this.ngOnInit();
      else
        alert("Error al insertar " + data.mensaje);
    });
  }

}
