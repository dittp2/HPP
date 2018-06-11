import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NotfallComponent } from './notfall.component';

describe('ListuserComponent', () => {
  let component: NotfallComponent;
  let fixture: ComponentFixture<NotfallComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NotfallComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NotfallComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
