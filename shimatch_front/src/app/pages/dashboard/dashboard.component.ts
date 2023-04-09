import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Stadium } from 'src/app/model/Stadium';
import { StadiumService } from 'src/app/service/stadium.service';
import { TeamService } from 'src/app/service/team.service';
import { TokenService } from 'src/app/service/token-service.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(
    private router: Router,
    private tokenService: TokenService,
    private userService: UserService,
    private teamService: TeamService,
    private stadiumService: StadiumService) { }

  userList?: any[];
  teamList?: any[];
  stadiumList?: any[];
  numberOfUsers?: number;
  numberOfTeams?: number;
  numberOfStadium?: number;
  stadiumByOwner?: any[];

  user?: any;

  ngOnInit(): void {
    this.getAllUsers();
    this.getAllTeams();
    this.gettAllStadiumByOwner(32);
  }

  getAllUsers(): void {
    this.userService.getAllUsers().subscribe(
      (data) => {
        this.userList = data;
        this.numberOfUsers= data.length;
      });
  }

  getAllTeams(): void {
    this.teamService.getAllTeams().subscribe(
      (data) => {
        this.teamList = data;
        this.numberOfTeams = data.length;
      });
  }

  gettAllStadiumByOwner(id: number) {
    this.stadiumService.getAllStadiumByOwner(id).subscribe(
      (data) => {
        this.stadiumByOwner = data;
      }
    )
  }

  hasRole(roleName: string) : boolean | any{
    let roles = this.tokenService.getRoles();

    for (const authority in roles) {
      if (roles[authority].authority == roleName) {
        return true;
      }
    }
  }

  userDetails(id: number) {
    console.log(id);
  }

  teamDetails(id: number) {
    console.log(id);
  }

  chargeModal(user: any) {
    this.user = user;
  }

  stadiumDetails(stadium: Stadium) {
    console.log(stadium);
  }

}
