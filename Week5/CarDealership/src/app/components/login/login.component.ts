import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from '../../Services/login-service.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup } from '@angular/forms';
import { User } from 'src/app/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm = new FormGroup({
    name: new FormControl(''),
    password: new FormControl('')
  });

  get name() {
    return this.loginForm.get('name');
  }

  get password() {
    return this.loginForm.get('password');
  }

  constructor(private router: Router, private userService: LoginServiceService) { }

  ngOnInit() {
  }

  loginUser(value, valid) {
    console.log('inside loginUser method');
    const name = this.loginForm.get('name');
    const password = this.loginForm.get('password');
    const user = new User(name.value, password.value);
    this.userService.loginUser(user).subscribe(
      (data) => this.router.navigateByUrl('/carLot')
    );
  }

}
