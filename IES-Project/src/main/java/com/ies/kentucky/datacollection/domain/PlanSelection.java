package com.ies.kentucky.datacollection.domain;



import com.ies.kentucky.ar.domain.ApplicationRegistration;

import lombok.Data;
@Data
public class PlanSelection {

	private Integer planId;
	
	  private Integer caseNo; 
	  private String firstName; 
	  private String lastName;
	  private ApplicationRegistration appreg;
	  private String planName;
	  private String empStatus;
	  private String income;
}
