import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from '../../Services/login-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private readonly url = `http://localhost:8080/CarDealership/login`;

  userData = {
    name: '',
    password: ''
  };
  constructor(private router: Router , private userService: LoginServiceService) { }

  ngOnInit() {
  }

  loginUser() {
    this.userService.loginUser(this.userData).subscribe(
//there should be logic here to change login component to car list component
      this.router.navigate(['/car-lot'])
    );
  }

}
