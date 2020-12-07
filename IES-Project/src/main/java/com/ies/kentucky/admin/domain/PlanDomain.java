package com.ies.kentucky.admin.domain;


import lombok.Data;

@Data
public class PlanDomain {

	
	private Integer pid;
	private String planName;
	private String planDesc;
	private String startDate;
	private String endDate;
	private String planStatus;
	
}
