import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BriefList } from './brief-list';

describe('BriefList', () => {
  let component: BriefList;
  let fixture: ComponentFixture<BriefList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BriefList]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BriefList);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
