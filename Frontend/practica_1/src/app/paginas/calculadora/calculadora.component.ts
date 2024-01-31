import { Component } from '@angular/core';

@Component({
  selector: 'app-calculadora',
  templateUrl: './calculadora.component.html',
  styleUrls: ['./calculadora.component.css']
})
export class CalculadoraComponent {
  display = '0';
  numero = 0.0;
  total = 0.0;
  resultados = '';
  calc = '';

  botNumero(num: string){
    //console.log(num);
    if (this.display === '0') {
      this.display = num;
    } else {
      this.display = this.display + num;
    }
  }

  accion(act: string){
    this.numero = parseFloat(this.display);
    this.calc = act;
    this.resultados = this.display;
    this.display = '0';
  }

  calcular(){
    this.total = parseFloat(this.display);
    this.resultados = this.numero.toString() + this.calc + this.total + '=';
    if(this.calc === '+'){
      this.total = this.total + this.numero;
    }
    if(this.calc === '-'){
      this.total = this.numero - this.total;
    }
    if(this.calc === '*'){
      this.total = this.numero * this.total;
    }
    if(this.calc === '/'){
      this.total = this.numero / this.total;
    }
    this.resultados = this.resultados + this.total.toString();
    this.display = '0';
    this.calc = '';
    this.numero = 0;
  }
}
