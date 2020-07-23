import { Component, OnInit } from '@angular/core';
import { EmpleadoService } from '../../services/empleado.service';
import { Empleado } from '../../models/Empleado';


@Component({
  selector: 'app-empleado-index',
  templateUrl: './empleado-index.component.html',
  styleUrls: ['./empleado-index.component.css']
})
export class EmpleadoIndexComponent implements OnInit {
  empleados: Array<Empleado>;

  constructor(
    private empleadoService: EmpleadoService
  ) {}

  ngOnInit() {
    this.loadEmpleados();
  }

  loadEmpleados() {
    this.empleadoService.getAll()
      .then(data => {
        this.empleados = data;
      });
  }

}

