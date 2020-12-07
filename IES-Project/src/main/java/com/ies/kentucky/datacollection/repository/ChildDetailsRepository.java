package com.ies.kentucky.datacollection.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.kentucky.datacollection.entity.ChildDetailsEntity;

public interface ChildDetailsRepository extends JpaRepository<ChildDetailsEntity, Serializable> {

}
