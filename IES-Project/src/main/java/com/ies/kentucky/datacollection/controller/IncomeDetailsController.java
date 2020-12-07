package com.ies.kentucky.datacollection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ies.kentucky.datacollection.domain.IncomeDetails;
import com.ies.kentucky.datacollection.service.DataCollectionService;

@Controller
public class IncomeDetailsController {

	@Autowired
	private DataCollectionService serv;
	
	@PostMapping("/incomeDtls")
	public String incomeDtlsBtn(@ModelAttribute IncomeDetails income, Model model) {
		
		boolean b = serv.incomeDetails(income);
		if(b) {
			model.addAttribute("succMsg","Details Submitted Successfully");
			
		}else {
			model.addAttribute("failMsg","Details Submition Failed");
			
		}
		
		return "success";
	}
}
