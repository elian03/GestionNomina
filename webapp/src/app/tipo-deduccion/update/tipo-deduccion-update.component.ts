import { Component, } from '@angular/core';
import { TipoDeduccion } from '../../models/TipoDeduccion';
import { TipoDeduccionService } from '../../services/tipo-deduccion.service';
import { Router, ActivatedRoute } from '@angular/router';

declare const toastr;

@Component({
  selector: 'app-tipo-deduccion-update',
  templateUrl: './tipo-deduccion-update.component.html',
  styleUrls: ['./tipo-deduccion-update.component.css']
})
export class TipoDeduccionUpdateComponent {

  record: TipoDeduccion = new TipoDeduccion();

  constructor(
    private resourceService: TipoDeduccionService,
    private router: Router,
    private route: ActivatedRoute,
  ) {
    const id = this.route.snapshot.paramMap.get('id');
    this.resourceService.getById(id).then((data) => {
      this.record = data;
    })
  }

  save() {
    this.resourceService.edit(this.record).then(() => {
      toastr.success('Guardado');
    })
  }

}
