import { Pipe, PipeTransform } from '@angular/core';
import { Car } from '../models/Car';

@Pipe({
  name: 'carPipe'
})
export class CarPipePipe implements PipeTransform {

  transform(value: Car[], ...args: string[]): Car[] {

    console.log(args);

    if (!args[0]) {
      return value;
    }

    let searchValue = args[0].toLowerCase();

    return value.filter(car => {
      if (car.make.toLowerCase().includes(searchValue)) {
        return true;
      } else if (car.model.toLowerCase().includes(searchValue)) {
        return true;
      } else if (car.year.toString().toLowerCase().includes(searchValue)) {
        return true;
      } else if (car.vin.toLowerCase().includes(searchValue)) {
        return true;
      }
      return false;
    });

  }
}
