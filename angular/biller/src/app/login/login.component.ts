import { Component, OnInit, ViewChild, ElementRef, Input } from '@angular/core';
import { LoggingService } from '../shared/logging.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  //providers: [LoggingService]
})
export class LoginComponent implements OnInit {
  
  @ViewChild('f') signupForm: NgForm;
  @ViewChild('nameInput') nameInputRef: ElementRef;
  @ViewChild('passInput') passInputRef: ElementRef;
  authLogin: boolean = false;

  constructor(private loggingService: LoggingService,
    private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(form: NgForm){
    //event.preventDefault(); 
    const uname =this.nameInputRef.nativeElement.value;
    const pass = this.passInputRef.nativeElement.value;
    if(uname==='test' && pass==='test'){
      this.loggingService._isLoggedIn = true;
      this.router.navigate(['/home']);
      //LoggingService._temp = 1;
      //this.loggingService.logging.push('true');
      console.log(this.signupForm);
    }
    else{
      //console.log(LoggingService._isLoggedIn);
    }
  }
  


}
