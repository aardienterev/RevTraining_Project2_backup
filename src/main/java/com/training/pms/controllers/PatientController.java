package com.training.pms.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.pms.models.Patient;
import com.training.pms.services.PatientService;

@RestController
@RequestMapping("patient")
public class PatientController 
{
	@Autowired
	private PatientService pService;
	
	/************************************************************************************************************/
	// Posts
	
	@PostMapping
	public String addPatient(@RequestBody Patient obj)
	{
		return "Adding Patient in PatientController |\nResult ->" + pService.addPatient(obj);
	}
	
	/************************************************************************************************************/
	// Puts
	
	@PutMapping("{patientId}")
	public String updatePatient(@PathVariable("patientId") int id, @RequestBody Patient obj)
	{
		return "Updating Patient id: " + id + " in PatientController | Obj -> " + obj 
				+ " |\nResult -> " + pService.updatePatient(obj);
	}
	
	/************************************************************************************************************/
	// Deletes
	
	@DeleteMapping
	public String deletePatient(@RequestBody Patient obj) 
	{
		return  "Deleting Patient in PatientController | Obj -> " + obj 
				+ " |\nResult -> " + pService.deletePatient(obj);
	}
	
	/************************************************************************************************************/
	// Gets
	
	@GetMapping("{patientId}")
	public Patient getPatientById(@PathVariable("patientId") int id)
	{
		return pService.getPatientById(id);
	}
	@GetMapping("CheckPatientStatus/{patientId}")
	public boolean doesPatientExist(@PathVariable("patientId") int id)
	{
		return pService.doesPatientExist(id);
	}
	@GetMapping("getPatients")
	public ArrayList<Patient> getPatients()
	{
		return pService.getPatients();
	}
	@GetMapping("getPatientsByName/{patientName}")
	public ArrayList<Patient> getPatientsByName(@PathVariable("patientName") String name)
	{
		return pService.getPatientsByName(name);
	}
	@GetMapping("getPatientsByInsurance/{insuranceName}")
	public ArrayList<Patient> getPatientsByInsurance(@PathVariable("insuranceName")String insurName)
	{
		return pService.getPatientsByInsurance(insurName);
	}
}
