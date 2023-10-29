import { Component } from '@angular/core';
import { StudentsPlatformService } from '../students-platform.service';
import { Location } from '@angular/common';
import { Course } from '../course';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent {
  course = {
    name: '',
    startDate: ''
  }
  errorMessage: string = '';
  constructor(
    private studentPlatformService: StudentsPlatformService,
    private location: Location) {}

    createCourse() {
      this.errorMessage = ''; // Reset error message on each form submission
  
      this.studentPlatformService.createCourse(this.course as Course).subscribe(
        response => {
          // Handle success response
          // For example, show success message, clear the form, etc.
          console.log('Course created successfully', response);
          this.goBack();
        },
        error => {
          if (error.status === 400 || error.status === 422) {
            // Handle validation error response
            this.errorMessage = 'Validation error: Please check the provided information.';
          } else {
            // Handle other error responses
            this.errorMessage = 'An error occurred. Please try again later.';
          }
          console.error('Error creating course', error);
        }
      );
    }

  goBack(): void {
    this.location.back();
  }
}
