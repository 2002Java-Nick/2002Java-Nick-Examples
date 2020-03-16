import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarLotComponent } from './car-lot.component';

describe('CarLotComponent', () => {
  let component: CarLotComponent;
  let fixture: ComponentFixture<CarLotComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarLotComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarLotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
