package com.training.pms.services;

import java.util.ArrayList;

import com.training.pms.models.Insurance;

public interface InsuranceService
{
	public String addInsurance(Insurance obj);
	public String updateInsurance(Insurance obj);
	public String deleteInsurance(Insurance obj);
	
	public ArrayList<Insurance> getAllInsurance();
	public Insurance	getInsuranceById(int id);
	public Insurance	getInsuranceByName(String name);
}
