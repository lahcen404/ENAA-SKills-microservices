// In src/app/features/briefs/brief-form/brief-form.ts
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { BriefService } from '../brief.service';

@Component({
  selector: 'app-brief-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './brief-form.html',
  styleUrls: ['./brief-form.css']
})
export class BriefForm implements OnInit {
  isEdit = false;
  brief: any = { /* ... */ };
  learners: any[] = [];
  competencies: any[] = [];
  private currentBriefId: number | null = null; // To store the ID in edit mode

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private briefService: BriefService
  ) {}

  ngOnInit(): void {
    this.loadDropdownData();

    const briefIdString = this.route.snapshot.paramMap.get('id');
    if (briefIdString) {
      this.isEdit = true;
      this.currentBriefId = parseInt(briefIdString, 10);
      
      // Fetch the existing brief data from the backend
      this.briefService.getBriefById(this.currentBriefId).subscribe(data => {
        this.brief = data;
      });
    }
  }

  loadDropdownData(): void {
    // ... (same as before)
  }

  onSubmit() {
    if (this.isEdit && this.currentBriefId) {
      // Call the update service method
      this.briefService.updateBrief(this.currentBriefId, this.brief).subscribe(() => {
        this.router.navigate(['/briefs']);
      });
    } else {
      // Existing create logic
      this.briefService.createBrief(this.brief).subscribe(() => {
        this.router.navigate(['/briefs']);
      });
    }
  }
}