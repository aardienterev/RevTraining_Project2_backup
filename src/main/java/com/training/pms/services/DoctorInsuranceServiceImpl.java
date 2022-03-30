package com.training.pms.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.pms.models.Doctor;
import com.training.pms.models.DoctorInsurance;
import com.training.pms.repository.DoctorInsuranceRepository;

@Service
public class DoctorInsuranceServiceImpl implements DoctorInsuranceService 
{
	@Autowired
	DoctorInsuranceRepository repo;
	private static Logger log = Logger.getLogger(DoctorInsuranceServiceImpl.class.getName());
	@Override
	public String addDoctorInsurance(DoctorInsurance obj)
	{
		String msg = "";
		
		try
		{
			if(obj != null)
				repo.save(obj);
			
			msg = "DoctorInsurance | Id: " + obj.getInsuranceId()  + " | was added to the database";
			log.info(msg);
		}
		catch (NullPointerException e)
		{
			msg = "DoctorInsurance was null in addDoctorInsurance() | Error Msg: " + e.getMessage();
			log.error(msg);
		}
		catch (Exception e)
		{
			msg = "Unhandled exception in addDoctorInsurance() | " + e.getMessage();
			log.error(msg);
		}
		
		return msg;
	}
	@Override
	public String updateDoctorInsurance(DoctorInsurance obj) 
	{
		String msg = "";
		try
		{
			repo.save(obj);
			msg = "DoctorInsurance | Id: " + obj.getInsuranceId() + " | was updated in the database";
			log.info(msg);
		}
		catch (NullPointerException e)
		{
			msg = "DoctorInsurance was null in updateDoctorInsurance() | Error Msg: " + e.getMessage();
			log.error(msg);
		}
		catch (Exception e)
		{
			msg = "Unhandled exception in updateDoctorInsurance() | " + e.getMessage();
			log.error(msg);
		}
		
		return msg;
	}
	@Override
	public String deleteDoctorInsurance(DoctorInsurance obj) 
	{
		String msg = "";
		
		try
		{
			repo.delete(obj);
			
			msg = "DoctorInsurance | Id: " + obj.getInsuranceId() +  " | was deleted to the database";
			log.info(msg);
		}
		catch (NullPointerException e)
		{
			msg = "DoctorInsurance was null in deleteDoctorInsurance() | Error Msg: " + e.getMessage();
			log.error(msg);
		}
		catch (Exception e)
		{
			msg = "Unhandled exception in deleteDoctorInsurance() | " + e.getMessage();
			log.error(msg);
		}
		
		return msg;
	}
	@Override
	public List<DoctorInsurance> getInsuranceByDoctor(Doctor obj) 
	{
		List<DoctorInsurance> rList = null;
		
		try
		{
			List<DoctorInsurance> tList = (List<DoctorInsurance>)repo.findAll();
			rList = new ArrayList<DoctorInsurance>();
			
			for(DoctorInsurance temp : tList)
			{
				if(temp.getDoctor().getDoctorId() == obj.getDoctorId())
					rList.add(temp);
			}	
		}
		catch(NullPointerException e)
		{
			log.error("Object was null in getInsuranceByDoctor() | Error: " + e.getMessage());
		}
		catch(Exception e)
		{
			log.error("Unhandled error in getInsuranceByDoctor() | Search Obj: " + obj + " | Error: " + e.getMessage());
		}
		
		return rList;
	}
	@Override
	public List<DoctorInsurance> getAllDoctorInsurance() 
	{
		List<DoctorInsurance> pList = null;
		
		try
		{
			pList = (List<DoctorInsurance>) repo.findAll();
			
			if(pList == null)
				throw new NullPointerException("DoctorInsuranceRepository returned a null list");
			
			log.info("getAllDoctorInsurance() called | Result: " + pList);
		}catch(NullPointerException e)
		{
			log.error("NullPointer exception in getAllDoctorInsurance() | Error: " + e.getMessage());
		}catch (Exception e)
		{
			log.error("Unhandled exception in getAllDoctorInsurance() | Error: " + e.getMessage());
		}
		
		return pList;
	}
	
	

}
