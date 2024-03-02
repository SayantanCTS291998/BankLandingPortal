package com.cognizant.loanapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.loanapplication.entities.CustomerMaster;

public interface CustomerMasterRepository extends JpaRepository<CustomerMaster, String>{
	
}
