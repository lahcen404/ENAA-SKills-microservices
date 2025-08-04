import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateCompetence } from './update-competence';

describe('UpdateCompetence', () => {
  let component: UpdateCompetence;
  let fixture: ComponentFixture<UpdateCompetence>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdateCompetence]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateCompetence);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
