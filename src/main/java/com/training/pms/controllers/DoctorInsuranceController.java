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

import com.training.pms.models.Doctor;
import com.training.pms.models.DoctorInsurance;
import com.training.pms.models.InsuranceProvider;
import com.training.pms.services.DoctorInsuranceService;
import com.training.pms.services.InsuranceProviderService;

@RestController
@CrossOrigin(origins = "http//localhost:4200")
@RequestMapping("DoctorInsurance")
public class DoctorInsuranceController 
{
	@Autowired
	private DoctorInsuranceService dService;
	
	@Autowired
	private InsuranceProviderService ipService;
	
	/************************************************************************************************************/
	// Posts
	@PostMapping
	public ResponseEntity<String> addInsurance(@RequestBody DoctorInsurance obj)
	{
		ResponseEntity<String> res = null;
		
		if(obj == null)
			res = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<String>( "Adding Insurance in PatientInsuranceController |\nResult ->" + dService.addDoctorInsurance(obj) , HttpStatus.OK); 
		
		return res;
	}
	
	/************************************************************************************************************/
	// Puts
	
	
	/************************************************************************************************************/
	// Deletes
	@DeleteMapping
	public ResponseEntity<String> deleteInsurance(@RequestBody DoctorInsurance obj)
	{
		ResponseEntity<String> res = null;

		if(obj == null)
			res = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<String>( "Deleting Insurance in PatientInsuranceController | Obj -> " + obj 
												+ " |\nResult -> " + dService.deleteDoctorInsurance(obj), HttpStatus.OK);
		return res;
	}
	
	/************************************************************************************************************/
	// Gets
	
	
	@GetMapping
	public ResponseEntity<List<DoctorInsurance>> getAllPatientInsurance()
	{
		ResponseEntity<List<DoctorInsurance>> res = null;
		List<DoctorInsurance> tList = dService.getAllDoctorInsurance();
		
		if(tList == null)
			res = new ResponseEntity<List<DoctorInsurance>>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<List<DoctorInsurance>>(tList, HttpStatus.OK);
		
		return res;
	}
	
	@GetMapping("/SearchByDoctor")
	public ResponseEntity<List<DoctorInsurance>> getInsuranceByDoctor(@RequestBody Doctor obj)
	{
		ResponseEntity<List<DoctorInsurance>> res = null;
		List<DoctorInsurance> tList = dService.getInsuranceByDoctor(obj);
		
		if(tList == null)
			res = new ResponseEntity<List<DoctorInsurance>>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<List<DoctorInsurance>>(tList, HttpStatus.OK);
		
		return res;
	}
	
	
	
	
//	@GetMapping("/SearchByProvider")
//	public ResponseEntity<List<Insurance>> getInsuranceByProvider(@RequestBody InsuranceProvider obj)
//	{
//		ResponseEntity<List<Insurance>> res = null;
//		List<Insurance> tList = ipService(obj);
//		
//		if(tList == null)
//			res = new ResponseEntity<List<Insurance>>(HttpStatus.NO_CONTENT);
//		else
//			res = new ResponseEntity<List<Insurance>>(tList, HttpStatus.OK);
//		
//		return res;
//	}
	@GetMapping("/GetAllProviders")
	public ResponseEntity<List<InsuranceProvider>> getAllInsuranceProviders()
	{
		ResponseEntity<List<InsuranceProvider>> res = null;
		List<InsuranceProvider> tList = ipService.getAllProviders();
		
		if(tList == null)
			res = new ResponseEntity<List<InsuranceProvider>>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<List<InsuranceProvider>>(tList, HttpStatus.OK);
			
		return res;
	}
}
