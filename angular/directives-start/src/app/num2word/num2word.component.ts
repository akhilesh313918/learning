import { computeDecimalDigest } from '@angular/compiler/src/i18n/digest';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-num2word',
  templateUrl: './num2word.component.html',
  styleUrls: ['./num2word.component.css']
})
export class Num2wordComponent implements OnInit {

  public number: number;
  public word: String;
  public units = ["", "One" , "Two" , "Three", "Four", "Five", 
                  "Six",  "Seven", "Eight", "Nine", "Ten", "Eleven", "Tweleve", "Thirteen", "Fourteen",
                  "Fifteen", "Sixteen", "Seventeen", "Eighteen",
                  "Ninteen" ];
                  
  public tens = ["", "Ten", "Twenty", "Thirty", "Fourty", "Fifty",
                      "Sixty", "Seventy", "Eighty", "Ninty"]                
  
  constructor() { }

  ngOnInit(): void {
  }

  //this is the key up event, which is triggered on every keystroke
  onkeyUp(event:any){
  this.word = "";
  this.number = +(event.target.value); //typecasting string to number
  
  //if number is zero, then it will return from here
  if(this.number == 0){
    return;
  }
  
  //if number is greater than zero
  if(this.number > 0){
    this.compute(this.number);
  }
  }

  //function for converting number to words
  private compute(num: number) : String{
    this.word = "";

    //If number is greater than crore. check it will be divisible
    if(Math.floor(num/10000000) > 0){ 
      this.word += this.compute(Math.floor(num/10000000))+" crore ";
      num %= 10000000;
    }

    //If number is greater than lakh. check it will be divisible
    if(Math.floor(num/100000) > 0){
      this.word += this.compute(Math.floor(num/100000))+" Lakh ";
      num %= 100000;
    }

     //If number is greater than thousand. check it will be divisible
    if(Math.floor(num/1000) > 0){
      this.word += this.compute(Math.floor(num/1000))+" Thousand ";
      num %= 1000;
    }

     //If number is greater than hundred. check it will be divisible
    if(Math.floor(num/100) > 0){
      this.word += this.compute(Math.floor(num/100)) +" hundred ";
      num %= 100;
    }

    if(num > 0){
      //If number is less than Twenty
      if(num < 20){
        this.word += this.units[num];
      }
    else{ // number is greater than Twenty
        this.word += this.tens[Math.floor(num/10)];
        
        if((Math.floor(num%10))>0){
          this.word += " "+this.units[Math.floor(num%10)];
        }
      }
    }
    return this.word;
  }

}
