import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestMatchComponent } from './request-match.component';

describe('RequestMatchComponent', () => {
  let component: RequestMatchComponent;
  let fixture: ComponentFixture<RequestMatchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RequestMatchComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RequestMatchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
