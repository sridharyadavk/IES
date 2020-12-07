package com.ies.kentucky.datacollection.domain;

import lombok.Data;

@Data
public class CreateCase {

	private Integer caseNo;
	private String applicationId;
	private String firstName;
	private String lastName;
	private String gender;
	private String dob;
	private String ssn;
	private String mobile;
	private String email;
	private String planName;
}
