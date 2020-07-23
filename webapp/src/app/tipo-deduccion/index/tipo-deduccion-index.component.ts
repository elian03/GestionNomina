import { Component, OnInit } from '@angular/core';
import { TipoDeduccionService } from '../../services/tipo-deduccion.service';
import { TipoDeduccion } from '../../models/TipoDeduccion';


@Component({
  selector: 'app-tipo-deduccion-index',
  templateUrl: './tipo-deduccion-index.component.html',
  styleUrls: ['./tipo-deduccion-index.component.css']
})
export class TipoDeduccionIndexComponent implements OnInit {
  resources: Array<TipoDeduccion>;

  constructor(
    private tipoDeduccionService: TipoDeduccionService
  ) {}

  ngOnInit() {
    this.load();
  }

  load() {
    this.tipoDeduccionService.getAll()
      .then(data => {
        this.resources = data;
      });
  }

}

