import { Component, EventEmitter, OnInit, Output, Input } from '@angular/core';
import { Event } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  @Input()
  searchFilter = ``;

  @Output()
  searchFilterChange = new EventEmitter<string>();

  constructor() { }

  ngOnInit() {
  }


}
