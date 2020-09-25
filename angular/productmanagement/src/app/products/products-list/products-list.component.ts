import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProductService } from '../product.service';
import { ProductsModel } from '../products.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css']
})
export class ProductsListComponent implements OnInit {

  public products: Array<ProductsModel>;

  constructor(private productService: ProductService,
              private router: Router) { }

  ngOnInit() {
     this.getProducts();
  }

  private getProducts(): void {
    this.productService.getProducts()
      .subscribe( data => {
        this.products = data;
        console.log(this.products);
      }) 
  }

  public onDelete(id){
    console.log(id);
    this.productService.deleteProducts(id).subscribe(()=>{
      //this.router.navigate(["/"]);
      this.ngOnInit();
    });
  }
}
