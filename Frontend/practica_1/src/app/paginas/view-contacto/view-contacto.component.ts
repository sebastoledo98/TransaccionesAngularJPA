import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Persona } from 'src/app/domain/persona';
import { ContactosFirebaseService } from 'src/app/service/contactos-firebase.service';

@Component({
  selector: 'app-view-contacto',
  templateUrl: './view-contacto.component.html',
  styleUrls: ['./view-contacto.component.css']
})
export class ViewContactoComponent {

  persona: Persona = new Persona();

  constructor(private router: Router, private route: ActivatedRoute, private contactosFirebase: ContactosFirebaseService){
    this.route.params.subscribe(params => {
      console.log('params', params);
      if(params['id']){
        this.loadPersona(params['id']);
      }
    });
  }

  loadPersona(uid: string){
    console.log('la uid: ',uid);
    this.contactosFirebase.getPersona(uid).subscribe(data => {
      console.log('datos: ',data);
      this.persona = <any> data;
    });
  }

  goAcercaDe(){
    console.log('llamando acerca de', this.persona);
    this.router.navigate(['paginas/acercade']);
  }

  goListado(){
    console.log('llamando listado', this.persona);
    this.router.navigate(['paginas/lista-contactos']);
  }


}
