package com.ies.kentucky.ed.batches;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ies.kentucky.ed.entity.BatchRunEntity;
import com.ies.kentucky.ed.entity.CoTriggersEntity;
import com.ies.kentucky.ed.repository.BatchRunRepository;
import com.ies.kentucky.ed.repository.CoTriggersRepository;

public class CoGenDlyBatch {
	
	@Autowired
	private BatchRunRepository batchRepo;
	
	private CoTriggersRepository coRepo;

	BatchRunEntity batchEntity=new BatchRunEntity();
	
	public void preProcess() {
		
		batchEntity.setStartDate(new Date());
		batchRepo.save(batchEntity);
	}
	
	public List<CoTriggersEntity> start(String trgStatus){
		
		List<CoTriggersEntity> entityList = coRepo.findByTrgStatus(trgStatus);
		
		return entityList;
	}
	
	
	
	public void postProcess() {
		
		batchEntity.setEndDate(new Date());
	}
	
	
	
}
