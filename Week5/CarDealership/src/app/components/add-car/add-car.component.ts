import { Component, OnInit } from '@angular/core';
import { Car } from '../../models/Car';
import { CarService } from '../../services/car.service';

@Component({
  selector: 'app-add-car',
  templateUrl: './add-car.component.html',
  styleUrls: ['./add-car.component.css']
})
export class AddCarComponent implements OnInit {

  constructor(private carService: CarService) { }

  add(make: string, model: string, year: number, vin: string): void {

    // const newCar = new Car(
    //   make,
    //   model,
    //   year,
    //   vin
    // );
    /* this.carService.addCar(newCar as Car)
      .subscribe(); */
  }

  ngOnInit() {
  }

}
