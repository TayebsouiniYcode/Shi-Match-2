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

  createTeam(team: Team) : Observable<any>{
      return this.http.post("http://localhost:8080/api/team/create", team);
  }

  getTeamById(id: number): Observable<any> {
    return this.http.get("http://localhost:8080/api/team/" + id);
  }

  hasTeam(email: string): Observable<Boolean> {
    return this.http.get<Boolean>("http://localhost:8080/api/team/hasTeam/" + email);
  }
}
