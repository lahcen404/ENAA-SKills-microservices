// In src/app/features/briefs/brief-assignment/brief-assignment.component.ts

import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { BriefService } from '../brief.service';

@Component({
  selector: 'app-brief-assignment',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './brief-assignment.component.html',
  styleUrls: ['./brief-assignment.component.css']
})
export class BriefAssignmentComponent implements OnInit {
  // Properties for ngModel
  selectedBriefId: number | null = null;
  selectedLearnerId: number | null = null;
  selectedCompetencyId: number | null = null; // Note: the backend doesn't use this yet

  // Arrays for the dropdowns
  briefs: any[] = [];
  learners: any[] = [];
  competencies: any[] = [];

  constructor(
    private briefService: BriefService,
    private router: Router
  ) {}

  ngOnInit(): void {
    // Fetch data for all three dropdowns when the page loads
    this.briefService.getBriefs().subscribe(data => this.briefs = data);
    this.briefService.getLearners().subscribe(data => this.learners = data);
    // You'll need to create getCompetencies() in your service if it's not there
    // this.briefService.getCompetencies().subscribe(data => this.competencies = data);
  }

  onAssign() {
    if (this.selectedBriefId && this.selectedLearnerId) {
      this.briefService.assignBrief(this.selectedBriefId, this.selectedLearnerId).subscribe(() => {
        console.log('Assignment successful!');
        this.router.navigate(['/briefs']);
      });
    } else {
      console.error('Brief and Learner must be selected.');
    }
  }
}