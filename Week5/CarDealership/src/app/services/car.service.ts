import { Injectable } from '@angular/core';
import { Car } from '../models/Car';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  private carListJson = `[
    {
  "make": "Ford",
    "model": "F-120",
      "year": 1920,
        "vin": "some string of numbers"
},
{
  "make": "Chevy",
    "model": "Sonic",
      "year": 2013,
        "vin": "123LKAGIE"
},
{
  "make": "Ford",
    "model": "Mustang",
      "year": 2017,
        "vin": "LKASJD8390SKOSDIO"
},
{
  "make": "Toyota",
    "model": "Tacoma",
      "year": 1950,
        "vin": "12SADF525"
},
{
  "make": "Nissan",
    "model": "Frontier",
      "year": 2013,
        "vin": "yadayadayada"
},
{
  "make": "Hyundai",
    "model": "Elantra",
      "year": 2019,
        "vin": "10923847"
},
{
  "make": "Otherworld",
    "model": "Explorer",
      "year": 2020,
        "vin": "48163264"
},
{
  "make": "Tesla",
    "model": "3",
      "year": 2020,
        "vin": "AF42C22"
},
{
  "make": "Ram",
    "model": "Rebel",
      "year": 2018,
        "vin": "999999999"
},
{
  "make": "Toyota",
    "model": "Prius",
      "year": 2001,
        "vin": "JKP2934"
}
]`;

private readonly URL = `http://localhost:8080/CarDealership/car`; // URL to web api

httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

carList: Car[];

  public listCars(): Observable<Car[]> {
    return this.http.get<Car[]>(this.URL);
  }

  public addCar(car: Car): Observable<Car> {
    return this.http.post<Car>(this.URL, car);
  }

  constructor(private http: HttpClient) {
    this.carList = JSON.parse(this.carListJson);
   }




}
