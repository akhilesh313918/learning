import { Component } from "@angular/core";
import { NgForm } from "@angular/forms";
import { AuthService } from '../auth.service';
import { MatDialog } from '@angular/material/dialog';

@Component({
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent{
    isLoading = false;
    error = false;

    constructor(public authService: AuthService){}

    onLogin(form: NgForm){
        if(form.invalid){
            return;
        }
        this.authService.login(form.value.email, form.value.password);
        if(this.authService.isError){
            this.error = true;
            form.resetForm();
            return;
        }
        this.isLoading = true;
        form.resetForm();
    }
}