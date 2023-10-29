import { Component } from '@angular/core';
import { User } from '../user';
import { StudentsPlatformService } from '../students-platform.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  constructor(
    private platformService: StudentsPlatformService,
    private location: Location) {}
  user: User | undefined

  ngOnInit() {
    this.user=this.platformService.getLoggedUser();
  }

  logout() {
    this.user = undefined;
    this.platformService.logout;
    this.location.back();
  }

}
