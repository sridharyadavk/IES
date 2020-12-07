package com.ies.kentucky.ed.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Data
@Entity
@Table(name="eligibility_details")
public class EligibilityDetEntity {

	@Id
	@Column(name="ed_trace_id")
	private Integer EdTraceId;
	@Column(name="benefit_amt")
	private String benifitAmt;
	@Column(name="case_num")
	private Integer caseNo;
	@Column(name="create_dt")
	private Date createDate;
	@Column(name="denial_reason")
	private String denialReason;
	@Column(name="plan_end_dt")
    private String planEndDate;
	@Column(name="plan_name")
    private String planName;
	@Column(name="plan_start_dt")
    private String planStartDate;
	@Column(name="plan_status")
    private String planStatus;
	@Column(name="update_dt")
	@UpdateTimestamp
    private Date updateDt;
	
}
