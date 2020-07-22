import { Component, OnInit } from '@angular/core';
import { Product } from '../../models/Product';
import { TransferReponse } from '../../models/TransferResponse';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ProductService } from '../../services/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-output',
  templateUrl: './output.component.html',
  styleUrls: ['./output.component.css']
})
export class OutputComponent implements OnInit {

  products: Array<Product>;
  product: Product = new Product();
  transferResponse: TransferReponse;
  outputProductsForm: FormGroup;
  totalPrice = 0;
  unityPrice = 0;

  constructor(private productService: ProductService, private formBuilder: FormBuilder,
    private router: Router) {
    this.createForm();

    this.product.purchasePrice = 0;
    this.product.salePrice = 0;

    productService.getAllProducts().then(data => {
      this.products = data;
    });
  }

  createForm() {
    this.outputProductsForm = this.formBuilder.group({
      product: ['', Validators.required],
      quantity: ['', Validators.required],
      salePrice: ['', Validators.required],
      unityPrice: ['', Validators.required],
      select: ['', Validators.required]
    });
  }

  selectChanged() {
    if (this.outputProductsForm.get('select').value != 0) {
      this.product = this.products.find(x => x.id == this.outputProductsForm.get('select').value);
      this.unityPrice = this.product.salePrice;
      this.totalPrice = this.product.salePrice * this.outputProductsForm.get('quantity').value;
    } else {
      this.unityPrice = 0;
      this.totalPrice = 0;
    }
  }

  outputProducts() {
    this.productService.executeOutputProducts(this.outputProductsForm.get('select').value,
      this.outputProductsForm.get('quantity').value).then(x => {
        this.transferResponse = x;
        this.router.navigateByUrl('/transfers');
      });
  }

  ngOnInit() {
  }
}
