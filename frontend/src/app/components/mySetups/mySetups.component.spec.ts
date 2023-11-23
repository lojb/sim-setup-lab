import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MySetupsComponent } from './mySetups.component';

describe('UserComponent', () => {
  let component: MySetupsComponent;
  let fixture: ComponentFixture<MySetupsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MySetupsComponent]
    });
    fixture = TestBed.createComponent(MySetupsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
