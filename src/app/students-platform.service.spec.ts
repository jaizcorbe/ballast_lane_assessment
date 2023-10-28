import { TestBed } from '@angular/core/testing';

import { StudentsPlatformService } from './students-platform.service';

describe('StudentsPlatformService', () => {
  let service: StudentsPlatformService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StudentsPlatformService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
