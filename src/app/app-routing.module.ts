import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UodateLoanApplicationComponentComponent } from './components/uodate-loan-application-component/uodate-loan-application-component.component';
import { ViewSpecificLoanApplicationsComponentComponent } from './components/view-specific-loan-applications-component/view-specific-loan-applications-component.component';
import { PullNewMonthlyLoanApplicationsComponentComponent } from './components/pull-new-monthly-loan-applications-component/pull-new-monthly-loan-applications-component.component';
import { SanctionLoanAmountComponentComponent } from './components/sanction-loan-amount-component/sanction-loan-amount-component.component';
import { SanctionComponent } from './components/sanction-loan-amount-component/sanction/sanction.component';

const routes: Routes = [
  {path:'getbydate',component:UodateLoanApplicationComponentComponent},
  {path:'pull1/:date',component:ViewSpecificLoanApplicationsComponentComponent},
  {path:'pull/:date',component:PullNewMonthlyLoanApplicationsComponentComponent},
  {path:'view',component:SanctionLoanAmountComponentComponent},
  {path:'update',component:UodateLoanApplicationComponentComponent},
  {path:'getallloanapplication',component:SanctionLoanAmountComponentComponent},
  {path:'getallloanapplication/:id',component:SanctionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
