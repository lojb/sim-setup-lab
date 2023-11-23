import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DampersComponent } from './dampers.component';

describe('DampersComponent', () => {
  let component: DampersComponent;
  let fixture: ComponentFixture<DampersComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DampersComponent]
    });
    fixture = TestBed.createComponent(DampersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
