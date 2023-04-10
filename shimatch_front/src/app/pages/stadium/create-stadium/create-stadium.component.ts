import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Stadium } from 'src/app/model/Stadium';
import { StadiumService } from 'src/app/service/stadium.service';
import { CreateStadiumRequest } from 'src/app/utils/create-stadium-requist';

@Component({
  selector: 'app-create-stadium',
  templateUrl: './create-stadium.component.html',
  styleUrls: ['./create-stadium.component.css']
})
export class CreateStadiumComponent implements OnInit {

  stadium = new CreateStadiumRequest();


  constructor(private stadiumService: StadiumService, private router: Router) { }

  ngOnInit(): void {
  }

  create() {
    this.stadiumService.createStadium(this.stadium).subscribe(
      (data) => {
        console.log(data);
        this.router.navigate(['/dashboard'])
      }
    );
  }

}
