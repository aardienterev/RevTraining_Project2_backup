package com.training.pms.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http//localhost:4200")
@RequestMapping("/patient")
public class PatientController 
{
	@Autowired
	private PatientService pService;
	
	/************************************************************************************************************/
	// Posts
	
	@PostMapping
	public ResponseEntity<String> addPatient(@RequestBody Patient obj)
	{
		ResponseEntity<String> res = null;
		
		if(obj == null)
			res = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<String>( "Adding Patient in PatientController |\nResult ->" + pService.addPatient(obj) , HttpStatus.OK); 
		
		return res;
	}
	
	/************************************************************************************************************/
	// Puts
	
	@PutMapping("{patientId}")
	public ResponseEntity<String> updatePatient(@PathVariable("patientId") int id, @RequestBody Patient obj)
	{
		ResponseEntity<String> res = null;
		
		if(id <= 0 || obj == null)
			res = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<String>("Updating Patient id: " + id + " in PatientController | Obj -> " + obj 
												+ " |\nResult -> " + pService.updatePatient(obj), HttpStatus.OK);
		
		return res;
	}
	
	/************************************************************************************************************/
	// Deletes
	
	@DeleteMapping
	public ResponseEntity<String> deletePatient(@RequestBody Patient obj) 
	{
		ResponseEntity<String> res = null;

		if(obj == null)
			res = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<String>( "Deleting Patient in PatientController | Obj -> " + obj 
												+ " |\nResult -> " + pService.deletePatient(obj), HttpStatus.OK);
		
		
		return res;
	}
	
	/************************************************************************************************************/
	// Gets

	@GetMapping("{patientId}")
	public ResponseEntity<Patient> getPatientById(@PathVariable("patientId") int id)
	{
		ResponseEntity<Patient> res = null;

		if(id <= 0)
			res = new ResponseEntity<Patient>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<Patient>(pService.getPatientById(id), HttpStatus.OK);
		
		return res;
	}
	@GetMapping("CheckPatientStatus/{patientId}")
	public ResponseEntity<Boolean> doesPatientExist(@PathVariable("patientId") int id)
	{
		ResponseEntity<Boolean> res = null;
		
		if(id <= 0)
			res = new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<Boolean>( pService.doesPatientExist(id), HttpStatus.OK);
		
		return res;
	}
	@GetMapping
	public ResponseEntity<ArrayList<Patient>> getPatients()
	{
		ResponseEntity<ArrayList<Patient>> res = null;
		
		ArrayList<Patient> tList = pService.getPatients();
		
		if(tList == null)
			res = new ResponseEntity<ArrayList<Patient>>(HttpStatus.NO_CONTENT);
		else if(tList.isEmpty())
			res = new ResponseEntity<ArrayList<Patient>>(HttpStatus.NOT_FOUND);
		else
			res = new ResponseEntity<ArrayList<Patient>>(tList, HttpStatus.OK);
		
		return res;
	}
	@GetMapping("getPatientsByName/{patientName}")
	public ResponseEntity<ArrayList<Patient>> getPatientsByName(@PathVariable("patientName") String name)
	{
		ResponseEntity<ArrayList<Patient>> res = null;

		ArrayList<Patient> tList = pService.getPatientsByName(name);
		
		if(tList == null)
			res = new ResponseEntity<ArrayList<Patient>>(HttpStatus.NO_CONTENT);
		else if(tList.isEmpty())
			res = new ResponseEntity<ArrayList<Patient>>(HttpStatus.NOT_FOUND);
		else
			res = new ResponseEntity<ArrayList<Patient>>(tList, HttpStatus.OK);
		
		return res;
	}
	@GetMapping("getPatientsByInsurance/{insuranceName}")
	public ResponseEntity<ArrayList<Patient>> getPatientsByInsurance(@PathVariable("insuranceName")String insurName)
	{
		ResponseEntity<ArrayList<Patient>> res = null;
		ArrayList<Patient> tList = pService.getPatientsByInsurance(insurName);
		
		if(tList == null)
			res = new ResponseEntity<ArrayList<Patient>>(HttpStatus.NO_CONTENT);
		else if(tList.isEmpty())
			res = new ResponseEntity<ArrayList<Patient>>(HttpStatus.NOT_FOUND);
		else
			res = new ResponseEntity<ArrayList<Patient>>(tList, HttpStatus.OK);
		
		return res;
	}
}
