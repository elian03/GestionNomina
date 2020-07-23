import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Empleado } from '../models/Empleado';

const baseUrl = 'http://localhost:8080/api/employee';

@Injectable()
export class EmpleadoService {

  constructor(private http: HttpClient) { }

  getAll(): Promise<Array<Empleado>> {
    return this.http.get(`${baseUrl}`)
      .toPromise()
      .then(res => {
        console.log(res);
        return res as Array<Empleado>;
      });
  }

  getById(id: string): Promise<Empleado> {
    return this.http.get(`${baseUrl}/` + id)
      .toPromise()
      .then(res => {
        console.log(res);
        return res as Empleado;
      });
  }

  create(resource: Empleado): Promise<boolean> {
    return this.http.post(`${baseUrl}/create`, resource)
      .toPromise()
      .then(res => {
        return res as boolean;
      });
  }

  edit(resource: Empleado): Promise<boolean> {
    return this.http.put(`${baseUrl}/update`, resource)
      .toPromise()
      .then(res => {
        return res as boolean;
      });
  }
}
