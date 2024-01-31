import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environments';
import { Factura } from 'src/app/domain/factura';
import { Detalle } from 'src/app/domain/detalle';

@Injectable({
  providedIn: 'root'
})
export class FacturasService {

  constructor(private http: HttpClient) { }

  getFacturas(){
    let url = environment.WS_PATH + "/facturas/list";
    return this.http.get<any>(url);
  }

  saveFactura(factura: Factura){
    console.log('factura envio');
    console.log(factura);
    let url = environment.WS_PATH + "/facturas";
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post<any>(url, JSON.stringify(factura), {headers});
  }

  getProducto(id?: number){
    let url = environment.WS_PATH + "/productos?id=" + id;
    return this.http.get<any>(url);
  }

  getDetalle(id?: number){
    let url = environment.WS_PATH + "/detalles" + id;
    return this.http.get<any>(url);
  }

  getDetalles(){
    let url = environment.WS_PATH + "/detalles/list";
    return this.http.get<any>(url);
  }

  saveDetalle(detalle: Detalle){
    console.log('detalle envio');
    console.log(detalle);
    let url = environment.WS_PATH + "/detalles";
    return this.http.post<any>(url, detalle);
  }
}
