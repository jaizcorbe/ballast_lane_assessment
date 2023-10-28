import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class StudentsPlatformService {
  private apiUrl = "http://localhost:8080/api/student";

  constructor(private http: HttpClient) { }

  createStudent(studentData: any): Observable<any> {
    return this.http.post(this.apiUrl, studentData)
  }
}
