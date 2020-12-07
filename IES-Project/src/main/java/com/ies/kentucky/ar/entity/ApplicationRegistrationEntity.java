package com.ies.kentucky.ar.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "APPLICATION_DTLS")
public class ApplicationRegistrationEntity {

	
	@Id
	@Column(name="APPLICATION_ID")
	@GenericGenerator(name = "AR_ID_GEN", strategy = "com.ies.kentucky.ar.generator.ApplicationIdGenerator")
	@GeneratedValue(generator = "AR_ID_GEN")
	private String applicationId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="DOB")
	private String dob;
	@Column(name="GENDER")
	private String gender;
	@Column(name="SSN")
	private String ssn;
	@Column(name="MOBILE")
	private Long mobile;
	@Column(name="EMAIL")
	private String email;
	@Column(name="STATUS")
	private String status;
	@Column(name="REG_DATE")
	private Date applicationRegDate;
	@Column(name="REG_UPDATE_DATE")
	private Date applicationUpdateDate;
	
}
