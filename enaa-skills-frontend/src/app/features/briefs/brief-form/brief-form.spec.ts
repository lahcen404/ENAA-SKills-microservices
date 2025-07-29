import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BriefForm } from './brief-form';

describe('BriefForm', () => {
  let component: BriefForm;
  let fixture: ComponentFixture<BriefForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BriefForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BriefForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
