import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})

export class RegisterUserComponent implements OnInit {
  private readonly url = `http://localhost:8080/CarDealership/register`;
  username = ``;
  password = ``;

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit() {
  }

  registerUser(): void {
    let user = {username: this.username, password: this.password};
    this.http.post(this.url, user, this.httpOptions).subscribe(
      (data) => this.router.navigateByUrl('/login')
    );
  }
}