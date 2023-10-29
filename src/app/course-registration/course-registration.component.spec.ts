import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseRegistrationComponent } from './course-registration.component';

describe('CourseRegistrationComponent', () => {
  let component: CourseRegistrationComponent;
  let fixture: ComponentFixture<CourseRegistrationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CourseRegistrationComponent]
    });
    fixture = TestBed.createComponent(CourseRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
