import { Component } from '@angular/core';
import { Location } from '@angular/common';
import { StudentsPlatformService } from '../students-platform.service';
import { User } from '../user';

@Component({
  selector: 'app-student-courses',
  templateUrl: './student-courses.component.html',
  styleUrls: ['./student-courses.component.css']
})
export class StudentCoursesComponent {
  user: User | undefined

  constructor(
    private platformService: StudentsPlatformService,
    private location: Location) {}

  goBack(): void {
    this.location.back();
  }

  ngOnInit() {
    this.user=this.platformService.getLoggedUser();
  }
}
