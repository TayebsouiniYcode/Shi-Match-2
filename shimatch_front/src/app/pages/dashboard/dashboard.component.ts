import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenService } from 'src/app/service/token-service.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private router: Router,private tokenService: TokenService) { }

  ngOnInit(): void {
  }

  hasRole(roleName: string) : boolean | any{
    let roles = this.tokenService.getRoles();

    for (const authority in roles) {
      if (roles[authority].authority == roleName) {
        return true;
      }
    }
  }

}
