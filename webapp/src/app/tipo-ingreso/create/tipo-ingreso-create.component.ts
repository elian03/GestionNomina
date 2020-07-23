import { Component, } from '@angular/core';
import { TipoIngreso } from '../../models/TipoIngreso';
import { TipoIngresoService } from '../../services/tipo-ingreso.service';

declare const toastr;

@Component({
  selector: 'app-tipo-ingreso-create',
  templateUrl: './tipo-ingreso-create.component.html',
  styleUrls: ['./tipo-ingreso-create.component.css']
})
export class TipoIngresoCreateComponent {

  record: TipoIngreso = new TipoIngreso();

  constructor(
    private resourceService: TipoIngresoService
  ) { }

  save() {
    this.resourceService.create(this.record).then(() => {
      toastr.success('Guardado');
    })
  }

}
