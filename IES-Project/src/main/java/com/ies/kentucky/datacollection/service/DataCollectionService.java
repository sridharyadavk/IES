package com.ies.kentucky.datacollection.service;

import java.util.Map;

import com.ies.kentucky.datacollection.domain.ChildDetails;
import com.ies.kentucky.datacollection.domain.CreateCase;
import com.ies.kentucky.datacollection.domain.IncomeDetails;
import com.ies.kentucky.datacollection.domain.PlanSelection;

public interface DataCollectionService {

	public CreateCase createCase(CreateCase datac);
	
	public CreateCase applicationRegData(String applicationId);
	
	public Map<Integer, String> getPlansFrmPlanMdl();
	
	public PlanSelection CreateSelectedPlan(PlanSelection plan);
	
	public ChildDetails childDetails(ChildDetails child);
	
	public boolean incomeDetails(IncomeDetails income);
	
}
