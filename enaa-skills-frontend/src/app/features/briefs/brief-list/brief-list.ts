// src/app/features/briefs/brief-list/brief-list.component.ts

import { Component } from '@angular/core';
// You MUST import these two modules
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-brief-list',
  standalone: true,
  // Add CommonModule and RouterModule to the imports array
  imports: [CommonModule, RouterModule],
 templateUrl: './brief-list.html',
  styleUrl: './brief-list.css'
})
export class BriefList {
  // You must provide an array for the *ngFor loop
  // Here is some mock data so you can see it work
  briefs = [
    {
      id: 1,
      title: 'Develop a Web App',
      description: 'Create a full-stack web application.',
      learner: 'Salmane Krr',
      competency: 'Angular & Spring Boot'
    },
    {
      id: 2,
      title: 'Create a Mobile UI',
      description: 'Design the user interface for a mobile app.',
      learner: 'John Doe',
      competency: 'UI/UX Design'
    },
    {
      id: 3,
      title: 'Database Schema Design',
      description: 'Model a relational database for an e-commerce site.',
      learner: 'Jane Smith',
      competency: 'SQL & Database Management'
    }
  ];
}