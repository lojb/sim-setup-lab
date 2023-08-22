import { Injectable } from '@angular/core';
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private isLoggedIn = false;

  constructor(private router: Router) { }

  login(user:any) {
    this.isLoggedIn = true;
    localStorage.setItem('isLoggedIn', 'true');
    localStorage.setItem('token', user.token);
    localStorage.setItem('username', user.username);
    localStorage.setItem('role', user.role);
    localStorage.setItem('userId', user.userId);

    this.router.navigate(['/home']).then();
  }

  logout() {
    this.isLoggedIn = false;
    localStorage.removeItem('isLoggedIn');
    localStorage.removeItem('token');
    localStorage.removeItem('username');
    localStorage.removeItem('role');
    localStorage.removeItem('userId');
  }

  get IsLoggedIn() {
    return this.isLoggedIn;
  }
}
