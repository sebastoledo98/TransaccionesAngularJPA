import { Detalle } from 'src/app/domain/detalle';
import { Cliente } from 'src/app/domain/cliente';

export class Factura{
  id?: number;
  numero?: number;
  fecha?: Date;
  total?: number;
  descuento?: number;
  cliente?: Cliente;
  detalle?: Detalle;
}
