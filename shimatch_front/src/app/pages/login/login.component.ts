import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth-service.service';
import { TokenService } from 'src/app/service/token-service.service';
import { LoginForm } from 'src/app/utils/login-form';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userLogin: LoginForm = new LoginForm();
  role!: string | null;

  constructor(private authService: AuthService, private router: Router, private tokenService: TokenService) {
    const token = localStorage.getItem("token");

    if (token) {
      // TODO Check if admin or proprietaire or client
      this.router.navigate(['/dashboard']);
    }
  }

  ngOnInit(): void {}

  login() {
    console.log("this is login component");
    this.authService.login(this.userLogin).subscribe(
      (token_) => {
        if (token_) {
          localStorage.clear();
          console.log(token_);
          localStorage.setItem("token", token_);
          this.router.navigate(['/dashboard']);
        } else {
          console.log("token is null");
        }
  });

}
}
