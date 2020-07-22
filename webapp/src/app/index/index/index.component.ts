import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Product } from '../../models/Product';


@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  products: Array<Product>;
  constructor( private productService: ProductService) {
    productService.getAllProducts().then(data => {
      this.products = data;
    });
   }

  ngOnInit() {
  }

}

