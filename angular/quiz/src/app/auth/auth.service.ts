import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { AuthData } from "./auth-data.model";
import { Subject } from 'rxjs';
import { Router } from '@angular/router';
import { environment } from '../../environments/environment';
const BACKEND_URL = environment.apiUrl + "/user";

@Injectable({providedIn: "root"})

export class AuthService{

    private token: string;
    private tokenTimer: any
    public isUserAuthenticate = false;
    public isAdmin = false;
    public error = false;
    public authStatusListener = new Subject<boolean>();
    public adminAuthStatusListener = new Subject<boolean>();

    constructor(private http: HttpClient, private router: Router){}

    getToken(){
        return this.token;
    }

    getUserAuth(){
        return this.isUserAuthenticate;
    }

    getAuthStatusListener(){
        return this.authStatusListener.asObservable();
    }

    getAdminAuthStatusListener(){
        return this.adminAuthStatusListener.asObservable();
    }

    isUserAdmin(){
        return this.isAdmin;
    }

    isError(){
        console.log(this.error);
        return this.error;
    }

    createUser(email: string, password: string){
          console.log("Inside Auth");  
          const authData: AuthData = {email: email, password: password}; 
          this.http.post(BACKEND_URL + "/signup", authData)
          .subscribe(response => {
            this.router.navigate(['/signupsuccess']);
          },error => {
              this.error = true;
          })
    }

    login(email: string, password: string){
        console.log("Inside login");
        const authData: AuthData = {email: email, password: password}; 
        this.http.post<{token: string, isAdmin: any, expiresIn: number}>(BACKEND_URL + "/login", authData)
          .subscribe(response => {
              console.log("Inside login");
              const token = response.token;
              this.token = token;
              if(token){
                  const expiresInDuration = response.expiresIn;
                  this.setAuthTimer(expiresInDuration);
                  this.isUserAuthenticate = true;
                  this.authStatusListener.next(true);
                  const now = new Date();
                  const expirationDate = new Date(now.getTime() + expiresInDuration*1000);
                  if(response.isAdmin){
                    this.isAdmin = response.isAdmin;
                    this.adminAuthStatusListener.next(true);
                    this.saveAuthData(token, expirationDate, this.isAdmin);
                    this.router.navigate(['/list']);
                }else{
                    this.saveAuthData(token, expirationDate, this.isAdmin);
                  this.router.navigate(['/list']);
                }
                  
              }
              
          }, (error) => {
            console.log("there is a error"+error);
            this.error = true;
          })
    }

    autoAuthUser(){
        const authInformation = this.getAuthData();
        if(!authInformation){
            return;
        }
        const now = new Date();
        const expiresIn = authInformation.expirationDate.getTime() - now.getTime(); 
        console.log("expiresIn>>"+ expiresIn);
        if(expiresIn > 0){
            this.token = authInformation.token;
            this.isUserAuthenticate = true;
            this.isAdmin = Boolean(localStorage.getItem('isAdmin'));
            this.setAuthTimer(expiresIn / 1000);
            this.authStatusListener.next(true);
        }

    }

    logout(){
        if(this.isAdmin){
            this.isAdmin=false;
        }
        this.token = null;
        this.isUserAuthenticate = false;
        this.authStatusListener.next(false);
        clearTimeout(this.tokenTimer);
        this.clearAuthData();
        this.router.navigate(['/']);
    }

    setAuthTimer(duration: number){
        console.log("Setting Timer: " + duration);
        this.tokenTimer = setTimeout(() => {
            this.logout();
          }, duration * 1000)
    }

    private saveAuthData(token: string, expirationDate: Date, isAdmin: boolean){
        localStorage.setItem('token', token);
        localStorage.setItem('expiration', expirationDate.toISOString());
        localStorage.setItem('isAdmin', JSON.stringify(isAdmin));
       
    }

    private clearAuthData(){
        localStorage.removeItem("token");
        localStorage.removeItem("expiration"); 
        localStorage.removeItem("isAdmin");
    }

    private getAuthData(){
        const token = localStorage.getItem("token");
        const expirationDate = localStorage.getItem("expiration");
        if(!token || !expirationDate){
            return;
        }
        return{
            token: token,
            expirationDate: new Date(expirationDate)
        }
    }
}