import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WorklogDetailComponent } from './worklog-detail.component';

describe('WorklogDetailComponent', () => {
  let component: WorklogDetailComponent;
  let fixture: ComponentFixture<WorklogDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WorklogDetailComponent]
    });
    fixture = TestBed.createComponent(WorklogDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
