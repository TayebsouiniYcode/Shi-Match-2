import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Team } from 'src/app/model/Team';
import { TeamService } from 'src/app/service/team.service';

@Component({
  selector: 'app-details-team',
  templateUrl: './details-team.component.html',
  styleUrls: ['./details-team.component.css']
})
export class DetailsTeamComponent implements OnInit {

  team = new Team();

  constructor(private activatedRoute: ActivatedRoute, private teamService: TeamService) { }

  ngOnInit(): void {
    this.chargeTeam();
  }

  chargeTeam() {
    this.teamService.getTeamById(this.activatedRoute.snapshot.params["id"]).subscribe(
      (data) => {
        this.team = data;
      }
    )
  }

  deleteTeam() {

  }
}
