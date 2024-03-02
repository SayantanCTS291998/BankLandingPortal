package com.cognizant.loanapplication.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.loanapplication.dtos.LoanApplicationDTO;
import com.cognizant.loanapplication.serviceimpl.LoanApplicationServiceImpl;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/loanapps")
public class Controller {
	
	@Autowired
	LoanApplicationServiceImpl loanServiceImpl;

	
	
	///api/loanapps/pull/<date>
	@GetMapping("/pull/{date}")
	public ResponseEntity<List<LoanApplicationDTO>> FindApplicationByDate(@PathVariable("date") LocalDate dt){
		return ResponseEntity.ok(this.loanServiceImpl.LoanApplicationFindByDate(dt));
	}
	
	
	
	
	
	
	///api/loanapps/update/<loan_ap_id>
	@GetMapping("/view/{loan_app_id}")
	public ResponseEntity<LoanApplicationDTO> GetById(@PathVariable("loan_app_id") String loan_app_id ){
		return ResponseEntity.ok(this.loanServiceImpl.LoanApplicationFindById(loan_app_id));
	}
	
	
	
	///api/ loanapps/view/<loan_ap_id>
	@PutMapping("/update/{id}")
	public ResponseEntity<LoanApplicationDTO> UpdateById(@Valid @RequestBody LoanApplicationDTO loanApplicationDto, @PathVariable("id") String id){
		return ResponseEntity.ok(this.loanServiceImpl.LoanApplicationUpdateById(loanApplicationDto, id));
	}
}
