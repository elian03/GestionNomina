import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Transfer } from '../models/Transfer';

@Injectable()
export class TransferService {

  constructor(private http: HttpClient) { }

  getAllTransfers(): Promise<Array<Transfer>> {
    return this.http.get('/api/products/transfers')
      .toPromise()
      .then(resp => {
        console.log(resp);
        return resp as Array<Transfer>;
      });
  }
}
