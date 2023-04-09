import { Component, OnInit } from '@angular/core';
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


  constructor(private stadiumService: StadiumService) { }

  ngOnInit(): void {
  }

  create() {
    this.stadium.id_owner = 32;
    this.stadiumService.createStadium(this.stadium).subscribe(
      (data) => {
        console.log(data);
      }
    );
  }

}
