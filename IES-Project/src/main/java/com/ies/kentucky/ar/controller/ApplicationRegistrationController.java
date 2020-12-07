package com.ies.kentucky.ar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ies.kentucky.ar.domain.ApplicationRegistration;
import com.ies.kentucky.ar.service.ApplicationRegistrationService;

@Controller
public class ApplicationRegistrationController {

	@Autowired
	private ApplicationRegistrationService serv;
	
	@GetMapping("/reg")
	public String loadApplicationRegPage(Model model) {
		
		
		  ApplicationRegistration regApplic=new ApplicationRegistration();
		  model.addAttribute("appReg", regApplic);
		 
		return "applicationReg";
	}
	@GetMapping("/validateSsn")
	public @ResponseBody String registerBtnHandler(@RequestParam("ssn") String ssn) {
		String response="";
		String validSsn = serv.isValidSsn(ssn);
		if(validSsn.equals("VALID")) {
			response="VALID";
		}else {
			response="INVALID";
		}
		return response;
	}
	@PostMapping("/appRegistration")
	public String createAppliHandler(@ModelAttribute ApplicationRegistration app, RedirectAttributes redr) {
		
	String registrationId = serv.appRegistration(app);
	if(app.getApplicationId()!=null) {
		redr.addFlashAttribute("updateMsg","Application updated Successfully of Application Id :"+app.getApplicationId());
	}else {
		
	redr.addFlashAttribute("apId", "Application Registered Successfully Application Id="+registrationId);
	}
	return "redirect:/reg";
	}
	
	@GetMapping("/viewApplications")
	public String viewApplicationsBtnHandler(Model model) {
		
		List<ApplicationRegistration> applications = serv.getAllApplicationsDtls();
		model.addAttribute("appList", applications);
		return "applications";
	}
	
	@GetMapping("/editApplication")
	public String editBtnHandler(@RequestParam("applicationId") String applicationId, Model model) {
		ApplicationRegistration applicationRegistration = serv.getApplicationById(applicationId);
		model.addAttribute("appReg", applicationRegistration);
		
		return "applicationReg";
	}
	
	@GetMapping("/deactivateApplication")
	public String deativateBtnHandler(@RequestParam("applicationId") String applicationId, RedirectAttributes redr) {
		boolean appStatus = serv.deactivateApplication(applicationId);
		if(appStatus) {
			redr.addFlashAttribute("succMsg", "Account Successfully DeActivated");
		}else {
		redr.addFlashAttribute("failMsg", "Account Deativation Failed");
		}
		return "redirect:/viewApplications";
	}
	
	@GetMapping("/activateApplication")
	public String activateBtnHandler(@RequestParam("applicationId") String applicationId, RedirectAttributes redr) {
		boolean appStatus = serv.activateApplication(applicationId);
		if(appStatus) {
			redr.addFlashAttribute("succMsg", "Account Activated Successfully");
		}else {
			redr.addFlashAttribute("failMsg", "Account Activation Failed");
		}
		return "redirect:/viewApplications";
	}
	
	
}
