import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { ProductService } from '../product.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ProductsModel } from '../products.model';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  public product = [];
  productsaveform:FormGroup;
  public mode = 'create';
  private id: number;
  constructor(private activeroute: ActivatedRoute, 
              private productService: ProductService) { }

         

  ngOnInit(): void {
        this.productsaveform = new FormGroup({
        product_name: new FormControl('',[Validators.required]),
        product_brand: new FormControl('', [Validators.required]),
        product_madein: new FormControl('', [Validators.required]),
        product_price: new FormControl('', [Validators.required, Validators.pattern('[0-9]')]),
      });  

      this.activeroute.paramMap.subscribe(
        (paramMap: ParamMap) => {
            if(paramMap.has("id")){
              this.mode = "edit";
              const id = this.activeroute.snapshot.paramMap.get('id');
        this.productService.getProductById(id)
       .subscribe(data => {
        console.log(data);
        this.product.push(data);
        console.log(this.product);
        this.productsaveform.setValue({
          'product_name': this.product[0].name,
          'product_brand':this.product[0].brand,
          'product_madein':this.product[0].madein,
          'product_price':this.product[0].price,
        });
      })
            }
        })
  }

  onSave(){
    console.log(this.productsaveform.value);
    if(this.mode === 'create'){
      const product: ProductsModel = {
        id:this.id,
        name: this.productsaveform.value.product_name,
        brand: this.productsaveform.value.product_brand,
        madein: this.productsaveform.value.product_madein,
        price: this.productsaveform.value.product_price
        }
     this.productService.addProducts(product);   
    }
    else{
      const id = +this.activeroute.snapshot.paramMap.get('id');
      const product: ProductsModel = {
        id: +this.activeroute.snapshot.paramMap.get('id'),
        name: this.productsaveform.value.product_name,
        brand: this.productsaveform.value.product_brand,
        madein: this.productsaveform.value.product_madein,
        price: this.productsaveform.value.product_price
      }
      this.productService.updateProducts(id,product);
    }
    }
    
    
}
