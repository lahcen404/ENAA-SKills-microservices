import { Routes } from '@angular/router';

import {CompetenceForm} from './features/competences/competence-form/competence-form';

import {CompetenceList} from './features/competences/competence-list/competence-list';
import {Login} from './features/auth/login/login';
import {Register} from './features/auth/register/register';

export const routes: Routes = [

  {path:'add-skill',component:CompetenceForm},

  {path:'skills',component:CompetenceList},
  {path:'login',component:Login},
  {path:'register',component:Register}

];
