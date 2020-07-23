import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TipoDeduccion } from '../models/TipoDeduccion';

@Injectable()
export class TipoDeduccionService {

  constructor(private http: HttpClient) { }

  getAll(): Promise<Array<TipoDeduccion>> {
    return this.http.get('/api/DeductionType')
      .toPromise()
      .then(res => {
        console.log(res);
        return res as Array<TipoDeduccion>;
      });
  }

  getById(id: string): Promise<TipoDeduccion> {
    return this.http.get('/api/DeductionType/' + id)
      .toPromise()
      .then(res => {
        console.log(res);
        return res as TipoDeduccion;
      });
  }

  create(resource: TipoDeduccion): Promise<boolean> {
    return this.http.post('/api/DeductionType/create', resource)
      .toPromise()
      .then(res => {
        return res as boolean;
      });
  }

  edit(resource: TipoDeduccion): Promise<boolean> {
    return this.http.put('/api/DeductionType/update', resource)
      .toPromise()
      .then(res => {
        return res as boolean;
      });
  }
}
