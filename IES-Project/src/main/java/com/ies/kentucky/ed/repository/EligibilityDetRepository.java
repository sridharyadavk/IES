package com.ies.kentucky.ed.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.kentucky.ed.entity.EligibilityDetEntity;

public interface EligibilityDetRepository extends JpaRepository<EligibilityDetEntity, Serializable> {

}
