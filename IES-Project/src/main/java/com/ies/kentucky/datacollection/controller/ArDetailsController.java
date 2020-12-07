package com.ies.kentucky.datacollection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ies.kentucky.ar.domain.ApplicationRegistration;
import com.ies.kentucky.datacollection.domain.CreateCase;
import com.ies.kentucky.datacollection.service.DataCollectionService;

@Controller
public class ArDetailsController {

	@Autowired
	private DataCollectionService serv;
	
	@GetMapping("/loadPage")
	public String loadSearchPage(Model model) {
		ApplicationRegistration app=new ApplicationRegistration();
		model.addAttribute("application", app);
		return "dcHomePage";
	}
	
	@GetMapping("/search")
	public String searBtnHandlerDcModule(@RequestParam("applicationId") String applicationId,Model model) {
		CreateCase applicationRegData = serv.applicationRegData(applicationId);
		model.addAttribute("application", applicationRegData);
		
		return "dcHomePage";
	}
}
