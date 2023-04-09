import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Team } from 'src/app/model/Team';
import { TeamService } from 'src/app/service/team.service';

@Component({
  selector: 'app-create-team',
  templateUrl: './create-team.component.html',
  styleUrls: ['./create-team.component.css']
})
export class CreateTeamComponent implements OnInit {

  team = new Team()

  constructor(private teamService: TeamService, private router: Router) { }

  ngOnInit(): void {
  }

  create() {
    this.teamService.createTeam(this.team).subscribe(
      (data) => {
        console.log(data);
        this.router.navigate(['/team/teams'])
      }
    );
  }
}
