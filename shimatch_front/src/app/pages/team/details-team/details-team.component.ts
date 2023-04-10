import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Team } from 'src/app/model/Team';
import { TeamService } from 'src/app/service/team.service';
import { TokenService } from 'src/app/service/token-service.service';

@Component({
  selector: 'app-details-team',
  templateUrl: './details-team.component.html',
  styleUrls: ['./details-team.component.css']
})
export class DetailsTeamComponent implements OnInit {

  team = new Team();
  isCapitaine?: boolean;

  constructor(private activatedRoute: ActivatedRoute,
    private teamService: TeamService,
    private tokenService: TokenService) { }

  ngOnInit(): void {
    this.chargeTeam();
  }

  chargeTeam() {
    this.teamService.getTeamById(this.activatedRoute.snapshot.params["id"]).subscribe(
      (data) => {
        this.team = data;
      }
    )
    this.ownerOfThisTeam();
  }

  deleteTeam() {

  }

  hasTeam(): boolean {
    let email = this.tokenService.getUsername();
    let hasTeam = this.teamService.hasTeam(email);
    console.log(hasTeam);
    return true;
  }

  isValid(): boolean {
    return true;
  }

  ownerOfThisTeam(): void {

    this.teamService.getCapitaine(this.activatedRoute.snapshot.params["id"]).subscribe(
      (data) => {
        let capitaine = data.email;
        let username = this.tokenService.getUsername();
        console.log(username);
        console.log(capitaine);

        this.isCapitaine = false;

        if (username == capitaine) this.isCapitaine=  true;

      }
    );
  }

}
