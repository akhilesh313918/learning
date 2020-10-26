import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Num2wordComponent } from './num2word.component';

describe('Num2wordComponent', () => {
  let component: Num2wordComponent;
  let fixture: ComponentFixture<Num2wordComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Num2wordComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Num2wordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
