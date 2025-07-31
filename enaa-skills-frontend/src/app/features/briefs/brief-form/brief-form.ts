// src/app/features/briefs/brief-form/brief-form.component.ts

import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-brief-form',
  standalone: true,
  // You need CommonModule for *ngFor and FormsModule for all form features
  imports: [CommonModule, FormsModule],
  templateUrl: './brief-form.html',
  styleUrls: ['./brief-form.css']
})
export class BriefForm implements OnInit {
  // Property to check if we are in "edit" mode
  isEdit = false;

  // The main object that holds all the form data
  brief: any = {
    title: '',
    description: '',
    learner: '',
    competency: ''
  };

  // Mock data for the dropdowns
  learners = ['Salmane Krr', 'John Doe', 'Jane Smith'];
  competencies = ['Angular', 'UI/UX Design', 'SQL'];

  constructor(
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    // Check the URL for an 'id' parameter
    const briefId = this.route.snapshot.paramMap.get('id');
    if (briefId) {
      // If an ID exists, we are in "edit" mode
      this.isEdit = true;
      // In a real app, you would fetch the brief's data from a service
      // For now, we'll just pre-fill it with mock data.
      this.brief = {
        id: briefId,
        title: 'Existing Brief Title',
        description: 'Existing description from backend.',
        learner: 'John Doe',
        competency: 'UI/UX Design'
      };
    }
  }

  // Method for the (ngSubmit) event
  onSubmit() {
    if (this.isEdit) {
      console.log('Updating brief:', this.brief);
      // Logic to update an existing brief
    } else {
      console.log('Creating new brief:', this.brief);
      // Logic to create a new brief
    }
    // Navigate back to the list after saving
    this.router.navigate(['/briefs']);
  }
}