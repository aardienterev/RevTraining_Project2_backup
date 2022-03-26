package com.training.pms.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.pms.models.Appointment;
import com.training.pms.services.AppointmentService;

@RestController
@RequestMapping("appointment")
public class AppointmentController 
{
	@Autowired
	private AppointmentService aService;
	
	/************************************************************************************************************/
	// Posts
	
	@PostMapping
	public ResponseEntity<String> addAppointment(@RequestBody Appointment obj )
	{
		ResponseEntity<String> res = null;
		
		if(obj == null)
			res = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<String>( "Adding Appointment in AppointmentController |\nResult ->" + aService.addAppointment(obj) , HttpStatus.OK); 
		
		return res;
	}
	
	/************************************************************************************************************/
	// Puts	
	
	@PutMapping("{appointmentId}")
	public ResponseEntity<String> updateAppointment(@PathVariable("appointmentId") int id, @RequestBody Appointment obj)
	{
		ResponseEntity<String> res = null;
		
		if(id <= 0 || obj == null)
			res = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<String>("Updating Patient id: " + id + " in PatientController | Obj -> " + obj 
												+ " |\nResult -> " + aService.updateAppointment(obj), HttpStatus.OK);
		
		return res;
	}
	
	/************************************************************************************************************/
	// Deletes
	
	@DeleteMapping
	public ResponseEntity<String> deleteAppointment(@RequestBody Appointment obj) 
	{
		ResponseEntity<String> res = null;

		if(obj == null)
			res = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<String>( "Deleting Patient in PatientController | Obj -> " + obj 
												+ " |\nResult -> " + aService.deleteAppointment(obj), HttpStatus.OK);
		
		
		return res;
	}
	/************************************************************************************************************/
	// Gets
	
	@GetMapping("{appointmentId}")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable("appointmentId") int id)
	{
		ResponseEntity<Appointment> res = null;

		if(id <= 0)
			res = new ResponseEntity<Appointment>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<Appointment>(aService.getAppointmentById(id), HttpStatus.OK);
		
		return res;
	}
	
	@GetMapping
	public ResponseEntity<List<Appointment>> getAppointments()
	{
		ResponseEntity<List<Appointment>> res = null;
		
		List<Appointment> tList = aService.getAppointments();
		
		if(tList == null)
			res = new ResponseEntity<List<Appointment>>(HttpStatus.NO_CONTENT);
		else if(tList.isEmpty())
			res = new ResponseEntity<List<Appointment>>(HttpStatus.NOT_FOUND);
		else
			res = new ResponseEntity<List<Appointment>>(tList, HttpStatus.OK);
		
		return res;
	}
}
