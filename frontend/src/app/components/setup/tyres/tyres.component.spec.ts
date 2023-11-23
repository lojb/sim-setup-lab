import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TyresComponent } from './tyres.component';

describe('TyresComponent', () => {
  let component: TyresComponent;
  let fixture: ComponentFixture<TyresComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TyresComponent]
    });
    fixture = TestBed.createComponent(TyresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
