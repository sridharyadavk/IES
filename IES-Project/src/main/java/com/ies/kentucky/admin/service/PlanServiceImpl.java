package com.ies.kentucky.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ies.kentucky.admin.domain.AccountDomain;
import com.ies.kentucky.admin.domain.PlanDomain;
import com.ies.kentucky.admin.entity.PlanEntity;
import com.ies.kentucky.admin.repository.PlansRepository;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlansRepository repo;
	
	@Override
	public boolean createPlan(PlanDomain plan) {

		PlanEntity entity=new PlanEntity();
		BeanUtils.copyProperties(plan, entity);
		entity.setPlanStatus("Activate");
		PlanEntity planEntity = repo.save(entity);
		
		return (planEntity.getPid()!=0) ? true : false;
	}

	@Override
	public List<PlanDomain> getPlans() {
		
		List<PlanDomain> planslist=new ArrayList<>();
		List<PlanEntity> list = repo.findAll();
		for (PlanEntity planEntity : list) {
			PlanDomain plan=new PlanDomain();
			BeanUtils.copyProperties(planEntity, plan);
			planslist.add(plan);
		}
		
		return planslist;
	}

	@Override
	public PlanDomain getByPlanId(Integer pid) {

		PlanDomain plan=new PlanDomain();
		
		Optional<PlanEntity> findById = repo.findById(pid);
		if(findById.isPresent()) {
			
			PlanEntity planEntity = findById.get();
			BeanUtils.copyProperties(planEntity, plan);
		}
		
		return plan;
	}

	@Override
	public boolean deleteByPlanId(Integer pid) {
		Optional<PlanEntity> optional = repo.findById(pid);
		PlanEntity planEntity=null;
		if(optional.isPresent()) {
			planEntity = optional.get();
			planEntity.setPlanStatus("DeActivate");
			
		}
		PlanEntity entity = repo.save(planEntity);
		if(entity.getPlanStatus().equals("DeActivate")){
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean activeByPlanId(Integer pid) {
		Optional<PlanEntity> optional = repo.findById(pid);
		PlanEntity entity=null;
		if(optional.isPresent()) {
			entity = optional.get();
			entity.setPlanStatus("Activate");
		}
		PlanEntity planEntity = repo.save(entity);
		if(planEntity.getPlanStatus().equals("Activate")) {
			return true;
		}else {
			return false;
		}
	}

}
