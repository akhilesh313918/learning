import { Component } from "@angular/core";
import { NgForm } from "@angular/forms";
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
    templateUrl: './signup.component.html',
    styleUrls: ['./signup.component.css']
})
export class SignupComponent{
    isLoading = false;
    error = false;

    constructor(public authService: AuthService, public route: Router){}

    onSignup(form: NgForm){
        if(form.invalid){
            return;
        }
        this.authService.createUser(form.value.email, form.value.password);
        if(this.authService.isError){
            this.error = true;
            form.resetForm();
            return;
        }
        this.isLoading = true;
        form.resetForm();

    }
}