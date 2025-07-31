import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { BriefAssignmentComponent } from './features/briefs/brief-assignment/brief-assignment.component';
import { BriefForm } from './features/briefs/brief-form/brief-form';
import { BriefList } from './features/briefs/brief-list/brief-list';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet,BriefAssignmentComponent,BriefForm,BriefList],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'enaa-skills-frontend';
}
