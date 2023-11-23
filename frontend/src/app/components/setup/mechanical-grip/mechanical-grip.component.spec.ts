import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MechanicalGripComponent } from './mechanical-grip.component';

describe('MechanicalGripComponent', () => {
  let component: MechanicalGripComponent;
  let fixture: ComponentFixture<MechanicalGripComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MechanicalGripComponent]
    });
    fixture = TestBed.createComponent(MechanicalGripComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
