package com.ies.kentucky.ar.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.kentucky.ar.entity.ApplicationRegistrationEntity;

public interface ApplicationRegRepository extends JpaRepository<ApplicationRegistrationEntity, Serializable> {

}
