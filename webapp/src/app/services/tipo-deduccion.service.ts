import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TipoDeduccion } from '../models/TipoDeduccion';

const baseUrl = 'http://localhost:8080/api/DeductionType';

@Injectable()
export class TipoDeduccionService {

  constructor(private http: HttpClient) { }

  getAll(): Promise<Array<TipoDeduccion>> {
    return this.http.get(`${baseUrl}`)
      .toPromise()
      .then(res => {
        console.log(res);
        return res as Array<TipoDeduccion>;
      });
  }

  getById(id: string): Promise<TipoDeduccion> {
    return this.http.get(`${baseUrl}` + id)
      .toPromise()
      .then(res => {
        console.log(res);
        return res as TipoDeduccion;
      });
  }

  create(resource: TipoDeduccion): Promise<boolean> {
    return this.http.post(`${baseUrl}/create`, resource)
      .toPromise()
      .then(res => {
        return res as boolean;
      });
  }

  edit(resource: TipoDeduccion): Promise<boolean> {
    return this.http.put(`${baseUrl}/update`, resource)
      .toPromise()
      .then(res => {
        return res as boolean;
      });
  }
}
