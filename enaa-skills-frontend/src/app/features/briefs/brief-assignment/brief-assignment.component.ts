import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-brief-assignment',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './brief-assignment.component.html',
  styleUrl: './brief-assignment.component.css'
})
export class BriefAssignmentComponent {

  selectedBrief: any;
  selectedLearner: any;
  selectedCompetency: any;

  // 2. You must provide arrays for the *ngFor loops
  //    (Here is some mock data so you can see it work)
  briefs = [
    { id: 1, title: 'Develop a Web App' },
    { id: 2, title: 'Create a Mobile UI' }
  ];

  learners = [
    'Salmane Krr',
    'John Doe',
    'Jane Smith'
  ];

  competencies = [
    'Angular Framework',
    'UI/UX Design',
    'Database Management'
  ];

  // 3. You must declare the method for (ngSubmit)
  onAssign() {
    console.log('Form Submitted!');
    console.log('Selected Brief ID:', this.selectedBrief);
    console.log('Selected Learner:', this.selectedLearner);
    console.log('Selected Competency:', this.selectedCompetency);
  }


}
