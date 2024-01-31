import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environments';
import { Transaccion } from 'src/app/domain/transaccion';

@Injectable({
  providedIn: 'root'
})
export class TransaccionService {

  url = environment.WS_PATH + '/transferencia';

  constructor(private http: HttpClient) { }

  hacerTransaccion(transaccion: Transaccion){
    console.log("transaccion");
    console.log(transaccion);
    return this.http.post<any>(this.url, transaccion);
  }

  transaccionParams(id1: number, id2: number, monto: number){
    let parametros = this.url + "?id1=" + id1 + "&id2=" + id2 + "&monto=" + monto;
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    console.log("Parametros");
    console.log(parametros);
    return this.http.put<any>(parametros, {dato: id1},  {headers: headers});
  }
}
