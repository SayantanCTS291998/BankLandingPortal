package com.cognizant.loanapplication.serviceimpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.loanapplication.dtos.EmiClacDTO;
import com.cognizant.loanapplication.dtos.LoanApplicationDTO;
import com.cognizant.loanapplication.dtos.LoanStatusDTO;
import com.cognizant.loanapplication.entities.CreditRisk;
import com.cognizant.loanapplication.entities.CustomerMaster;
import com.cognizant.loanapplication.entities.LoanApplication;
import com.cognizant.loanapplication.repositories.CreditRiskRepository;
import com.cognizant.loanapplication.repositories.CustomerMasterRepository;
import com.cognizant.loanapplication.repositories.LoanApplicationRepository;
import com.cognizant.loanapplication.service.LoanApplicationService;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {
	
	@Autowired
	private LoanApplicationRepository loanApplicationRepo;
	
	@Autowired
	private CustomerMasterRepository customerMasterRepository;
	
	
	@Autowired
	CreditRiskRepository creditRiskRepository;
	@Autowired
	private ModelMapper modelMapper;
	
//	@Autowired
//	private CustomerMaster customerMaster;
	
	///api/loanapps/pull/<date> -GET , I-Date , O-LoanAppDTOs
	@Override
	public List<LoanApplicationDTO> LoanApplicationFindByDate(LocalDate date) {
		List<LoanApplication> loanApplications = this.loanApplicationRepo.findByLoanAppDate(date);
		List<LoanApplicationDTO> loanApplicationDTOs = loanApplications.stream().map(loanapplication -> this.userToDto(loanapplication)).collect(Collectors.toList());
		return loanApplicationDTOs;
	}
	
	
	///api/loanapps/update/<loan_ap_id> - update, I-LoanDto, O- LoanDto
	@Override
	public LoanApplicationDTO LoanApplicationUpdateById(LoanApplicationDTO loanApplicationDto, String loanAppId) {
		// TODO Auto-generated method stub
		LoanApplication loanApplication=loanApplicationRepo.findById(loanAppId).orElse(null);
		loanApplication.setLoanAppId(loanApplicationDto.getLoanAppId());
		loanApplication.setCustId(loanApplicationDto.getCustId());
		loanApplication.setLoanAmt(loanApplicationDto.getLoanAmt());
		loanApplication.setNoOfYears(loanApplicationDto.getNoOfYears());
		loanApplication.setPurpose(loanApplicationDto.getPurpose());
		loanApplication.setAppStatus(loanApplicationDto.getAppStatus());
		loanApplication.setTypeOfLoan(loanApplicationDto.getTypeOfLoan());
		loanApplication.setLoanAppDate(loanApplicationDto.getLoanAppDate());
		loanApplication.setStatus(loanApplicationDto.getStatus());
		return this.userToDto(loanApplication);
	}
	
	
	///api/ loanapps/view/<loan_ap_id> - POST, I - Loan_app_id, O - LoanAppDto
	@Override
	public LoanApplicationDTO LoanApplicationFindById(String loanAppId) {
		LoanApplication loanApplication=loanApplicationRepo.findById(loanAppId).orElse(null);
		return this.userToDto(loanApplication);
	}
	
	
	//api/loanapps/basicCheck - GET ,I -LoanAppId , O- LoanStatusDto
	@Override
	public LoanStatusDTO PerformBasicCheck(LoanApplicationDTO loanApplicationDto) {
		LoanStatusDTO loanStatusDto=new LoanStatusDTO();
		CustomerMaster customerMaster=this.customerMasterRepository.findById(loanApplicationDto.getCustId()).orElse(null);
		CreditRisk creditRisk=creditRiskRepository.findByloanAppId(loanApplicationDto.getLoanAppId());
		LocalDate curDate = LocalDate.now();
		int age=Period.between(customerMaster.getBirthdate(), curDate).getYears();
		if((age+loanApplicationDto.getNoOfYears())<=58 && customerMaster.getMonthlySalary()/2>=creditRisk.getEmi()) {
			loanStatusDto.setBasicCheck("pass");
		}
		else {
			loanStatusDto.setBasicCheck("fail");
		}
		
		return loanStatusDto;
	}
	
	
	///api/loanapps/checkEm - GET , I-LoanDTO , O - EmiClacDTO
	public EmiClacDTO CalculateEmi(LoanApplicationDTO loanApplicationDto) {
		EmiClacDTO emiClacDto=new EmiClacDTO();
		CreditRisk creditRisk=creditRiskRepository.findByloanAppId(loanApplicationDto.getLoanAppId());
		emiClacDto.setEmi(creditRisk.getEmi());
		return emiClacDto;
	}
	
	public LoanStatusDTO FetchCreditScore(LoanApplicationDTO loanApplicationDto) {
		LoanStatusDTO loanStatusDto=new LoanStatusDTO();
		CreditRisk creditRisk=creditRiskRepository.findByloanAppId(loanApplicationDto.getLoanAppId());
		loanStatusDto.setCreditScore(creditRisk.getCreditScore());
		return loanStatusDto;
	}
	
	
	
	//ModelMapper
	public LoanApplication dtoToUser(LoanApplicationDTO loanApplicationDto) {
		LoanApplication loanApplication = this.modelMapper.map(loanApplicationDto, LoanApplication.class);
		return loanApplication;
	}
	
	
	//ModelMapper
	public LoanApplicationDTO userToDto(LoanApplication loanApplication) {
		LoanApplicationDTO loanApplicationDto = this.modelMapper.map(loanApplication, LoanApplicationDTO.class);
		return loanApplicationDto;
	}

}
