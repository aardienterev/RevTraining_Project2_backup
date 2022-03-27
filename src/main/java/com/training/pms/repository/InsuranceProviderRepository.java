package com.training.pms.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.pms.models.InsuranceProvider;

public interface InsuranceProviderRepository extends CrudRepository<InsuranceProvider, Integer>
{
	
}
