import { Product } from './product.model'
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { Subject } from 'rxjs';




@Injectable()
export class ProductService {

    productsChanged = new Subject<Product[]>();
    private products: Product[] = [];
    //new Product(1,'Amplifier', 'xyz', 'xyz', 100)
    constructor(){}

    setProducts(products: Product[]){
        this.products = products;
        console.log("from Product service" + this.products)
        this.productsChanged.next(this.products.slice())
    }

    getProducts(){
        return this.products.slice();
    }

    addProduct(product: Product){
        this.products.push(product);
        this.productsChanged.next(this.products.slice());
    }
    

    updateProduct(){

    }

    deleteProduct(){

    }

}

/*
.map( product => {
                product.id,
                product.name,
                product.model,
                product.company,
                product.price
            })*/