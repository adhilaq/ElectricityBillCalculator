import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllBillComponent } from './get-all-bill.component';

describe('GetAllBillComponent', () => {
  let component: GetAllBillComponent;
  let fixture: ComponentFixture<GetAllBillComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetAllBillComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAllBillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
