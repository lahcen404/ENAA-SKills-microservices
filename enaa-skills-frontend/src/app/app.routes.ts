import { Routes } from '@angular/router';
import { BriefList } from './features/briefs/brief-list/brief-list';
import { BriefForm } from './features/briefs/brief-form/brief-form';
import { BriefAssignmentComponent } from './features/briefs/brief-assignment/brief-assignment.component';

export const routes: Routes = [
  
  { path: 'briefs', component: BriefList },
  { path: 'briefs/new', component: BriefForm },
  { path: 'briefs/edit/:id', component: BriefForm },
  { path: 'briefs/assign', component: BriefAssignmentComponent },
  { path: '', redirectTo: '/briefs', pathMatch: 'full' }
];