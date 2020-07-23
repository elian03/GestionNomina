import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TipoIngreso } from '../models/TipoIngreso';

const baseUrl = 'http://localhost:8080/api/IncomeType';

@Injectable()
export class TipoIngresoService {

  constructor(private http: HttpClient) { }

  getAll(): Promise<Array<TipoIngreso>> {
    return this.http.get(`${baseUrl}`)
      .toPromise()
      .then(res => {
        console.log(res);
        return res as Array<TipoIngreso>;
      });
  }

  getById(id: string): Promise<TipoIngreso> {
    return this.http.get(`${baseUrl}` + id)
      .toPromise()
      .then(res => {
        console.log(res);
        return res as TipoIngreso;
      });
  }

  create(resource: TipoIngreso): Promise<boolean> {
    return this.http.post(`${baseUrl}/create`, resource)
      .toPromise()
      .then(res => {
        return res as boolean;
      });
  }

  edit(resource: TipoIngreso): Promise<boolean> {
    return this.http.put(`${baseUrl}/update`, resource)
      .toPromise()
      .then(res => {
        return res as boolean;
      });
  }
}
