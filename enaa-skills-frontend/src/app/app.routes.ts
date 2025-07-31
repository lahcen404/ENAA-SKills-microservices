import { Routes } from '@angular/router';
import { BriefList } from './features/briefs/brief-list/brief-list';
import { BriefForm } from './features/briefs/brief-form/brief-form';
import { BriefAssignmentComponent } from './features/briefs/brief-assignment/brief-assignment.component';

export const routes: Routes = [
  { path: '', component: BriefList },
  { path: 'create', component: BriefForm },
  { path: 'edit/:id', component: BriefForm },
  { path: 'assign', component: BriefAssignmentComponent }
];