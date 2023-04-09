import { Component, OnInit } from '@angular/core';
import { TeamService } from 'src/app/service/team.service';

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css']
})
export class TeamsComponent implements OnInit {

  teamList?: any[];

  constructor(private teamsService: TeamService) { }

  ngOnInit(): void {
    this.getAllTeams();
  }

  getAllTeams(): void {
    this.teamsService.getAllTeams().subscribe(
      (data) => {
        this.teamList = data;
      }
    )
  }

  hasTeam() {
    return false;
  }

}
