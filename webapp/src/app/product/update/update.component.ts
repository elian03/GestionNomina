import { Component, OnInit } from '@angular/core';
import { Product } from '../../models/Product';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ProductService } from '../../services/product.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  product: Product;
  productUpdated: Product = new Product();
  editProductForm: FormGroup;
  key: string;

  constructor(private formBuilder: FormBuilder, private productService: ProductService,
    private router: Router, private route: ActivatedRoute) {
    this.key = this.route.snapshot.paramMap.get('id');
    this.productService.getProductById(this.key).then(data => {
      this.product = data;
      this.editProductForm.patchValue(this.product);
    });
    this.createForm();
  }

  ngOnInit() {
  }

  createForm() {
    this.editProductForm = this.formBuilder.group({
      productName: ['', Validators.required],
      description: ['', Validators.required],
      purchasePrice: ['', Validators.min(0)],
      salePrice: ['', Validators.min(0)],
      quantityStoraged: ['', Validators.min(0)]
    });
  }

  update() {
    this.productUpdated.id = parseInt(this.key, null);
    console.log(this.productUpdated.id);
    this.productUpdated.productName = this.editProductForm.get('productName').value;
    this.productUpdated.description = this.editProductForm.get('description').value;
    this.productUpdated.purchasePrice = this.editProductForm.get('purchasePrice').value;
    this.productUpdated.salePrice = this.editProductForm.get('salePrice').value;
    this.productUpdated.quantityStoraged = this.editProductForm.get('quantityStoraged').value;

    this.productService.editProduct(this.productUpdated).then(resp => {
      this.router.navigateByUrl('\index');
    });
  }
}
