import { Injectable } from '@angular/core';
import { ProductService } from '../products/product.service';
import { HttpClient } from '@angular/common/http';
import { Product } from '../products/product.model';
import { map, tap, take, exhaustMap} from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class DataStorage{

    constructor(private http: HttpClient,
        private productService: ProductService){}

        URL = 'https://biller-fe424.firebaseio.com/products.json';
        
        storeProduct(){
            const products = this.productService.getProducts();
            return this.http.put(this.URL,products)
            .subscribe(response => {
                console.log(response);
            })
        }

        fetchProduct(){
            return this.http.get<Product[]>(this.URL)
            .pipe(
                map(products => {
                    return products.map(product =>{
                        return{
                            ...product
                        }
                    })
                }),tap(products => {
                    this.productService.setProducts(products);
                    console.log("From DS"+products);
                })
            )
        }

}