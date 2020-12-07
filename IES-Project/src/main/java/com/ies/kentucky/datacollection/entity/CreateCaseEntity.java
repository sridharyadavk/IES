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
@Table(name="DC_CASES")
public class CreateCaseEntity {

	@Id
	@Column(name="CASE_NO")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer caseNo;
	@Column(name="APPLICATION_ID")
	private String applicationId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="GENDER")
	private String gender;
	@Column(name="DOB")
	private String dob;
	@Column(name="SSN")
	private String ssn;
	@Column(name="MOBILE")
	private String mobile;
	@Column(name="EMAIL")
	private String email;
}
