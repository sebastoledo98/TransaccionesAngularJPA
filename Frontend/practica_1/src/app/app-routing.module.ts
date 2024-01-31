import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AcercadeComponent } from './paginas/acercade/acercade.component';
import { ContactoComponent } from './paginas/contacto/contacto.component';
import { CalculadoraComponent } from './paginas/calculadora/calculadora.component';
import { ListaContactosComponent } from './paginas/lista-contactos/lista-contactos.component';
import { ViewContactoComponent } from './paginas/view-contacto/view-contacto.component';
import { ClientesComponent } from 'src/app/paginas/clientes/clientes.component';
import { FacturasComponent } from 'src/app/paginas/facturas/facturas.component';
import { TransaccionesComponent } from 'src/app/paginas/transacciones/transacciones.component';

const routes: Routes = [
  {path: 'paginas/acercade', component: AcercadeComponent},
  {path: 'paginas/contacto', component: ContactoComponent},
  {path: 'paginas/contacto/:id', component: ViewContactoComponent},
  {path: 'paginas/calculadora', component: CalculadoraComponent},
  {path: 'paginas/lista-contactos', component: ListaContactosComponent},
  {path: 'paginas/clientes', component: ClientesComponent},
  {path: 'paginas/facturas', component: FacturasComponent},
  {path: 'paginas/transacciones', component: TransaccionesComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
