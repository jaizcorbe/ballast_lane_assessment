import { Component } from '@angular/core';
import { Location } from '@angular/common';
import { StudentsPlatformService } from '../students-platform.service';
import { User } from '../user';
import { Course } from '../course';

@Component({
  selector: 'app-student-courses',
  templateUrl: './student-courses.component.html',
  styleUrls: ['./student-courses.component.css']
})
export class StudentCoursesComponent {
  user: User | undefined

  allCourses: Course[] = [];

  constructor(
    private platformService: StudentsPlatformService,
    private location: Location) {}

  getAllCourses() {
    this.platformService.getAllCourses().subscribe(courses => this.allCourses = courses);
  }

  goBack(): void {
    this.location.back();
  }

  ngOnInit() {
    this.user=this.platformService.getLoggedUser();
    this.getAllCourses();
  }
}
