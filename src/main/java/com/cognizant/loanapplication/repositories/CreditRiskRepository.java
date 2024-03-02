package com.cognizant.loanapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.loanapplication.entities.CreditRisk;

public interface CreditRiskRepository extends JpaRepository<CreditRisk, Long> {
	CreditRisk findByloanAppId(String loanAppId);
}
