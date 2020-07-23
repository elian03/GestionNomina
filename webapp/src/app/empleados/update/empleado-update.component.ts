import { Component, } from '@angular/core';
import { Empleado } from '../../models/Empleado';
import { Validator } from 'utils-do';
import { EmpleadoService } from '../../services/empleado.service';
import { Router, ActivatedRoute } from '@angular/router';

declare const toastr;

@Component({
  selector: 'app-empleado-update',
  templateUrl: './empleado-update.component.html',
  styleUrls: ['./empleado-update.component.css']
})
export class EmpleadoUpdateComponent {

  record: Empleado = new Empleado();

  constructor(
    private empleadoService: EmpleadoService,
    private router: Router,
    private route: ActivatedRoute,
  ) {
    const id = this.route.snapshot.paramMap.get('id');
    this.empleadoService.getById(id).then((data) => {
      this.record = data;
    })
  }

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
      this.empleadoService.edit(this.record).then(() => {
        toastr.success('Guardado');
      })
    }
  }

}
