import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { SkillService } from '../../../core/services/skill/skill';
import {Skill} from '../../../core/modules/skill';
import {HttpClientModule} from '@angular/common/http';
import {Router, RouterLink} from '@angular/router';

@Component({
  selector: 'app-competence-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterLink

  ],
  templateUrl: './competence-form.html',
  styleUrls: ['./competence-form.css']
})
export class CompetenceForm implements OnInit {

  public competenceForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private skillService: SkillService,
    private router: Router
  ) {}


  ngOnInit(): void {
    this.competenceForm = this.fb.group({
      name: ['', Validators.required],
      subSkills: this.fb.array([])
    });


    // one subskill form by default
    this.addSubSkill();
  }

  get subSkills(): FormArray {
    return this.competenceForm.get('subSkills') as FormArray;
  }

  // add a new subskill to the array
  newSubSkill(): FormGroup {
    return this.fb.group({
      name: ['', Validators.required],
      description: ['', Validators.required]
    });
  }

  // add a new subskill to the array
  addSubSkill() {
    this.subSkills.push(this.newSubSkill());
  }


  onSubmit() {
    if (this.competenceForm.invalid) {
      console.error("error in form");
      return;
    }

    // get form data
    const skillData: Skill = this.competenceForm.value;

    // send data to backend
    this.skillService.addSkill(skillData).subscribe({
      next: (response) => {
        console.log('Skill created !', response);
        this.competenceForm.reset();
        this.subSkills.clear();
        this.addSubSkill();
        this.router.navigate(['/skills']);
      },
      error: (err) => {
        console.error("error in create  :", err);
      }
    });
  }
}
