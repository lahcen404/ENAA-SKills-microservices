import { Component } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {Router} from '@angular/router';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-register',
  imports: [
    ReactiveFormsModule,
    NgIf,
    HttpClientModule
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
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      userType: ['',Validators.required]
    });
  }

  onSubmit() {
    if (this.registerForm.valid) {
      const formData = {
        username: this.registerForm.value.username, // ✅ correspond au formGroup
        email: this.registerForm.value.email,
        password: this.registerForm.value.password,
        userType: this.registerForm.value.userType
      };
      this.http.post('http://localhost:8089/auth/addNewUser', formData)
        .subscribe({
          next: () => this.router.navigate(['/login']),
          error: (err) => console.error('Erreur d’inscription', err)
        });
    }
  }

}
