import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoanApplication } from '../Entities/LoanApplication';

@Injectable({
  providedIn: 'root'
})
export class LoanApplicationServiceService {
  private baseURL="http://localhost:8081/api/loanapps"
  constructor(private HttpClient:HttpClient) { }

  getLoanApplicationsbyDate(date:Date):Observable<LoanApplication[]>{
    // console.log(String(date));
    return this.HttpClient.get<LoanApplication[]>(`${this.baseURL}/pull/${date}`)
  }
  getLoanApplicationById(id:string):Observable<LoanApplication>{
    return this.HttpClient.get<LoanApplication>(`${this.baseURL}/view/${id}`)
  }

  updateLoanApplication(id: string, loanApplication: LoanApplication): Observable<Object>{
    console.log(id,loanApplication)
    return this.HttpClient.put(`${this.baseURL}/update/${id}`, loanApplication);
  }
  getAllLoanApplications():Observable<LoanApplication[]>{
    return this.HttpClient.get<LoanApplication[]>(`${this.baseURL}/getall`)
  }
}
