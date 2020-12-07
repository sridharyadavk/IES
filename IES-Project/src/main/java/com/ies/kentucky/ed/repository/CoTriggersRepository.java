package com.ies.kentucky.ed.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.kentucky.ed.entity.CoTriggersEntity;


public interface CoTriggersRepository extends JpaRepository<CoTriggersEntity, Serializable>{

	public List<CoTriggersEntity> findByTrgStatus(String trgStatus);
	
	
}
