package com.ies.kentucky.datacollection.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.kentucky.datacollection.entity.IncomeDetailsEntity;

public interface IncomeDetailsRepository extends JpaRepository<IncomeDetailsEntity, Serializable>{

}
