  import { Component } from '@angular/core';
  import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
  import {HttpClient, HttpClientModule} from '@angular/common/http';
  import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [HttpClientModule, ReactiveFormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
  loginForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private router: Router
  ) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.loginForm.valid) {
      console.log('Formulaire envoyé avec :', this.loginForm.value);
      this.http.post('http://localhost:8089/auth/login', this.loginForm.value)
        .subscribe({
          next: (res: any) => {
            localStorage.setItem('token', res.token);
            this.router.navigate(['/register']);
          },
          error: (err) => {
            console.error('Erreur de connexion', err);
            alert('Email ou mot de passe incorrect');
          }
        });
    }
  }

}
