package com.ies.kentucky.datacollection.domain;

import lombok.Data;

@Data
public class IncomeDetails {

	private Integer incomeId;
	private Integer caseNo;
	private String firstName;
	private String lastName;
	private String empStatus;
	private String income;
}
