package com.training.pms.services;

import java.util.ArrayList;
import java.util.List;

import com.training.pms.models.Insurance;
import com.training.pms.models.InsuranceProvider;
import com.training.pms.models.Patient;

public interface InsuranceService
{
	public String addInsurance(Insurance obj);
	public String updateInsurance(Insurance obj);
	public String deleteInsurance(Insurance obj);
	
	public ArrayList<Insurance> getAllInsurance();
	public Insurance	getInsuranceById(int id);
	public List<Insurance> 	getInsuranceByPatient(Patient obj);
	public List<Insurance> 	getInsuranceByProvider(InsuranceProvider obj);
}
