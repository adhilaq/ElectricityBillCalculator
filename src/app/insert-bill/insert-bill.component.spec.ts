import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertBillComponent } from './insert-bill.component';

describe('InsertBillComponent', () => {
  let component: InsertBillComponent;
  let fixture: ComponentFixture<InsertBillComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsertBillComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsertBillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
