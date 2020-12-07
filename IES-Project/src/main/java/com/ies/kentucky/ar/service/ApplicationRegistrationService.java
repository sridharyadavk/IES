package com.ies.kentucky.ar.service;

import java.util.List;

import com.ies.kentucky.ar.domain.ApplicationRegistration;

public interface ApplicationRegistrationService {

	public String appRegistration(ApplicationRegistration ar);
	
	public String isValidSsn(String ssn);
	
	public List<ApplicationRegistration> getAllApplicationsDtls();
	
	public ApplicationRegistration getApplicationById(String appId);
	
	public Object getApplicationBySearch(String appId);
	
	public boolean deactivateApplication(String appId);
	
	public boolean activateApplication(String appId);
	
}
