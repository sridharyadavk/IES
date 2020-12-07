package com.ies.kentucky.ar.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ApplicationRegistration {

	private String applicationId;
	private String firstName;
	private String lastName;
	private String dob;
	private String gender;
	private String ssn;
	private Long mobile;
	private String email;
	private String status;
	private Date applicationRegDate;
	private Date applicationUpdateDate;
	
}
