package com.ies.kentucky.ed.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="BATCH_RUN_DTLS")
public class BatchRunEntity {

	@Id
	@Column(name="BATCH_RUN_SEQ")
	private Integer batchRunSeq;
	@Column(name="BATCH_NAME")
	private String batchName;
	@Column(name="BATCH_RUN_STATUS")
	private String batchRunStatus;
	@Column(name="END_DATE")
	private Date endDate;
	@Column(name="INSTANCE_NUM")
	private Integer instanceNo;
	@Column(name="START_DATE")
	private Date startDate;
}
