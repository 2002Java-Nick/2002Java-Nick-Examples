import { Component, OnInit } from '@angular/core';
import { Car } from 'src/app/models/Car';

import { CarService } from 'src/app/services/car.service';

@Component({
  selector: 'app-car-lot',
  templateUrl: './car-lot.component.html',
  styleUrls: ['./car-lot.component.css']
})
export class CarLotComponent implements OnInit {

  carLotHeader = `Revature Car Dealership... I dunno`;

  carList: Car[];

  constructor(private carService: CarService) { }

  ngOnInit() {
    this.carList = this.carService.listCars();
    console.log(this.carList);
  }

}
