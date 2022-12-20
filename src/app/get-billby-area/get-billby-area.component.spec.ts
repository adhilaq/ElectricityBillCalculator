import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetBillbyAreaComponent } from './get-billby-area.component';

describe('GetBillbyAreaComponent', () => {
  let component: GetBillbyAreaComponent;
  let fixture: ComponentFixture<GetBillbyAreaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetBillbyAreaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetBillbyAreaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
