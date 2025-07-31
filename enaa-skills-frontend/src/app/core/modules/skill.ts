import {SubSkill} from './subSkill';

export interface Skill {
  id?: number;
  name: string;
  validate?: boolean;
  subSkills: SubSkill[];
}
