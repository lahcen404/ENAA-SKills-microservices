import { Routes } from '@angular/router';

import {CompetenceForm} from './features/competences/competence-form/competence-form';
import {Register} from './features/auth/register/register';
import {Login} from './features/auth/login/login';

export const routes: Routes = [

  {path:'add-skill',component:CompetenceForm},
  {path:'register', component: Register},
  {path:'login',component:Login}
];
