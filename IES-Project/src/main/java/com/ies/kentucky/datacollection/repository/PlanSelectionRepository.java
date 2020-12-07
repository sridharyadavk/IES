package com.ies.kentucky.datacollection.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.kentucky.datacollection.entity.PlanSelectionEntity;

public interface PlanSelectionRepository extends JpaRepository<PlanSelectionEntity, Serializable> {

}
