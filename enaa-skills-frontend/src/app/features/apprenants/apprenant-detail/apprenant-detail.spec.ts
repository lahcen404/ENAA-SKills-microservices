import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApprenantDetail } from './apprenant-detail';

describe('ApprenantDetail', () => {
  let component: ApprenantDetail;
  let fixture: ComponentFixture<ApprenantDetail>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ApprenantDetail]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ApprenantDetail);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
