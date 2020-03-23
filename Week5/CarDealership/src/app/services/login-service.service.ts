import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../user';
@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  private readonly url = `http://localhost:8080/CarDealership/login`;

  constructor(private http: HttpClient) {}

  loginUser(user: User){
    return this.http.post<any>(this.url, user);
   }
}
