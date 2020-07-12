import { Component, OnInit, Injectable, ViewChild} from '@angular/core';
import { ProductService } from 'src/app/products/product.service';
import {MatTableDataSource} from '@angular/material/table';
import { DataStorage } from 'src/app/shared/data-storage.service';
import { Product } from '../product.model';
import { Subscription } from 'rxjs';
import { NgForm } from '@angular/forms';



//@Injectable({providedIn: 'root'})

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})

export class ProductListComponent implements OnInit {

  subscription: Subscription; 
   public products: Product[] = [];
   @ViewChild('addToBill') form: NgForm;

  constructor(private productService: ProductService,
    private dataStorage: DataStorage) { }

  ngOnInit(){
    console.log("From PL");
    this.dataStorage.fetchProduct().subscribe();
    this.subscription = this.productService.productsChanged
    .subscribe(
      (product: Product[]) => {
        this.products = product;
        console.log("PL"+this.products);
      }
    )
  }

  onAddToBill(form: NgForm){
    console.log("TEst submit button");
    localStorage.setItem("addedProd", form.value);
    console.log(form);
  }

  displayedColumns: string[] = ['productId', 'productName', 'productModel', 'productCompany', 'productPrice'];
  dataSource = new MatTableDataSource(this.products) //Product;

  applyFilter(event: Event) {
    
    console.log((event.target as HTMLInputElement).value);
    const filterValue = (event.target as HTMLInputElement).value;
    console.log("filterValue =>  " + filterValue);
    this.dataSource.filter = filterValue.trim().toLowerCase();
    console.log(this.dataSource.filter);
  }
}
