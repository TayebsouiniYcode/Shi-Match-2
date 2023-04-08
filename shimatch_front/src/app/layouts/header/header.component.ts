import { DOCUMENT } from '@angular/common';
import { Component, Inject, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth-service.service';
import { TokenService } from 'src/app/service/token-service.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  username: string | undefined;

  constructor(@Inject(DOCUMENT) private document: Document, private auth: AuthService, private tokenService: TokenService) { }

  ngOnInit(): void {
  }

  logout() {
    this.auth.logout();
  }

  sidebarToggle() {

  }

}
