package com.ies.kentucky.datacollection.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ies.kentucky.admin.domain.PlanDomain;
import com.ies.kentucky.admin.repository.PlansRepository;
import com.ies.kentucky.admin.service.PlanService;
import com.ies.kentucky.ar.domain.ApplicationRegistration;
import com.ies.kentucky.ar.service.ApplicationRegistrationService;
import com.ies.kentucky.datacollection.domain.ChildDetails;
import com.ies.kentucky.datacollection.domain.CreateCase;
import com.ies.kentucky.datacollection.domain.IncomeDetails;
import com.ies.kentucky.datacollection.domain.PlanSelection;
import com.ies.kentucky.datacollection.entity.ChildDetailsEntity;
import com.ies.kentucky.datacollection.entity.CreateCaseEntity;
import com.ies.kentucky.datacollection.entity.IncomeDetailsEntity;
import com.ies.kentucky.datacollection.entity.PlanSelectionEntity;
import com.ies.kentucky.datacollection.repository.ChildDetailsRepository;
import com.ies.kentucky.datacollection.repository.CreateCaseRepository;
import com.ies.kentucky.datacollection.repository.IncomeDetailsRepository;
import com.ies.kentucky.datacollection.repository.PlanSelectionRepository;

@Service
public class DataCollectionServiceImpl implements DataCollectionService {

	@Autowired
	private CreateCaseRepository caseRepo;
	
	@Autowired
	private PlanSelectionRepository plansRepo;
	
	@Autowired
	private ApplicationRegistrationService appServ;
	
	@Autowired
	private ChildDetailsRepository childRepo;
	
	@Autowired
	private IncomeDetailsRepository incomeRepo;
	
	@Autowired
	private PlanService planServ;
	
	@Override
	public CreateCase createCase(CreateCase datac) {
		CreateCase data=new CreateCase();
		CreateCaseEntity entity=new CreateCaseEntity();
		BeanUtils.copyProperties(datac, entity);
		CreateCaseEntity dataEntity = caseRepo.save(entity);
		
		BeanUtils.copyProperties(dataEntity, data);
		return data;
	}

	@Override
	public CreateCase applicationRegData(String applicationId) {
		CreateCase dc=new CreateCase();
		CreateCaseEntity entity=new CreateCaseEntity();
		ApplicationRegistration appReg = appServ.getApplicationById(applicationId);
		BeanUtils.copyProperties(appReg, entity);
		CreateCaseEntity dentity = caseRepo.save(entity);
		BeanUtils.copyProperties(dentity, dc);
		
		return dc;
	}

	@Override
	public Map<Integer, String> getPlansFrmPlanMdl() {
		Map<Integer, String> maplist=new HashMap<>();
		List<PlanDomain> plans = planServ.getPlans();
		
		for (PlanDomain plan : plans) {
			
			maplist.put(plan.getPid(), plan.getPlanName());
			
		}
		return maplist;
	}

	@Override
	public PlanSelection CreateSelectedPlan(PlanSelection plan) {
		
		PlanSelection planselec=new PlanSelection();
		
		PlanSelectionEntity entity=new PlanSelectionEntity();
		BeanUtils.copyProperties(plan, entity);
		
		PlanSelectionEntity plansEntity = plansRepo.save(entity);
		BeanUtils.copyProperties(plansEntity, planselec);
		
		
		
		return planselec;
	}

	@Override
	public ChildDetails childDetails(ChildDetails child) {
		ChildDetails childDtls=new ChildDetails();
		ChildDetailsEntity entity=new ChildDetailsEntity();
		BeanUtils.copyProperties(child, entity);
		entity.setChildStatus("Activate");
		ChildDetailsEntity entity2 = childRepo.save(entity);
		BeanUtils.copyProperties(entity2, childDtls);
		
		return childDtls;
	}

	@Override
	public boolean incomeDetails(IncomeDetails income) {
		IncomeDetailsEntity entity=new IncomeDetailsEntity();
		BeanUtils.copyProperties(income, entity);
		IncomeDetailsEntity entity2 = incomeRepo.save(entity);
		Integer incomeId = entity2.getIncomeId();
		if(incomeId==null) {
			return false;
		}else {
		return true;
		}
	}
	
	

}
