import { Component } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { StudentsPlatformService } from '../students-platform.service';

@Component({
  selector: 'app-worklog-detail',
  templateUrl: './worklog-detail.component.html',
  styleUrls: ['./worklog-detail.component.css']
})
export class WorklogDetailComponent {
  selectedWorklog: any


  constructor(
    private platformService: StudentsPlatformService,
    private route: ActivatedRoute,
    private location: Location
  ) {}

  goBack(): void {
    this.location.back();
  }

  delete() {
    const worklogId = Number(this.route.snapshot.paramMap.get('id'));
    this.platformService.deleteWorklog(worklogId).subscribe(_ => this.goBack())
  }

  ngOnInit() {
    const worklogId = Number(this.route.snapshot.paramMap.get('id'));
    this.platformService.getWorklog(worklogId).subscribe(worklog => this.selectedWorklog = worklog);
  }
}
