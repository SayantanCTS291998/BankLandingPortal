package com.cognizant.loanapplication.entities;


import com.cognizant.loanapplication.utility.EnumBasicCheck;

//import com.cognizant.loanManagement.utility.EnumBasicCheck;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "Credit_Risk")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor


public class CreditRisk {
	@Id
	@Column(name = "cr_id")
	private long crId;
	@Column(name = "loan_app_id")
	private String loanAppId;
	@Column(name="credit_score")
	private int creditScore;
	@Column(name = "emi")
	private int emi;
	@Column(name = "basic_check")
	@Enumerated()
	private EnumBasicCheck basicCheck;
	
	@ManyToOne
	@JoinColumn(name="loan_appid")
	private LoanApplication loanApplication;
	
}
