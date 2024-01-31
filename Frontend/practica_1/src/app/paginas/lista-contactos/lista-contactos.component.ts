import { Component } from '@angular/core';
import { Persona } from '../../domain/persona';
import { ContactosService } from '../../service/contactos.service';
import { NavigationExtras } from '@angular/router';
import { Router } from '@angular/router';
import { ContactosFirebaseService } from 'src/app/service/contactos-firebase.service';

@Component({
  selector: 'app-lista-contactos',
  templateUrl: './lista-contactos.component.html',
  styleUrls: ['./lista-contactos.component.css']
})
export class ListaContactosComponent {

  contactos: Persona[] = [];
  listaContactos: any;

  constructor(private contactosService: ContactosService,
              private router:Router,
              private contactosFirebase: ContactosFirebaseService){
    this.contactos = contactosService.getContactos();
    this.listaContactos = this.contactosFirebase.getAll();
  }

  goEditar(contacto:any){
    console.log("editando", contacto);
    console.log('uid',contacto.uid);

    let params: NavigationExtras = {
      queryParams: {
        contacto: contacto
      }
    }

    this.router.navigate(['paginas/contacto/'], params);
  }

}
