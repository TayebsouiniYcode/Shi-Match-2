import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Team } from '../model/Team';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  constructor(private http: HttpClient, private router: Router) { }

  getAllTeams(): Observable<any> {
    return this.http.get<Team[]>("http://localhost:8080/api/team/teams");
  }
}
