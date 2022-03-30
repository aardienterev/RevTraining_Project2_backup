package com.training.pms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.pms.models.Doctor;
import com.training.pms.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService
{
	@Autowired
	private DoctorRepository repo;
	private static Logger log = Logger.getLogger(DoctorServiceImpl.class.getName());
	
	@Override
	public String addDoctor(Doctor obj)
	{
		String msg = "";
		
		try
		{
			if(obj != null)
				repo.save(obj);
			
			msg = "Doctor | Id: " + obj.getDoctorId()  + " | was added to the database";
			log.info(msg);
		}
		catch (NullPointerException e)
		{
			msg = "Doctor was null in addDoctor() | Error Msg: " + e.getMessage();
			log.error(msg);
		}
		catch (Exception e)
		{
			msg = "Unhandled exception in addDoctor() | " + e.getMessage();
			log.error(msg);
		}
		
		return msg;
	}
	@Override
	public String updateDoctor(Doctor obj) 
	{
		String msg = "";
		try
		{
			repo.save(obj);
			msg = "Doctor | Id: " + obj.getDoctorId() + " | was updated in the database";
			log.info(msg);
		}
		catch (NullPointerException e)
		{
			msg = "Doctor was null in updateDoctor() | Error Msg: " + e.getMessage();
			log.error(msg);
		}
		catch (Exception e)
		{
			msg = "Unhandled exception in updateDoctor() | " + e.getMessage();
			log.error(msg);
		}
		
		return msg;
	}
	@Override
	public String deleteDoctor(Doctor obj)
	{
		String msg = "";
		
		try
		{
			repo.delete(obj);
			
			msg = "Doctor | Id: " + obj.getDoctorId() +  " | was deleted to the database";
			log.info(msg);
		}
		catch (NullPointerException e)
		{
			msg = "Doctor was null in deleteDoctor() | Error Msg: " + e.getMessage();
			log.error(msg);
		}
		catch (Exception e)
		{
			msg = "Unhandled exception in deleteDoctor() | " + e.getMessage();
			log.error(msg);
		}
		
		return msg;
	}
	@Override
	public Doctor getDoctorById(int id) 
	{
		Optional<Doctor> temp = null;
		Doctor obj = null;
		try
		{
			temp = repo.findById(id);
			if(temp == null)
				throw new NullPointerException("getAllDoctors returned a null list");
			
			obj = temp.get();
			log.info("getAllProviders() called | Result: " + obj);
		}catch(NullPointerException e)
		{
			log.error("NullPointer exception in getAllDoctors() | Error: " + e.getMessage());
		}catch (Exception e)
		{
			log.error("Unhandled exception in getAllDoctors() | Error: " + e.getMessage());
		}
		
		return obj;
	}
	@Override
	public List<Doctor> getAllDoctors()
	{
		List<Doctor> pList = null;
		
		try
		{
			pList = (List<Doctor>) repo.findAll();
			
			if(pList == null)
				throw new NullPointerException("getAllDoctors returned a null list");
			
			log.info("getAllProviders() called | Result: " + pList);
		}catch(NullPointerException e)
		{
			log.error("NullPointer exception in getAllDoctors() | Error: " + e.getMessage());
		}catch (Exception e)
		{
			log.error("Unhandled exception in getAllDoctors() | Error: " + e.getMessage());
		}
		return pList;
	}
	
	@Override
	public List<Doctor> getDoctoryBySpecialty(String spec)//SpecialtyType type) 
	{
		List<Doctor> tList = null;
		List<Doctor> rList = new ArrayList<Doctor>();
		
		try
		{
			tList = (List<Doctor>) repo.findAll();
			
			String[] search = spec.split(":");
			
			for(Doctor obj : tList)
			{
				String[] has = obj.getSpecialty().split(":");
				
				for(int i = 0; i < search.length; i++)
				{
					if(has[i].equals(search[i]))
						rList.add(obj);
						
				}

			}
			
			if(rList == null)
				throw new NullPointerException("getDoctoryBySpecialty returned a null list");
			
			log.info("getDoctoryBySpecialty() called | Result: " + rList);
		}catch(NullPointerException e)
		{
			log.error("NullPointer exception in getDoctoryBySpecialty() | Error: " + e.getMessage());
		}catch (Exception e)
		{
			log.error("Unhandled exception in getDoctoryBySpecialty() | Error: " + e.getMessage());
		}
		return rList;
	}
	
	
}
