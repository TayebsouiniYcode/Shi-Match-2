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

  getAllStadiumByOwner(): Observable<Stadium[]> {
    return this.http.get<Stadium[]>("http://localhost:8080/api/stadium/byOwner/");
  }

  createStadium(stadium: Stadium): Observable<any> {
    return this.http.post<Stadium>("http://localhost:8080/api/stadium/create", stadium);
  }

  getStadiumById(id: number): Observable<any> {
    return this.http.get<Stadium>("http://localhost:8080/api/stadium/" + id);
  }

  deleteStadium(id: number): Observable<any> {
    return this.http.delete("http://localhost:8080/api/stadium/delete" + id);
  }
}
