import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterRequestDTO } from 'src/app/dto/RegisterRequestDTO';
import { AuthService } from 'src/app/service/auth-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerRequestDto: RegisterRequestDTO;

  constructor(private auth: AuthService, private router: Router) {
    this.registerRequestDto = new RegisterRequestDTO();
   }

  ngOnInit(): void {
  }


  register() {
    this.auth.register(this.registerRequestDto).subscribe(
      (data) => {
        console.log(data);
        if (data != null) {
          this.router.navigate(['/login']);
        }
      }
    )
  }

}
