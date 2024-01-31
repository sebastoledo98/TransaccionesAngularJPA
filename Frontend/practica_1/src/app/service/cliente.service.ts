import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environments';
import { Cliente } from 'src/app/domain/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }
  getClientes(){
    let url = environment.WS_PATH + "/clientes/list";
    return this.http.get<any>(url);
  }

  buscarClientes(id?: number){
    let url = environment.WS_PATH + "/clientes?id=" + id;
    return this.http.get<any>(url);
  }

  saveCliente(cliente: Cliente){
    let url = environment.WS_PATH + "/clientes";
    return this.http.post<any>(url, cliente);
  }
}
