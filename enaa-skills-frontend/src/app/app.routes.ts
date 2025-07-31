import { Routes } from '@angular/router';

import {CompetenceForm} from './features/competences/competence-form/competence-form';
import {CompetenceList} from './features/competences/competence-list/competence-list';

export const routes: Routes = [

  {path:'add-skill',component:CompetenceForm},
  {path:'skills',component:CompetenceList}
];
