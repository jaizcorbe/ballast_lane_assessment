import { Component } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { StudentsPlatformService } from '../students-platform.service';
import { Course } from '../course';
import { User } from '../user';

@Component({
  selector: 'app-course-registration',
  templateUrl: './course-registration.component.html',
  styleUrls: ['./course-registration.component.css']
})
export class CourseRegistrationComponent {

  selectedCourse: Course | undefined;
  loggedUser: User | undefined;

  constructor(
    private platformService: StudentsPlatformService,
    private route: ActivatedRoute,
    private location: Location
  ) {}

  registerInCourse() {
    const request = {
      studentId: this.loggedUser?.id,
      courseId: this.selectedCourse?.id
    }
    this.platformService.registerInCourse(request).subscribe(_ => this.goBack())
  }

  goBack(): void {
    this.location.back();
  }

  ngOnInit() {
    this.loggedUser=this.platformService.getLoggedUser();
    const courseId = Number(this.route.snapshot.paramMap.get('id'));
    this.platformService.getCourse(courseId).subscribe(course => this.selectedCourse = course);
  }
}
