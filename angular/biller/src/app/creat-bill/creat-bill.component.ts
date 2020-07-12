import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Product } from '../products/product.model';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-creat-bill',
  templateUrl: './creat-bill.component.html',
  styleUrls: ['./creat-bill.component.css']
})
export class CreatBillComponent implements OnInit {

  public products: Product[] = [ 
    new Product(1,'Amplifier', 'Sharp', 'Sharp', 800),
    new Product(2,'Node', 'Metro', 'Metro', 1000),
  ];

  @ViewChild('genBill')genbill: NgForm
  

  constructor() { }

  ngOnInit(): void {
  }

  initForm(){

  }

  displayedColumns: string[] = ['description','price','quant','total','delete'];
  dataSource = new MatTableDataSource(this.products) //Product;

  onGenBill(form: NgForm){
    console.log(this.genbill.value)
  }

  addCustomField(){
    let fieldCount: number;
  }
}
