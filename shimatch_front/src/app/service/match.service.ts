import { Injectable } from '@angular/core';
import { RequestCreateMatch } from '../utils/request-create-match';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MatchService {

  constructor(private http: HttpClient, private router: Router) { }

  requestMatch(requestCreateMAtch: RequestCreateMatch): Observable<any> {
    return this.http.post("http://localhost:8080/api/user/match", requestCreateMAtch);
  }
}
