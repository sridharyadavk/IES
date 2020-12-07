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
@Table(name="DC_CHILD_DTLS")
public class ChildDetailsEntity {

	@Id
	@Column(name="CHILD_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer childId;
	@Column(name="CASE_NO")
	private Integer caseNo;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="CHILD_NAME")
	private String childName;
	@Column(name="CHILD_GENDER")
	private String childGender;
	@Column(name="DOB")
	private String dob;
	@Column(name="CHILD_SSN")
	private String childSsn;
	@Column(name="CHILD_STATUS")
	private String childStatus;
}
