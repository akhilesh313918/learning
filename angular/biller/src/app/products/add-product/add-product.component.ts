import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/products/product.service';
import { DataStorage } from 'src/app/shared/data-storage.service';

@Component({  
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit { 

  @ViewChild('addProductForm') form: NgForm;
  constructor(private router: Router, 
    private productService: ProductService,
    private dataStorage: DataStorage) { }

  ngOnInit(): void {
  }

  onAddProduct(form: NgForm){
    const product = form.value;
    this.productService.addProduct(product);
    console.log(form.value);
    this.dataStorage.storeProduct();
    form.reset();
  }

  onCancel(){
    this.router.navigate(['/products']);
  }

  onUpdate(){
    this.dataStorage.storeProduct();
  }

  onFetch(){
    this.dataStorage.fetchProduct();
  }

  onReset(){
    this.form.reset();
  }

}
