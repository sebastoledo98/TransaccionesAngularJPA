import { Component } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {
  paginas = [
    {title: 'Acerca De', path: 'paginas/acercade'},
    {title: 'Contacto', path: 'paginas/contacto'},
    {title: 'Calculadora', path: 'paginas/calculadora'},
    {title: 'Clientes', path: 'paginas/clientes'},
    {title: 'Facturas', path: 'paginas/facturas'},
    {title: 'Transaccion', path: 'paginas/transacciones'},
  ]
}
