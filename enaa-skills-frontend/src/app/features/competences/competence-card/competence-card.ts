import {Component, EventEmitter, Input, Output} from '@angular/core';
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
  @Output() deleted=new EventEmitter<number>();


  constructor(private skillService: SkillService,
              private router: Router){}

  onEdit(skill: Skill){
    this.router.navigate(['edit-skill',skill.id]);
  }

  onDelete(id:number){
    if (confirm('are you sure you want to delete this skill ??')){
      this.skillService.deleteSkill(id).subscribe(()=>{
        alert("Skill deleted successfully !!");
        this.deleted.emit(id);
      })
    }
  }
}
