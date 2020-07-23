import { Component, } from '@angular/core';
import { TipoIngreso } from '../../models/TipoIngreso';
import { TipoIngresoService } from '../../services/tipo-ingreso.service';
import { Router, ActivatedRoute } from '@angular/router';

declare const toastr;

@Component({
  selector: 'app-tipo-ingreso-update',
  templateUrl: './tipo-ingreso-update.component.html',
  styleUrls: ['./tipo-ingreso-update.component.css']
})
export class TipoIngresoUpdateComponent {

  record: TipoIngreso = new TipoIngreso();

  constructor(
    private resourceService: TipoIngresoService,
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
