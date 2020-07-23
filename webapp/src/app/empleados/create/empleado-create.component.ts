import { Component, } from '@angular/core';
import { Empleado } from '../../models/Empleado';
import { Validator } from 'utils-do';
import { EmpleadoService } from '../../services/empleado.service';

declare const toastr;

@Component({
  selector: 'app-empleado-create',
  templateUrl: './empleado-create.component.html',
  styleUrls: ['./empleado-create.component.css']
})
export class EmpleadoCreateComponent {

  record: Empleado = new Empleado();

  constructor(
    private empleadoService: EmpleadoService
  ) { }

  save() {
    let valid = true;

    const isAnIde = Validator.isAnIde(this.record.cedula);
    if (!isAnIde) {
      valid = false;
      toastr.error('Cedula no valida')
    }

    if (!this.record.nombre) {
      valid = false;
      toastr.error('Nombre es requerido')
    }

    if (Number(this.record.salarioMensual) >= 0) {
      valid = false;
      toastr.error('Cedula no valida');
    }

    if (valid) {
      this.empleadoService.create(this.record).then(() => {
        toastr.success('Guardado');
      })
    }
  }

}
