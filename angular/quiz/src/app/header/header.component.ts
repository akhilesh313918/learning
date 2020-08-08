import { Component, OnInit, OnDestroy } from '@angular/core';
import { AuthService } from '../auth/auth.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, OnDestroy {


  public isAdmin = false;
  public isUserAuthenticated = false;
  public authListenerSubs: Subscription;
  public isAdminListenerSubs: Subscription;

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  this.isUserAuthenticated = this.authService.getUserAuth();  
  this.authListenerSubs = this.authService
    .getAuthStatusListener().subscribe(isAuthenticated => {
      this.isUserAuthenticated = isAuthenticated;
    })
  this.isAdminListenerSubs = this.authService
  .getAdminAuthStatusListener().subscribe(isAdmin =>{
    this.isAdmin = isAdmin;
    console.log(">>>>>>"+this.isAdmin);
  }) 
  }

  ngOnDestroy(){
    this.authListenerSubs.unsubscribe();
  }

  onLogout(){
    this.authService.logout();
    this.isAdmin = false;
  }
}
