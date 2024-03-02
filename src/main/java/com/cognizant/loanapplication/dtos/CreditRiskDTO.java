package com.cognizant.loanapplication.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CreditRiskDTO {
	private long crId;
	private String loanAppId;
	@Max(200)
	@Min(700)
	private int creditScore;
	private int emi;
	@Positive
	private String basicCheck;
	
}
