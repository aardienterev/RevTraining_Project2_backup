package com.training.pms.services;

import java.util.List;

import com.training.pms.models.Doctor;
import com.training.pms.models.DoctorInsurance;

public interface DoctorInsuranceService 
{
	public String addDoctorInsurance(DoctorInsurance obj);
	public String updateDoctorInsurance(DoctorInsurance obj);
	public String deleteDoctorInsurance(DoctorInsurance obj);
	
	public List<DoctorInsurance> getInsuranceByDoctor(Doctor obj);
	public List<DoctorInsurance> getAllDoctorInsurance();
}
