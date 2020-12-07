package com.ies.kentucky.datacollection.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.kentucky.datacollection.entity.CreateCaseEntity;

public interface CreateCaseRepository extends JpaRepository<CreateCaseEntity, Serializable> {

}
