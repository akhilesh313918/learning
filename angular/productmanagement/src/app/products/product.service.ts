import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ProductsModel } from './products.model';
import { Router } from '@angular/router';

@Injectable()
export class ProductService{

    constructor(private http: HttpClient, private router: Router){}

    public getProducts(): Observable<ProductsModel[]>{
        return this.http.get<ProductsModel[]>("http://localhost:8080/products");
    }

    public getProductById(id): Observable<ProductsModel[]>{
        return this.http.get<ProductsModel[]>("http://localhost:8080/product/"+`${id}`);
    }

    public addProducts(product: ProductsModel){
        this.http.post("http://localhost:8080/add" , product)
            .subscribe(response => {
                console.log(response);
                this.router.navigate(['/']);
            })
    }

    public updateProducts(id: number, product: ProductsModel){
        this.http.put("http://localhost:8080/update/"+`${id}`,product)
            .subscribe(response => {
                console.log(response);
                this.router.navigate(['/']);
            })
    }

    public deleteProducts(id):Observable<ProductsModel[]>{
        return this.http.delete<ProductsModel[]>("http://localhost:8080/delete/"+`${id}`);
    }
}