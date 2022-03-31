package com.training.pms.controllers;

import java.util.ArrayList;
import java.util.List;

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

import com.training.pms.models.Doctor;
import com.training.pms.models.DoctorInsurance;
import com.training.pms.services.DoctorInsuranceService;
import com.training.pms.services.DoctorService;

@RestController
@CrossOrigin(origins = "http//localhost:4200")
@RequestMapping("/doctors")
public class DoctorController
{
	@Autowired
	private DoctorService rService;
	
	@Autowired
	private DoctorInsuranceService iService;
	
	/************************************************************************************************************/
	// Posts
	
	@PostMapping
	public ResponseEntity<String> addDoctor(@RequestBody Doctor obj)
	{
		ResponseEntity<String> res = null;
		
		if(obj == null)
			res = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<String>( "Adding Doctor in DoctorController |\nResult ->" + rService.addDoctor(obj) , HttpStatus.OK); 
		
		return res;
	}
	
	/************************************************************************************************************/
	// Puts
	
	@PutMapping("{doctorId}")
	public ResponseEntity<String> updateDoctor(@PathVariable("doctorId") int id, @RequestBody Doctor obj)
	{
		ResponseEntity<String> res = null;
		
		if(obj == null)
			res = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<String>("Updating Doctor id: " + id + " in DoctorController | Obj -> " + obj 
					+ " |\nResult -> " + rService.updateDoctor(obj), HttpStatus.OK);
		
		return res;
	}
	
	/************************************************************************************************************/
	// Deletes
	
	@DeleteMapping("{doctorId}")
	public ResponseEntity<String> deleteDoctor(@PathVariable("doctorId") int id,  @RequestBody Doctor obj)
	{
		ResponseEntity<String> res = null;
		
		if(id <= 0)
			res = new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		else
			res = new ResponseEntity<String>( "Deleting Patient in DoctorController | Obj -> " + obj 
					+ " |\nResult -> " + rService.deleteDoctor(obj), HttpStatus.OK);
		
		return res;
	}
	
	/************************************************************************************************************/
	// Gets
	
	@GetMapping("{doctorId}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable("doctorId") int id)
	{
		ResponseEntity<Doctor> res = null;
		
		if(id <= 0)
			res = new ResponseEntity<Doctor>(HttpStatus.FORBIDDEN);
		else
		{
			Doctor obj = rService.getDoctorById(id);
			res = new ResponseEntity<Doctor>(obj, HttpStatus.OK);
		}
		
		return res;
	}
	
	@GetMapping
	public ResponseEntity<List<Doctor>> getAllDoctors()
	{
		ResponseEntity<List<Doctor>> res = null;
		
		List<Doctor> tList = rService.getAllDoctors();
		
		if(tList == null)
			res = new ResponseEntity<List<Doctor>>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<List<Doctor>>(tList, HttpStatus.OK);
		
		return res;
	}

	@GetMapping("/GetDoctorBySpecialty/{specialty}/{provider}")
	public ResponseEntity<List<Doctor>> getDoctorsBySpecialty(@PathVariable("specialty") String spec, @PathVariable("provider") String provider)//Doctor.SpecialtyType specialty)
	{
		ResponseEntity<List<Doctor>> res = null;
		List<Doctor> dList = rService.getDoctoryBySpecialty(spec);
		List<Doctor> result = new ArrayList<Doctor>();

		for(Doctor d : dList)
		{
			List<DoctorInsurance> temp = iService.getInsuranceByDoctor(d);
			
			for(DoctorInsurance i : temp)
			{
				if(i.getProvider().getProviderName().equals(provider))
				{
					result.add(d);
					break;
				}
			}
		}
		
		
		
		if(result == null)
			res = new ResponseEntity<List<Doctor>>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<List<Doctor>>(result, HttpStatus.OK);
			
		return res;
	}
}
