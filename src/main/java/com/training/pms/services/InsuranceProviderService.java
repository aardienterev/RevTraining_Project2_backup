package com.training.pms.services;

import java.util.List;

import com.training.pms.models.InsuranceProvider;

public interface InsuranceProviderService 
{
	public String addInsuranceProvider(InsuranceProvider obj);
	public String updateInsuranceProvider(InsuranceProvider obj);
	public String deleteInsuranceProvider(InsuranceProvider obj);
	
	public List<InsuranceProvider> getAllProviders();
}
