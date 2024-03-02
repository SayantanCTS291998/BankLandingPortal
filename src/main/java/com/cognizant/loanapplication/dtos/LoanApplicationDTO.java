package com.cognizant.loanapplication.dtos;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class LoanApplicationDTO {
	private String loanAppId;
	private String custId;
	private long loanAmt;
	private long noOfYears;
	private String purpose;
	private String appStatus;
	private String typeOfLoan;
	private LocalDate loanAppDate;
	private String status;
}
