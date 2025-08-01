import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {NgForOf} from "@angular/common";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {SkillService} from '../../../core/services/skill/skill';
import {Skill} from '../../../core/modules/skill';

@Component({
  selector: 'app-update-competence',
    imports: [
        FormsModule,
        NgForOf,
        ReactiveFormsModule,
        RouterLink
    ],
  templateUrl: './update-competence.html',
  styleUrl: './update-competence.css'
})
export class UpdateCompetence implements OnInit{

  skillForm:FormGroup;
  isEditMode=false;
  skillId!:number;

  constructor(
    private fb:FormBuilder,
    private skillService:SkillService,
    private router:Router,
    private route: ActivatedRoute,
  ){
    this.skillForm=this.fb.group({
      name:['',Validators.required],
      subSkills: this.fb.array([]) // start vide
    })

  }

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id');
    if (idParam) {
      this.isEditMode = true;
      this.skillId = +idParam;
      this.loadSkill(this.skillId)
    }
  }

  loadSkill(skillId: number): void {
    this.skillService.getSkillById(skillId).subscribe(skill => {
      this.skillForm.patchValue({
        name: skill.name,
      });

      this.subSkills.clear();

      // boucle subskills
      skill.subSkills.forEach(subSkill => {
        this.subSkills.push(
          this.fb.group({
            id: [subSkill.id],
            name: [subSkill.name, Validators.required],
            description: [subSkill.description, Validators.required],
          })
        );
      });
    });
  }

  get subSkills(): FormArray {
    return this.skillForm.get('subSkills') as FormArray;
  }


  onSubmit(){
     if (this.skillForm.invalid){
       console.log("form invalid error");
       return;
     }

     const formData=this.skillForm.value;

     this.skillService.updateSkill(this.skillId,formData).subscribe(() => {
       console.log("skill updated success!!!!");
       this.router.navigate(['/skills']);
     })
  }

}
