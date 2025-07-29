import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SousCompetence } from './sous-competence';

describe('SousCompetence', () => {
  let component: SousCompetence;
  let fixture: ComponentFixture<SousCompetence>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SousCompetence]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SousCompetence);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
