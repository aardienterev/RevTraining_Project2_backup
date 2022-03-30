package com.training.pms.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.pms.models.DoctorInsurance;


public interface DoctorInsuranceRepository  extends CrudRepository<DoctorInsurance, Integer>
{
	
}
