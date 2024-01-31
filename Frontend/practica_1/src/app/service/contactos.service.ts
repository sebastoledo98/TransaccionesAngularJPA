import { Injectable } from '@angular/core';
import { Persona } from '../domain/persona';

@Injectable({
  providedIn: 'root'
})
export class ContactosService {

  contactos: Persona[] = [];

  constructor() {

  }

  addContactos(persona: Persona){
    this.contactos.push(persona);
  }

  getContactos(){
    return this.contactos;
  }
}
