package com.ies.kentucky.datacollection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ies.kentucky.datacollection.domain.ChildDetails;
import com.ies.kentucky.datacollection.service.DataCollectionService;

@Controller
public class ChildDetailsController {

	@Autowired
	private DataCollectionService serv;
	
	
	
	@PostMapping("/childDtls")
	public String childDtls(@ModelAttribute ChildDetails child, RedirectAttributes redr) {
		
		ChildDetails childDetails = serv.childDetails(child);
		if(childDetails.getChildId()!=null) {
			redr.addFlashAttribute("succMsg", "Child Details Submitted Success fully");
			redr.addFlashAttribute("child", childDetails);
			ChildDetails childDtls=new ChildDetails();
			childDtls.setCaseNo(childDetails.getCaseNo());
			childDtls.setFirstName(childDetails.getFirstName());
			childDtls.setLastName(childDetails.getLastName());
			
			redr.addFlashAttribute("cCap",childDtls);
		}else {
			redr.addFlashAttribute("failMsg","Child Details Failed to Submit");
			ChildDetails childDtls=new ChildDetails();
			childDtls.setCaseNo(childDetails.getCaseNo());
			childDtls.setFirstName(childDetails.getFirstName());
			childDtls.setLastName(childDetails.getLastName());
		}
		
		return "redirect:/loadEmptyPage";
		
	}
	
	@GetMapping("/loadEmptyPage")
	public String childDtlsRedirection(Model model) {
		
		return "childDetails";
		
	}
}
