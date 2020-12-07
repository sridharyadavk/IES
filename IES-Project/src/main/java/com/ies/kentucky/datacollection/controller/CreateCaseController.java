package com.ies.kentucky.datacollection.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ies.kentucky.datacollection.domain.ChildDetails;
import com.ies.kentucky.datacollection.domain.CreateCase;
import com.ies.kentucky.datacollection.domain.PlanSelection;
import com.ies.kentucky.datacollection.service.DataCollectionService;

@Controller
public class CreateCaseController {

	@Autowired
	private DataCollectionService serv;
	
	@ModelAttribute
	public void loadMethod(Model model) {
		Map<Integer, String> plans = serv.getPlansFrmPlanMdl();
		
		model.addAttribute("plans", plans);
	}
	
	@PostMapping("/createCase")
	public String createPlanBtnHandler(@ModelAttribute CreateCase createCas, Model model) {
		
		CreateCase createCase = serv.createCase(createCas);
		
		model.addAttribute("caseDtls", createCase);
		
		return "planSelection";
		
	}
	
	@PostMapping("/planSelection")
	public String planSelectionPageHandl(@ModelAttribute PlanSelection plan, RedirectAttributes redr) {
		
		PlanSelection selection = serv.CreateSelectedPlan(plan);
		
		String planName=selection.getPlanName();
		
		if(planName.equals("122")) {
			redr.addFlashAttribute("snap",selection );
			return "redirect:/snap";
		}else if(planName.equals("123")) {
			ChildDetails childDtls=new ChildDetails();
			childDtls.setCaseNo(selection.getCaseNo());
			childDtls.setFirstName(selection.getFirstName());
			childDtls.setLastName(selection.getLastName());
			
			redr.addFlashAttribute("cCap",childDtls);
			return "redirect:/cCap";
		}else {
			redr.addFlashAttribute("snap",selection);
			return "redirect:/ktworks";
		}
		
		
	}
	@GetMapping("/snap")
	public String snapPlanDtlsPage(Model model) {
	
		
		return "incomeDtls";
	}
	
	@GetMapping("/cCap")
	public String ccapPlanDtlsPage(Model model) {
		
		return "childDetails";
	}
	
	
	
}
