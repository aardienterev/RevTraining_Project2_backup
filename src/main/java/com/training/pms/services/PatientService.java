package com.training.pms.services;

import java.util.ArrayList;

import com.training.pms.models.Patient;

public interface PatientService
{
	public String addPatient(Patient obj);
	public String updatePatient(Patient obj);
	public String deletePatient(Patient obj); // Might not get unused, dunno.
	
	public Patient getPatientById(int id);
	public boolean doesPatientExist(int id);
	
	public ArrayList<Patient> getPatients();
	public ArrayList<Patient> getPatientsByName(String name);
	public ArrayList<Patient> getPatientsByInsurance(String insurName); 
	
	
}
