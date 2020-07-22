import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../models/Product';
import { TransferReponse } from '../models/TransferResponse';

@Injectable()
export class ProductService {

  constructor(private http: HttpClient) { }

  getAllProducts(): Promise<Array<Product>> {
    return this.http.get('/api/products')
      .toPromise()
      .then(resp => {
        console.log(resp);
        return resp as Array<Product>;
      });
  }

  getProductById(id: string): Promise<Product> {
    return this.http.get('/api/products/' + id)
      .toPromise()
      .then(resp => {
        console.log(resp);
        return resp as Product;
      });
  }

  executeEntryProducts(id: number, entry: number): Promise<TransferReponse> {
    return this.http.put('/api/products/entry/' + id + '/' + entry, null)
      .toPromise()
      .then(resp => {
        console.log(resp);
        return resp as TransferReponse;
      });
  }

  executeOutputProducts(id: number, out: number): Promise<TransferReponse> {
    return this.http.put('/api/products/out/' + id + '/' + out, null)
      .toPromise()
      .then(resp => {
        console.log(resp);
        return resp as TransferReponse;
      });
  }

  createProduct(product: Product): Promise<boolean> {
    return this.http.post('/api/products/create', product)
      .toPromise()
      .then(resp => {
        return resp as boolean;
      });
  }

  editProduct(product: Product): Promise<boolean> {
    return this.http.put('/api/products/update', product)
      .toPromise()
      .then(resp => {
        return resp as boolean;
      });
  }
}
