import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { StudentsPlatformService } from '../students-platform.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {
  email: string = '';
  constructor(
    private router: Router,
    private platformService: StudentsPlatformService) {}

  login(): void {
    this.email = this.email.trim();
    if(!this.email) {return;}
    this.platformService.login(this.email).subscribe(() => this.router.navigate(['/dashboard']));
  }
}
