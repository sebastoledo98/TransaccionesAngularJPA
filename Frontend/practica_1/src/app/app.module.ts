import { NgModule, isDevMode } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContactoComponent } from './paginas/contacto/contacto.component';
import { MenuComponent } from './menu/menu.component';
import { AcercadeComponent } from './paginas/acercade/acercade.component';
import { CalculadoraComponent } from './paginas/calculadora/calculadora.component';
import { ListaContactosComponent } from './paginas/lista-contactos/lista-contactos.component';

import { provideFirebaseApp, getApp, initializeApp } from '@angular/fire/app';
import { getFirestore, provideFirestore } from '@angular/fire/firestore';
import { environment } from 'src/environments/environments';
import { FIREBASE_OPTIONS, FIREBASE_APP_NAME } from '@angular/fire/compat';
import { ViewContactoComponent } from './paginas/view-contacto/view-contacto.component';
import { ServiceWorkerModule } from '@angular/service-worker';
import { AngularFirestoreModule } from '@angular/fire/compat/firestore';
import { HttpClientModule } from '@angular/common/http';
import { ClientesComponent } from './paginas/clientes/clientes.component';
import { FacturasComponent } from './paginas/facturas/facturas.component';
import { TransaccionesComponent } from './paginas/transacciones/transacciones.component';

@NgModule({
  declarations: [
    AppComponent,
    ContactoComponent,
    MenuComponent,
    AcercadeComponent,
    CalculadoraComponent,
    ListaContactosComponent,
    ViewContactoComponent,
    ClientesComponent,
    FacturasComponent,
    TransaccionesComponent
  ],
  imports: [
    provideFirebaseApp(() => initializeApp(environment.firebaseConfig)),
    provideFirestore(() => getFirestore()),
    AngularFirestoreModule.enablePersistence(),
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ServiceWorkerModule.register('ngsw-worker.js', {
      enabled: !isDevMode(),
      // Register the ServiceWorker as soon as the application is stable
      // or after 30 seconds (whichever comes first).
      registrationStrategy: 'registerWhenStable:30000'
    }),
    HttpClientModule,
  ],
  providers: [
    { provide: FIREBASE_OPTIONS, useValue: environment.firebaseConfig}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
