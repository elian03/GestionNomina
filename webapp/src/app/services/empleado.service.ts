import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Empleado } from '../models/Empleado';

@Injectable()
export class EmpleadoService {

  constructor(private http: HttpClient) { }

  getAll(): Promise<Array<Empleado>> {
    return this.http.get('/api/empleados')
      .toPromise()
      .then(res => {
        console.log(res);
        return res as Array<Empleado>;
      });
  }

  getById(id: string): Promise<Empleado> {
    return this.http.get('/api/empleados/' + id)
      .toPromise()
      .then(res => {
        console.log(res);
        return res as Empleado;
      });
  }

  create(resource: Empleado): Promise<boolean> {
    return this.http.post('/api/empleados/create', resource)
      .toPromise()
      .then(res => {
        return res as boolean;
      });
  }

  edit(resource: Empleado): Promise<boolean> {
    return this.http.put('/api/empleados/update', resource)
      .toPromise()
      .then(res => {
        return res as boolean;
      });
  }
}
