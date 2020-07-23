import { Component, } from '@angular/core';
import { TipoDeduccion } from '../../models/TipoDeduccion';
import { TipoDeduccionService } from '../../services/tipo-deduccion.service';

declare const toastr;

@Component({
  selector: 'app-tipo-deduccion-create',
  templateUrl: './tipo-deduccion-create.component.html',
  styleUrls: ['./tipo-deduccion-create.component.css']
})
export class TipoDeduccionCreateComponent {

  record: TipoDeduccion = new TipoDeduccion();

  constructor(
    private resourceService: TipoDeduccionService
  ) { }

  save() {
    this.resourceService.create(this.record).then(() => {
      toastr.success('Guardado');
    })
  }

}
