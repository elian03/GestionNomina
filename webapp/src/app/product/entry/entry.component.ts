import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Product } from '../../models/Product';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TransferReponse } from '../../models/TransferResponse';

@Component({
  selector: 'app-entry',
  templateUrl: './entry.component.html',
  styleUrls: ['./entry.component.css']
})
export class EntryComponent implements OnInit {

  products: Array<Product>;
  product: Product = new Product();
  transferResponse: TransferReponse;
  addProductsForm: FormGroup;
  priceNeto = 0;
  unitPrice = 0;

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
    this.addProductsForm = this.formBuilder.group({
      product: ['', Validators.required],
      quantity: ['', Validators.required],
      salePrice: ['', Validators.required],
      unityPrice: ['', Validators.required],
      select: ['', Validators.required]
    });
  }

  selectChanged() {
    if (this.addProductsForm.get('select').value != 0) {
      this.product = this.products.find(x => x.id == this.addProductsForm.get('select').value);
      this.unitPrice = this.product.purchasePrice;
      this.priceNeto = this.product.purchasePrice * this.addProductsForm.get('quantity').value;
    } else {
      this.unitPrice = 0;
      this.priceNeto = 0;
    }
  }

  entryProducts() {
    this.productService.executeEntryProducts(this.addProductsForm.get('select').value,
      this.addProductsForm.get('quantity').value).then(x => {
        this.transferResponse = x;
        this.router.navigateByUrl('/transfers');
      });
  }

  ngOnInit() {
  }

}
