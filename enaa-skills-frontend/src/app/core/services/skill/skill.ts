import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Skill} from '../../modules/skill';

@Injectable({
  providedIn: 'root'
})
export class SkillService {
  apiUrl="http://localhost:8083/skills";

  constructor(private http: HttpClient){}

  addSkill(skill: Skill):Observable<Skill>{
    return this.http.post<Skill>(this.apiUrl,skill);
  }

  getAllSkills():Observable<Skill[]>{
    return this.http.get<Skill[]>(this.apiUrl);
  }

  getSkillById(id:number):Observable<Skill>{
    return this.http.get<Skill>(`${this.apiUrl}/${id}`);
  }

  deleteSkill(id: number):Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
