import { Component } from '@angular/core';
import { StudentsPlatformService } from '../students-platform.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-create_student',
  templateUrl: './create_student.component.html',
  styleUrls: ['./create_student.component.css']
})
export class CreateStudentComponent {
  student = {
    firstName: '',
    lastName: '',
    dateOfBirth: '',
    address: '',
    telephoneNumber: '',
    email: ''
  };
  errorMessage: string = '';
  constructor(
    private studentPlatformService: StudentsPlatformService,
    private location: Location) {}

  createStudent() {
    this.errorMessage = ''; // Reset error message on each form submission

    this.studentPlatformService.createStudent(this.student).subscribe(
      response => {
        // Handle success response
        // For example, show success message, clear the form, etc.
        console.log('Student created successfully', response);
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
        console.error('Error creating student', error);
      }
    );
  }

  goBack(): void {
    this.location.back();
  }
}
