package com.ies.kentucky.datacollection.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DC_INCOME_DTLS")
public class IncomeDetailsEntity {

	@Id
	@Column(name="INCOME_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer incomeId;
	@Column(name="CASE_NO")
	private Integer caseNo;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="IS_EMPLOYEE")
	private String empStatus;
	@Column(name="INCOME")
	private String income;
}
