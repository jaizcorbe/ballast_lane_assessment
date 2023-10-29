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
  allRegistrations: any[] = [];

  constructor(
    private platformService: StudentsPlatformService,
    private location: Location) {}

  getAllCourses() {
    this.platformService.getAllCourses().subscribe(courses => this.allCourses = courses);
  }

  getAllRegistrations() {
    this.platformService.getAllRegistrations().subscribe(registrations => this.allRegistrations = registrations);
  }

  goBack(): void {
    this.location.back();
  }

  ngOnInit() {
    this.user=this.platformService.getLoggedUser();
    this.getAllCourses();
    this.getAllRegistrations();
  }

  getRegistrationDescription(registration: any) {
    return `course: ${registration?.course?.name} student: ${registration?.student?.email}`
  }
}
