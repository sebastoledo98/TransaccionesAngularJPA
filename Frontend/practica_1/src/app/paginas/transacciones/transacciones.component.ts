import { Component } from '@angular/core';
import { Transaccion } from 'src/app/domain/transaccion';
import { TransaccionService } from 'src/app/service/transaccion/transaccion.service';

@Component({
  selector: 'app-transacciones',
  templateUrl: './transacciones.component.html',
  styleUrls: ['./transacciones.component.css']
})
export class TransaccionesComponent {

  transaccion: Transaccion = new Transaccion();

  constructor(private transaccionService: TransaccionService) {}


  hacerTransaccion(){

    this.transaccionService.hacerTransaccion(this.transaccion).subscribe(data => {
      console.log(data);
    });
  }

  transaccion2(){
    this.transaccionService.transaccionParams(this.transaccion.id1!, this.transaccion.id2!, this.transaccion.monto!).subscribe(data => {
      console.log(data);
    });
  }

}
