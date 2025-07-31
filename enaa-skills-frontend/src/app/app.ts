import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { BriefAssignmentComponent } from './features/briefs/brief-assignment/brief-assignment.component';
import { BriefFormComponent } from './features/briefs/brief-form/brief-form.component';
import { BriefListComponent } from './features/briefs/brief-list/brief-list';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,BriefAssignmentComponent,],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'enaa-skills-frontend';
}
