import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterUserComponent } from './components/register-user/register-user.component';
import { CarLotComponent } from './components/car-lot/car-lot.component';
import { AddCarComponent } from './components/add-car/add-car.component';
import { LoginComponent } from './components/login/login.component';


const routes: Routes = [
  {path: 'register', component: RegisterUserComponent},
  {path: 'carLot', component: CarLotComponent},
  {path: 'addCar', component: AddCarComponent},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
