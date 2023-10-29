import { Component } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { StudentsPlatformService } from '../students-platform.service';
import { User } from '../user';

@Component({
  selector: 'app-registration-worklog',
  templateUrl: './registration-worklog.component.html',
  styleUrls: ['./registration-worklog.component.css']
})
export class RegistrationWorklogComponent {

  selectedRegistration: any | undefined;
  loggedUser: any | undefined;

  workLog = {
    taskCategory:'',
    taskDate:'',
    taskMinutes:0,
    taskDescription:'',
    studentId:0,
    registrationId:0
  }

  allWorkLogs: any[] = []

  constructor(
    private platformService: StudentsPlatformService,
    private route: ActivatedRoute,
    private location: Location
  ) {}

  goBack(): void {
    this.location.back();
  }

  registerWorkLog(): void {
    this.workLog.registrationId=this.selectedRegistration.id
    this.workLog.studentId=this.loggedUser.id;
    this.platformService.registerWorkLog(this.workLog).subscribe(_ => this.getAllWorkLogs());
  }

  getAllWorkLogs(): void {
    this.platformService.getAllWorkLogs().subscribe(worklogs => this.allWorkLogs=worklogs);
  }

  getWorkLogDescription(itemWorklog: any) {
    return `course: ${itemWorklog?.courseRegistration?.course?.name} 
    student: ${itemWorklog?.courseRegistration?.student?.name} 
    category: ${itemWorklog?.taskCategory} date: ${itemWorklog?.taskDate} 
    time: ${itemWorklog?.taskMinutes}`  
  }

  ngOnInit() {
    this.loggedUser=this.platformService.getLoggedUser();
    const registrationId = Number(this.route.snapshot.paramMap.get('id'));
    this.platformService.getRegistration(registrationId).subscribe(course => this.selectedRegistration = course);
    this.getAllWorkLogs();
  }

}
