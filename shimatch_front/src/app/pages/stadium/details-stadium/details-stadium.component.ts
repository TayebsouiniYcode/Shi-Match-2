import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Stadium } from 'src/app/model/Stadium';
import { StadiumService } from 'src/app/service/stadium.service';

@Component({
  selector: 'app-details-stadium',
  templateUrl: './details-stadium.component.html',
  styleUrls: ['./details-stadium.component.css']
})
export class DetailsStadiumComponent implements OnInit {

  stadium = new Stadium();

  constructor(private stadiumService: StadiumService,
    private activateRouter: ActivatedRoute,) { }

  ngOnInit(): void {
    this.stadiumService.getStadiumById(this.activateRouter.snapshot.params["id"]).subscribe(
      (data) => {
        this.stadium = data;
      }
    )
  }

  deleteStadium(){
    this.stadiumService.deleteStadium(this.activateRouter.snapshot.params["id"]).subscribe(
      (data) => {
        console.log(data);
      }
    );
  }

}
