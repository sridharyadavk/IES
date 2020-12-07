package com.ies.kentucky.ar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ies.kentucky.ar.binding.SSNDetails;
import com.ies.kentucky.ar.domain.ApplicationRegistration;
import com.ies.kentucky.ar.entity.ApplicationRegistrationEntity;
import com.ies.kentucky.ar.exceptions.NoSSNFoundException;
import com.ies.kentucky.ar.repository.ApplicationRegRepository;

@Service
public class ApplicationRegistrationServiceImpl implements ApplicationRegistrationService {

	@Autowired
	private ApplicationRegRepository repo;
	
	@Override
	public String appRegistration(ApplicationRegistration ar) {

		ApplicationRegistrationEntity entity=new ApplicationRegistrationEntity();
		BeanUtils.copyProperties(ar, entity);
		entity.setStatus("Active");
		ApplicationRegistrationEntity appRegEntity = repo.save(entity);
		return appRegEntity.getApplicationId();
		}

	@Override
	public String isValidSsn(String ssnNo) {
		String endpointUrl = "http://localhost:9595/verify/"+ssnNo;
		ResponseEntity<SSNDetails> forEntity;
		int statusCodeValue;
		RestTemplate rt = new RestTemplate();
		String resp=null;
		try {
		forEntity = rt.getForEntity(endpointUrl, SSNDetails.class);

		statusCodeValue = forEntity.getStatusCodeValue();
		SSNDetails body = forEntity.getBody();
		String stateName = body.getStateName();
		
		if (stateName.equals("Kentucky")) {
			
			
			resp="VALID";
		} else{
			resp="INVALID";
		}
		}catch(Exception e) {
			resp="INVALID";
		}
		
		return resp;
	}

	@Override
	public List<ApplicationRegistration> getAllApplicationsDtls() {
		List<ApplicationRegistration> applList=new ArrayList<>();
		List<ApplicationRegistrationEntity> entityList = repo.findAll();
		for (ApplicationRegistrationEntity entity : entityList) {
			ApplicationRegistration appreg=new ApplicationRegistration();
			BeanUtils.copyProperties(entity, appreg);
			applList.add(appreg);
		}
		return applList;
	}

	@Override
	public ApplicationRegistration getApplicationById(String appId) {
		ApplicationRegistration application=new ApplicationRegistration();
		Optional<ApplicationRegistrationEntity> optional = repo.findById(appId);
		if(optional.isPresent()) {
			ApplicationRegistrationEntity entity = optional.get();
			BeanUtils.copyProperties(entity, application);
		}else {
			
		}
		return application;
	}

	@Override
	public boolean deactivateApplication(String appId) {
		Optional<ApplicationRegistrationEntity> optional = repo.findById(appId);
		if(optional.isPresent()) {
			ApplicationRegistrationEntity entity = optional.get();
			entity.setStatus("DeActive");
			ApplicationRegistrationEntity entity2 = repo.save(entity);
			return entity2.getStatus().equals("DeActive");
		}else {
		return false;
		}
	}

	@Override
	public boolean activateApplication(String appId) {
		Optional<ApplicationRegistrationEntity> optional = repo.findById(appId);
		if(optional.isPresent()) {
			ApplicationRegistrationEntity entity = optional.get();
			entity.setStatus("Active");
			ApplicationRegistrationEntity entity2 = repo.save(entity);
			return entity2.getStatus().equals("Active");
		}else {
		return false;
		}
	}

	@Override
	public Object getApplicationBySearch(String appId) {
		Object resp=null;
		Optional<ApplicationRegistrationEntity> optional = repo.findById(appId);
		if(optional.isPresent()) {
			ApplicationRegistrationEntity entity = optional.get();
			resp=entity;
		}else {
			resp="INVALID";
		}
		return resp;
	}

}
