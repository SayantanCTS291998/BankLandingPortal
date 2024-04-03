import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SanctionLoanAmountComponentComponent } from './components/sanction-loan-amount-component/sanction-loan-amount-component.component';
import { CreditScoreComponentComponent } from './components/credit-score-component/credit-score-component.component';
import { UodateLoanApplicationComponentComponent } from './components/uodate-loan-application-component/uodate-loan-application-component.component';
import { PullNewMonthlyLoanApplicationsComponentComponent } from './components/pull-new-monthly-loan-applications-component/pull-new-monthly-loan-applications-component.component';
import { ViewSpecificLoanApplicationsComponentComponent } from './components/view-specific-loan-applications-component/view-specific-loan-applications-component.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavBarComponent } from './navbar/nav-bar/nav-bar.component';
import {HttpClientModule} from '@angular/common/http'
import { FormsModule } from '@angular/forms';
import { SanctionComponent } from './components/sanction-loan-amount-component/sanction/sanction.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    SanctionLoanAmountComponentComponent,
    CreditScoreComponentComponent,
    UodateLoanApplicationComponentComponent,
    PullNewMonthlyLoanApplicationsComponentComponent,
    ViewSpecificLoanApplicationsComponentComponent,
    NavBarComponent,
    SanctionComponent,
    FooterComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
