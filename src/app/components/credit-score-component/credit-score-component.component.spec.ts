import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreditScoreComponentComponent } from './credit-score-component.component';

describe('CreditScoreComponentComponent', () => {
  let component: CreditScoreComponentComponent;
  let fixture: ComponentFixture<CreditScoreComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreditScoreComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreditScoreComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
