import { Component, OnInit } from '@angular/core';
import { Product } from '../../models/Product';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ProductService } from '../../services/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  product: Product;
  addProductForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private productService: ProductService,
    private router: Router) {
    this.createForm();
  }

  ngOnInit() {
  }

  createForm() {
    this.addProductForm = this.formBuilder.group({
      productName: ['', Validators.required],
      description: ['', Validators.required],
      purchasePrice: ['',  Validators.min(0)],
      salePrice: ['',  Validators.min(0)],
      quantityStoraged: ['', Validators.min(0)]
    });
  }

  create() {
    this.productService.createProduct(this.addProductForm.value).then(resp => {
      this.router.navigateByUrl('\index');
    });
  }

}
