import { Routes } from '@angular/router';

import {CompetenceForm} from './features/competences/competence-form/competence-form';

import {CompetenceList} from './features/competences/competence-list/competence-list';
import {UpdateCompetence} from './features/competences/update-competence/update-competence';

export const routes: Routes = [

  {path:'add-skill',component:CompetenceForm},
  {path:'edit-skill/:id',component:UpdateCompetence},
  {path:'skills',component:CompetenceList}
];
