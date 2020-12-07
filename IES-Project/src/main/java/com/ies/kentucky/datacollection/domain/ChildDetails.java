package com.ies.kentucky.datacollection.domain;

import lombok.Data;

@Data
public class ChildDetails {

	
	private Integer childId;
	private Integer caseNo;
	private String firstName;
	private String lastName;
	private String childName;
	private String childGender;
	private String dob;
	private String childSsn;
	private String childStatus;
}
