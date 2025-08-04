import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompetenceCard } from './competence-card';

describe('CompetenceCard', () => {
  let component: CompetenceCard;
  let fixture: ComponentFixture<CompetenceCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompetenceCard]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CompetenceCard);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
