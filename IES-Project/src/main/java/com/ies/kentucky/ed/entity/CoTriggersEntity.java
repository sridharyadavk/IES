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
@Table(name="co_triggers")
public class CoTriggersEntity {

	@Id
	@Column(name="trg_id")
	private Integer trgId;
	@Column(name="case_num")
	private Integer caseNo;
	@Column(name="create_dt")
	private Date createDate;
	@Column(name="trg_status")
	private String trgStatus;
	@Column(name="update_dt")
	@UpdateTimestamp
	private Date updateDate;
	
	
}
