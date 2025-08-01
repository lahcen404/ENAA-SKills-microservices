import { Component , Input} from '@angular/core';
import {Skill} from '../../../core/modules/skill';
import {SkillService} from '../../../core/services/skill/skill';
import {NgForOf} from '@angular/common';
import {Router} from '@angular/router';

@Component({
  selector: 'app-competence-card',
  imports: [
    NgForOf
  ],
  templateUrl: './competence-card.html',
  styleUrl: './competence-card.css'
})
export class CompetenceCard {

  @Input() skill!:Skill;

  constructor(private skillService: SkillService,
              private router: Router){}

  onEdit(skill: Skill){
    this.router.navigate(['edit-skill',skill.id]);
  }
}
