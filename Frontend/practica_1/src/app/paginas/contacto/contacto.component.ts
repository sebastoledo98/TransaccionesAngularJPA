import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ContactosFirebaseService } from 'src/app/service/contactos-firebase.service';
import { ContactosService } from '../../service/contactos.service';
import { Persona } from '../../domain/persona';

@Component({
  selector: 'app-contacto',
  templateUrl: './contacto.component.html',
  styleUrls: ['./contacto.component.css']
})
export class ContactoComponent {

  //id: string = "";
  //name: string = "";

  persona: Persona = new Persona();

  constructor(private router: Router,
              private contactosService: ContactosService,
              private contactosFirebase: ContactosFirebaseService){
    let params = this.router.getCurrentNavigation()?.extras.queryParams;
    if(params){
      console.log(params);
      this.persona = params['contacto'];
    }
  }
  savePersona(){
    this.contactosService.addContactos(this.persona);
    console.log('contactos',this.contactosService.getContactos());

    this.contactosFirebase.save(this.persona);
    this.persona = new Persona();
  }


  goAcercaDe(){
    console.log("llamando acerca de ");
    this.router.navigate(['paginas/acercade']);
  }

  listarContactos(){
    this.router.navigate(['paginas/lista-contactos']);
  }
}
