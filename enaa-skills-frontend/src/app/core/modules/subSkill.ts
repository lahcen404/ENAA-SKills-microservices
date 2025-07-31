export interface SubSkill {
  id?: number;
  name: string;
  description: string;
  status?: 'VALIDATE' | 'NOT_VALIDATE' ;
}
