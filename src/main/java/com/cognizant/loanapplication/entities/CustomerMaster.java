package com.cognizant.loanapplication.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Customer_Master")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMaster {
	@Id
	@Column(name = "cust_id")
	private String custId;
	@Column(name = "birth_date")
	private LocalDate birthdate;
	@Column(name = "monthly_salary")
	private int monthlySalary;
	
	@OneToMany(mappedBy = "customerMaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<LoanApplication> loanApplication=new ArrayList<>();
}
