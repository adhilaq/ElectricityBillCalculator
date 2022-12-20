import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetBillbyCityComponent } from './get-billby-city.component';

describe('GetBillbyCityComponent', () => {
  let component: GetBillbyCityComponent;
  let fixture: ComponentFixture<GetBillbyCityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetBillbyCityComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetBillbyCityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
