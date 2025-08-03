import { TestBed } from '@angular/core/testing';

import { Brief } from './brief.service';

describe('Brief', () => {
  let service: Brief;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Brief);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
