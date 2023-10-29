import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable, tap } from 'rxjs'
import { Router } from '@angular/router';
import { User } from './user';
import { Course } from './course';

@Injectable({
  providedIn: 'root'
})
export class StudentsPlatformService {
  private apiBaseUrl = "http://localhost:8080/api";
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  private loggedUser: User | undefined;

  constructor(
    private http: HttpClient,
    private router: Router) { }

  createStudent(studentData: any): Observable<any> {
    const url = `${this.apiBaseUrl}/student`
    return this.http.post(url, studentData)
  }

  createCourse(courseData: Course): Observable<Course> {
    const url = `${this.apiBaseUrl}/course?userId=${this.loggedUser?.id}`
    return this.http.post<Course>(url, courseData);
  }

  getAllCourses(): Observable<Course[]> {
    const url = `${this.apiBaseUrl}/course`
    return this.http.get<Course[]>(url);
  }


  login(userEmail: string): Observable<User> {
    const loginRequest = {
      email: userEmail
    }
    const url = `${this.apiBaseUrl}/auth/login`
    return this.http.post<User>(url, loginRequest, this.httpOptions).pipe(
      tap((newUser: User) => this.loggedUser = newUser)
    );
  }

  logout() {
    this.loggedUser = undefined;
  }

  getLoggedUser() {
    return this.loggedUser;
  }
}
