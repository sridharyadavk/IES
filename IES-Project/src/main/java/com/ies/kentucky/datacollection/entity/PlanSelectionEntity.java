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
@Table(name = "DC_PLANS")
public class PlanSelectionEntity {

	@Id
	@Column(name="PLAN_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planId;
	@Column(name="CASE_NO")
	private Integer caseNo;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="PLAN_NAME")
	private String planName;
}
