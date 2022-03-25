package com.training.pms.services;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.pms.models.Patient;
import com.training.pms.repository.PatientRepository;


@Service
public class PatientServiceImpl implements PatientService 
{
	@Autowired
	private PatientRepository repo;
	private static Logger log = Logger.getLogger(PatientServiceImpl.class.getName());
	
	@Override
	public String addPatient(Patient obj) 
	{
		try
		{
			repo.save(obj);
			
			String msg = "Patient | Id: " + obj.getPatientId() + " | Username: " + obj.getUsername() + " | was added to the database";
			log.info(msg);
			
			return msg;
		}
		catch (NullPointerException e)
		{
			String msg = "Patient was null | Aborting addPatient() | Error Msg: " + e.getMessage();
			log.error(msg);
			
			return msg;
		}
		catch (Exception e)
		{
			String msg = "Unhandled exception in addPatient() | " + e.getMessage();
			log.error(msg);
			
			return msg;
		}
	}

	@Override
	public String updatePatient(Patient obj) 
	{
		try
		{
			repo.save(obj);
			String msg = "Patient | Id: " + obj.getPatientId() + " | Username: " + obj.getUsername() + " | was added to the database";
			log.info(msg);
			
			return msg;
		}
		catch (NullPointerException e)
		{
			String msg = "Patient was null | Aborting updatePatient() | Error Msg: " + e.getMessage();
			log.error(msg);
			
			return msg;
		}
		catch (Exception e)
		{
			String msg = "Unhandled exception in updatePatient() | " + e.getMessage();
			log.error(msg);
			
			return msg;
		}
	}

	@Override
	public String deletePatient(Patient obj)
	{
		try
		{
			repo.delete(obj);
			
			String msg = "Patient | Id: " + obj.getPatientId() + " | Username: " + obj.getUsername() + " | was deleted to the database";
			log.info(msg);
			
			return msg;
		}
		catch (NullPointerException e)
		{
			String msg = "Patient was null | Aborting deletePatient() | Error Msg: " + e.getMessage();
			log.error(msg);
			
			return msg;
		}
		catch (Exception e)
		{
			String msg = "Unhandled exception in deletePatient() | " + e.getMessage();
			log.error(msg);
			
			return msg;
		}
	}

	@Override
	public Patient getPatientById(int id)
	{
		Patient obj = null;
		try
		{
			Optional<Patient> temp = repo.findById(id); 	// Getting the patient from the db
			
			if(temp.isEmpty())								// If our result is null throw an error
				throw new NullPointerException();
			else								
			{
				obj = temp.get();							// Otherwise, assign our result;
				log.info("Patient | Id: " + obj.getPatientId() + " | Username: " + obj.getUsername() + " | was retrieved by getPatientById() ");
			}
		}
		catch (NullPointerException e)
		{
			log.error("Patient was null in getPatientById() | Search Id: " + id + " | Error: " + e.getMessage());
		}
		catch (Exception e)
		{
			log.error("Unhandled error in getPatientById() | Search Id: " + id + " | Error: " + e.getMessage());
		}
		return obj;
	}

	@Override
	public boolean doesPatientExist(int id) 
	{
		boolean result = repo.existsById(id);
		
		log.info("doesPatientExist() called | Search Id: " + id + " | Result: " + result);
		
		return result;
	}

	@Override
	public ArrayList<Patient> getPatients() 
	{
		ArrayList<Patient> pList = null;
		
		try
		{
			pList = (ArrayList<Patient>) repo.findAll();
			log.info("getPatients() called | Result: " + pList);
		} catch (Exception e)
		{
			log.error("Unhandled exception in getPatients() | Error: " + e.getMessage());
		}
		
		return pList;
	}

	@Override
	public ArrayList<Patient> getPatientsByName(String name) 
	{
		ArrayList<Patient> pList = null;
		
		try
		{
			pList = (ArrayList<Patient>) repo.findAll();
			log.info("getPatients() called | Result: " + pList);
		} catch (Exception e)
		{
			log.error("Unhandled exception in getPatientsByName() | Search name: " + name + " | Error: " + e.getMessage());
		}
		
		return pList;
	}

	@Override
	public ArrayList<Patient> getPatientsByInsurance(String insurName) // Needs impl
	{

		return null;
	}

}
