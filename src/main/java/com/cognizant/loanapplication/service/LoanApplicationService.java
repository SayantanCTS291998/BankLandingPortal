package com.cognizant.loanapplication.service;

import java.time.LocalDate;
import java.util.List;

import com.cognizant.loanapplication.dtos.EmiClacDTO;
import com.cognizant.loanapplication.dtos.LoanApplicationDTO;
import com.cognizant.loanapplication.dtos.LoanStatusDTO;





public interface LoanApplicationService {
//	loanApplication addNewLoanApplication(loanApplicationModel loanApplicationModel);
	
	//api/loanapps/pull/<date> - Get , I- Date , O- LoanAppDTOs
	List<LoanApplicationDTO> LoanApplicationFindByDate(LocalDate date);
	
	
	//api/loanapps/update/<loan_ap_id> - update, I-LoanDto, O- LoanDto
	LoanApplicationDTO LoanApplicationUpdateById(LoanApplicationDTO loanApplicationDto,String loanAppId);
	
	//api/ loanapps/view/<loan_ap_id> - POST, I - Loan_app_id, O - LoanAppDto
	LoanApplicationDTO LoanApplicationFindById(String loanAppId);
	
	//api/loanapps/basicCheck - GET ,I -LoanAppId , O- LoanStatusDto
	LoanStatusDTO PerformBasicCheck(LoanApplicationDTO loanApplicationDto);
	
	///api/loanapps/checkEm - GET , I-LoanDTO , O - EmiClacDTO
	EmiClacDTO CalculateEmi(LoanApplicationDTO loanApplicationDto);
	
	
	//api/loanapps/creditScore - GET, I-LoanAppDTO , O-LOanStatusDTO
	LoanStatusDTO FetchCreditScore(LoanApplicationDTO loanApplicationDto);
	
	//api/loanapps/checkCustomerAcceptanceStatus/<loanAppID> GET, I-LoanAPpID , O-LoanAPpDTO
//	LoanApplicationDTO FetchAcceptance(LoanApplicationDTO loanApplicationDto);
	
	
}
