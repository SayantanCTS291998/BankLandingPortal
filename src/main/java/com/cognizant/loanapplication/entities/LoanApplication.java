package com.cognizant.loanapplication.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Table(name="Loan_Application")
public class LoanApplication {
	@Id
	@Column(name ="loan_appid")
	private String loanAppId;
	@Column(name = "cust_id")
	private String custId;
	@Column(name = "loan_amt")
	private long loanAmt;
	@Column(name = "no_of_years")
	private long noOfYears;
	@Column(name = "purpose")
	private String purpose;
	@Column(name = "app_status")
	private String appStatus;
	@Column(name = "type_of_loan")
	private String typeOfLoan;
	@Column(name = "loan_app_date")
	private LocalDate loanAppDate;
	@Column(name = "status")
	private String status;
	
	@OneToMany(mappedBy = "loanApplication", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CreditRisk> creditRisk = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "c_id")
	private CustomerMaster customerMaster;
}
