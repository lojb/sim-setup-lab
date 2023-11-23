import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FuelStrategyComponent } from './fuel-strategy.component';

describe('FuelStrategyComponent', () => {
  let component: FuelStrategyComponent;
  let fixture: ComponentFixture<FuelStrategyComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FuelStrategyComponent]
    });
    fixture = TestBed.createComponent(FuelStrategyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
