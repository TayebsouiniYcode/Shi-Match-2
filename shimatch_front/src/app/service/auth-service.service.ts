import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { RegisterRequestDTO } from '../dto/RegisterRequestDTO';

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  private baseUrl = "http://localhost:8080/auth/login"
  constructor(private http: HttpClient, private router: Router) { }

  //login(loginForm: LoginForm): Observable<any> {
  //  return this.http.post(this.baseUrl, loginForm, { responseType: 'text' });
  //}

  register(registerRequestDto: RegisterRequestDTO): Observable<any>{
    return this.http.post("http://localhost:8080/auth/register", registerRequestDto);
  }

  logout() {
    localStorage.clear();
    this.router.navigate(['/login']);
  }

  isAuthenticate(): boolean {
    let token = localStorage.getItem("token");

    if (token) {
      return true;
    } else {
      return false;
    }
  }
}
