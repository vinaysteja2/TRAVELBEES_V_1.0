import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  
  private apiUrl = environment.apiUrl;
  
  private loggedIn = false;
  private userRole: string | null = null;

  constructor(private router: Router) {}

  login(token: string, role: string,id:string) {
    this.loggedIn = true;
    localStorage.setItem('token', token);
    localStorage.setItem('role', role);
    localStorage.setItem('id',id);
    this.userRole = role;
  }

  logout() {
    this.loggedIn = false;
    localStorage.removeItem('token');
    localStorage.removeItem('role');
    localStorage.removeItem('id');
    this.userRole = null;
    this.router.navigate(['/user-registration/userLogin']);
  }
  Adminlogout() {
    this.loggedIn = false;
    localStorage.removeItem('token');
    localStorage.removeItem('role');
    localStorage.removeItem('id');
    this.userRole = null;
    this.router.navigate(['/admin-registration/userLogin']);
  }


  isLoggedIn(): boolean {
    return this.loggedIn;
  }

  getRole(): string | null {
    return this.userRole;
  }
}
