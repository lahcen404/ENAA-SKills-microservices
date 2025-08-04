import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BriefAssignmentComponent } from './brief-assignment.component';

describe('BriefAssignmentComponent', () => {
  let component: BriefAssignmentComponent;
  let fixture: ComponentFixture<BriefAssignmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BriefAssignmentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BriefAssignmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
