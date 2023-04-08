import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UserDTO } from '../dto/UserDTO';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private router: Router) { }


  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>("http://localhost:8080/api/user/users");
  }
}
