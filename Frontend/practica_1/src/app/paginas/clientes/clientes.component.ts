import { Component, OnInit } from '@angular/core';
import { ClienteService } from 'src/app/service/cliente.service';
import { Cliente } from 'src/app/domain/cliente';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit{
  clientes: any;

  cliente: Cliente = new Cliente();

  constructor(private clientesService: ClienteService){

  }

  ngOnInit():void {
    this.clientes = this.clientesService.getClientes();
  }

  guardar(){
    this.clientesService.saveCliente(this.cliente).subscribe(data => {
      console.log(data);
      if(data.codigo == 1)
        this.ngOnInit();
      else
        alert("Error al insertar " + data.mensaje);
    });
  }
}
