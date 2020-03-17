import { Component, OnInit } from '@angular/core';
import { User } from '../../user';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})

export class RegisterUserComponent implements OnInit {
  private readonly url = `http://localhost:8080/CarDealership/user`;
  username = ``;
  password = ``;

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  registerUser(): void {
    let user = {username: this.username, password: this.password};
    this.http.post(this.url, user, this.httpOptions).subscribe();
  }
}