import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrationWorklogComponent } from './registration-worklog.component';

describe('RegistrationWorklogComponent', () => {
  let component: RegistrationWorklogComponent;
  let fixture: ComponentFixture<RegistrationWorklogComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegistrationWorklogComponent]
    });
    fixture = TestBed.createComponent(RegistrationWorklogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
