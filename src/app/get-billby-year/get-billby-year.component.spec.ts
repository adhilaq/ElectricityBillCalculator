import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetBillbyYearComponent } from './get-billby-year.component';

describe('GetBillbyYearComponent', () => {
  let component: GetBillbyYearComponent;
  let fixture: ComponentFixture<GetBillbyYearComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetBillbyYearComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetBillbyYearComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
