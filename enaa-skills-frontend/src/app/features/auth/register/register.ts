import { Component } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-register',
  imports: [
    ReactiveFormsModule,
    NgIf
  ],
  templateUrl: './register.html',
  styleUrl: './register.css'
})
export class Register {
  registerForm: FormGroup;

  constructor(private fb: FormBuilder,
              private http: HttpClient,
              private router: Router
  ) {
    this.registerForm = this.fb.group({
      fullname: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      role: ['',Validators.required]
    });
  }

  onSubmit() {
    if (this.registerForm.valid) {
      const formData = {
        fullName: this.registerForm.value.fullname, // ✅ correspond au formGroup
        email: this.registerForm.value.email,
        password: this.registerForm.value.password,
        role: this.registerForm.value.role
      };
      this.http.post('http://localhost:8081/api/auth/register', formData)
        .subscribe({
          next: () => this.router.navigate(['/login']),
          error: (err) => console.error('Erreur d’inscription', err)
        });
    }
  }

}
