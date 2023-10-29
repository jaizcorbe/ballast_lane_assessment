import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { CreateStudentComponent } from './create_student/create_student.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CoursesComponent } from './courses/courses.component';
import { StudentCoursesComponent } from './student-courses/student-courses.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'create_user', component: CreateStudentComponent },
  { path: 'dashboard', component: DashboardComponent},
  { path: 'courses', component: CoursesComponent},
  { path: 'student_courses', component: StudentCoursesComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
