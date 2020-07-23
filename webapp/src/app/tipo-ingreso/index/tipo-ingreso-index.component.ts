import { Component, OnInit } from '@angular/core';
import { TipoIngresoService } from '../../services/tipo-ingreso.service';
import { TipoIngreso } from '../../models/TipoIngreso';


@Component({
  selector: 'app-tipo-ingreso-index',
  templateUrl: './tipo-ingreso-index.component.html',
  styleUrls: ['./tipo-ingreso-index.component.css']
})
export class TipoIngresoIndexComponent implements OnInit {
  resources: Array<TipoIngreso>;

  constructor(
    private tipoIngresoService: TipoIngresoService
  ) {}

  ngOnInit() {
    this.load();
  }

  load() {
    this.tipoIngresoService.getAll()
      .then(data => {
        this.resources = data;
      });
  }

}

