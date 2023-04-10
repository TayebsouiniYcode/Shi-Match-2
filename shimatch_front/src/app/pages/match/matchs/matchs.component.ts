import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-matchs',
  templateUrl: './matchs.component.html',
  styleUrls: ['./matchs.component.css']
})
export class MatchsComponent implements OnInit {

  matchList?: any[];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.chargerMatch();
  }

  chargerMatch() {
    this.userService.getAllMatchByUser().subscribe(
      (data) => {
        this.matchList = data;
      }
    )
  }

}
