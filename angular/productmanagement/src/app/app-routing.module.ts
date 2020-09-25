import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddProductComponent } from './products/add-product/add-product.component';
import { ProductsListComponent } from './products/products-list/products-list.component';


const routes: Routes = [
    {path: '', component: ProductsListComponent},
    {path: 'add', component: AddProductComponent},
    {path: 'edit/:id', component: AddProductComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule{

}