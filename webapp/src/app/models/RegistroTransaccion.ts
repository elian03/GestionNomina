/**
 * Represents a batch
 *
 * @export
 * @class Batch
 */
export class RegistroTransaccion {
  id: number;
  IdEmpleado: number;
  idIngreso: number;
  IdDeduccion: number;
  Tipotransaccion: String;
  Fecha: Date;
  Monto: number;
  Estado: String;
}
