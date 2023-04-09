import { Component, OnInit } from '@angular/core';
import { Stadium } from 'src/app/model/Stadium';

@Component({
  selector: 'app-create-stadium',
  templateUrl: './create-stadium.component.html',
  styleUrls: ['./create-stadium.component.css']
})
export class CreateStadiumComponent implements OnInit {

  stadium = new Stadium();

  constructor() { }

  ngOnInit(): void {
  }

  create() {

  }

}
