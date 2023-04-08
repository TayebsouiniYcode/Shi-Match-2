import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageStadiumComponent } from './manage-stadium.component';

describe('ManageStadiumComponent', () => {
  let component: ManageStadiumComponent;
  let fixture: ComponentFixture<ManageStadiumComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManageStadiumComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ManageStadiumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
