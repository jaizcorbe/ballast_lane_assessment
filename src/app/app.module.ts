import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { CreateStudentComponent } from './create_student/create_student.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CoursesComponent } from './courses/courses.component';
import { StudentCoursesComponent } from './student-courses/student-courses.component';
import { ItemListComponent } from './item-list/item-list.component';
import { CourseRegistrationComponent } from './course-registration/course-registration.component';
import { RegistrationWorklogComponent } from './registration-worklog/registration-worklog.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CreateStudentComponent,
    DashboardComponent,
    CoursesComponent,
    StudentCoursesComponent,
    ItemListComponent,
    CourseRegistrationComponent,
    RegistrationWorklogComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
