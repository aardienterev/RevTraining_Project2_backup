package com.training.pms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.pms.models.Insurance;
import com.training.pms.models.InsuranceProvider;
import com.training.pms.models.Patient;
import com.training.pms.services.InsuranceService;

@RestController
@CrossOrigin(origins = "http//localhost:4200")
@RequestMapping("PatientInsurance")
public class PatientInsuranceController 
{
	@Autowired
	private InsuranceService iService;
	
	/************************************************************************************************************/
	// Posts
	@PostMapping
	public ResponseEntity<String> addInsurance(@RequestBody Insurance obj)
	{
		ResponseEntity<String> res = null;
		
		if(obj == null)
			res = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<String>( "Adding Insurance in PatientInsuranceController |\nResult ->" + iService.addInsurance(obj) , HttpStatus.OK); 
		
		return res;
	}
	
	/************************************************************************************************************/
	// Puts
	
	
	/************************************************************************************************************/
	// Deletes
	@DeleteMapping
	public ResponseEntity<String> deleteInsurance(@RequestBody Insurance obj)
	{
		ResponseEntity<String> res = null;

		if(obj == null)
			res = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<String>( "Deleting Insurance in PatientInsuranceController | Obj -> " + obj 
												+ " |\nResult -> " + iService.deleteInsurance(obj), HttpStatus.OK);
		return res;
	}
	
	/************************************************************************************************************/
	// Gets
	
	
	@GetMapping
	public ResponseEntity<List<Insurance>> getAllPatientInsurance()
	{
		ResponseEntity<List<Insurance>> res = null;
		List<Insurance> tList = iService.getAllInsurance();
		
		if(tList == null)
			res = new ResponseEntity<List<Insurance>>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<List<Insurance>>(tList, HttpStatus.OK);
		
		return res;
	}
	
	@GetMapping("/SearchByPatient")
	public ResponseEntity<List<Insurance>> getInsuranceByPatient(@RequestBody Patient obj)
	{
		ResponseEntity<List<Insurance>> res = null;
		List<Insurance> tList = iService.getInsuranceByPatient(obj);
		
		if(tList == null)
			res = new ResponseEntity<List<Insurance>>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<List<Insurance>>(tList, HttpStatus.OK);
		
		return res;
	}
	
	@GetMapping("/SearchByProvider")
	public ResponseEntity<List<Insurance>> getInsuranceByProvider(@RequestBody InsuranceProvider obj)
	{
		ResponseEntity<List<Insurance>> res = null;
		List<Insurance> tList = iService.getInsuranceByProvider(obj);
		
		if(tList == null)
			res = new ResponseEntity<List<Insurance>>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<List<Insurance>>(tList, HttpStatus.OK);
		
		return res;
	}
}
