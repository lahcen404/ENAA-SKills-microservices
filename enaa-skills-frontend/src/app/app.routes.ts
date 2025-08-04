import { Routes } from '@angular/router';
import { BriefList } from './features/briefs/brief-list/brief-list';
import { BriefForm } from './features/briefs/brief-form/brief-form';
import { BriefAssignmentComponent } from './features/briefs/brief-assignment/brief-assignment.component';
import {CompetenceForm} from './features/competences/competence-form/competence-form';
import {CompetenceList} from './features/competences/competence-list/competence-list';
import {UpdateCompetence} from './features/competences/update-competence/update-competence';
import {Login} from './features/auth/login/login';
import {Register} from './features/auth/register/register';
export const routes: Routes = [
  // Briefs Routes
  { path: 'briefs', component: BriefList },
  { path: 'briefs/new', component: BriefForm },
  { path: 'briefs/edit/:id', component: BriefForm },
  { path: 'briefs/assign', component: BriefAssignmentComponent },

  // Competency/Skill Routes
  { path: 'skills', component: CompetenceList },
  { path: 'add-skill', component: CompetenceForm },
  { path: 'edit-skill/:id', component: UpdateCompetence },
  
  // Auth Routes
  { path: 'login', component: Login },
  { path: 'register', component: Register },

  // Default Route
  { path: '', redirectTo: '/briefs', pathMatch: 'full' }
];
