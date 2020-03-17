import { Component, OnInit } from '@angular/core';
import { NgForm, FormsModule } from '@angular/forms';
import { Car } from 'src/app/models/Car';

import { CarService } from 'src/app/services/car.service';

@Component({
  selector: 'app-car-lot',
  templateUrl: './car-lot.component.html',
  styleUrls: ['./car-lot.component.css']
})
export class CarLotComponent implements OnInit {

  carLotHeader = `Revature Car Dealership... I dunno`;

  searchFilter = ``;

  carList: Car[];

  constructor(private carService: CarService) { }

  ngOnInit() {
    this.carService.listCars().subscribe(carList => this.carList  = carList);
    console.log(this.carList);
  }

}
