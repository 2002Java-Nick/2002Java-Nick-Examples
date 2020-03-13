import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'CarDealership';

  helloWorld(e: Event) {
    alert(`Hello World`);
  }

}
