import {Component, OnInit} from '@angular/core';
import {CompetenceCard} from '../competence-card/competence-card';
import {SkillService} from '../../../core/services/skill/skill';
import {catchError, Observable, of, tap} from 'rxjs';
import {Skill} from '../../../core/modules/skill';
import {AsyncPipe, NgForOf, NgIf} from '@angular/common';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-competence-list',
  imports: [
    CompetenceCard,
    AsyncPipe,
    NgForOf,
    NgIf,
    RouterLink
  ],
  templateUrl: './competence-list.html',
  styleUrl: './competence-list.css'
})
export class CompetenceList implements OnInit{

  skill$! : Observable<Skill[]>;
  error: string | null = null;


  constructor(private skillService: SkillService){}

  ngOnInit(): void {
    this.loadSkills();
  }

  loadSkills(): void{
    this.error=null;

    this.skill$ = this.skillService.getAllSkills().pipe(
      tap(data => console.log("data skills : " , data)),

      catchError(err => {
        this.error = "faailed to load surplus data";
        return of([]);
      })
    )
  }

}
