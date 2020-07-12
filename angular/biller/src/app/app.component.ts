import { Component, OnInit } from '@angular/core';
import { LoggingService } from './shared/logging.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [LoggingService]
})
export class AppComponent implements OnInit{
  title = 'biller';
  constructor(private loggingService: LoggingService) { }
  _authCheck:boolean = this.loggingService._isLoggedIn; 
  _temp = LoggingService._temp;
  ngOnInit(){
    //this._authCheck = this.loggingService._isLoggedIn;
  }

  check(){
    return this.loggingService._isLoggedIn;
    //console.log("Coming from app loginflg: "+LoggingService._isLoggedIn);
    //console.log("Coming from app temp: "+LoggingService._temp);
    
  }
}
