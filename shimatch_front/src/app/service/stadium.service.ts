import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Stadium } from '../model/Stadium';

@Injectable({
  providedIn: 'root'
})
export class StadiumService {

  constructor(private http: HttpClient, private router: Router) { }

  getAllStadiumByOwner(id: number): Observable<Stadium[]> {
    return this.http.get<Stadium[]>("http://localhost:8080/api/stadium/byOwner/" + id);
  }
}
