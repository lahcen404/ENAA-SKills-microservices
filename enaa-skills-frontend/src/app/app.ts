import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {Dashboard} from './features/dashboard/dashboard/dashboard';
import {Navbar} from './shared/components/navbar/navbar';
import {Footer} from './shared/components/footer/footer';



@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Navbar, Footer],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'enaa-skills-frontend';
}
