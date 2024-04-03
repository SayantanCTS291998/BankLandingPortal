import { Component, OnInit } from '@angular/core';
import { LoanApplication } from 'src/app/Entities/LoanApplication';
import { LoanApplicationServiceService } from 'src/app/service/loan-application-service.service';

@Component({
  selector: 'app-uodate-loan-application-component',
  templateUrl: './uodate-loan-application-component.component.html',
  styleUrls: ['./uodate-loan-application-component.component.css']
})
export class UodateLoanApplicationComponentComponent implements OnInit {
  fetchData!:string
  count:number=0
  loanApplication:LoanApplication=new LoanApplication()


  constructor(private loanApplicationService:LoanApplicationServiceService) { }

  ngOnInit(): void {

  }

  fetch(){
    this.loanApplicationService.getLoanApplicationById(this.fetchData).subscribe(data=>this.loanApplication=data)
    this.count=0
  }

  onSubmit(){
    this.loanApplicationService.updateLoanApplication(this.fetchData,this.loanApplication).subscribe(data=>{
      console.log(data)
    })
    this.loanApplication=new LoanApplication()
    this.count=1
  }

}
