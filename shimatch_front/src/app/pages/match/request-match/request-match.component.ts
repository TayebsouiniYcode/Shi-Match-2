import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MatchService } from 'src/app/service/match.service';
import { RequestCreateMatch } from 'src/app/utils/request-create-match';

@Component({
  selector: 'app-request-match',
  templateUrl: './request-match.component.html',
  styleUrls: ['./request-match.component.css']
})
export class RequestMatchComponent implements OnInit {

  requestCreateMatch = new RequestCreateMatch();

  constructor(private activatedRoute: ActivatedRoute,
    private matchService: MatchService,
    private router: Router) { }

  ngOnInit(): void {
  }

  requestMatch() {

    this.requestCreateMatch.id_team2 = Number.parseInt(this.activatedRoute.snapshot.params["id"]);

    this.matchService.requestMatch(this.requestCreateMatch).subscribe(
      (data) => {
        console.log(data);
        this.router.navigate(['/match/matchs'])
      }
    )


  }
}
