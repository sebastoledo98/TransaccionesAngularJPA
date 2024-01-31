import { Producto } from 'src/app/domain/producto';

export class Detalle{
  id?: number;
  cantidad?: number;
  subtotal?: number;
  producto?: Producto;
}
