package com.training.pms.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.pms.models.Appointment;
import com.training.pms.models.Doctor;

import com.training.pms.models.Patient;
import com.training.pms.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService 
{
	@Autowired
	private AppointmentRepository repo;
	private static Logger log = Logger.getLogger(AppointmentServiceImpl.class.getName());
	
	@Override
	public String addAppointment(Appointment obj) 
	{
		String msg = "";
		
		try
		{
			if(obj != null)
				repo.save(obj);
			
			msg = "Appointment | Id: " + obj.getAppointmentId() + " | Date: " + obj.getAppointmentDate() + " | was added to the database";
			log.info(msg);
		}
		catch (NullPointerException e)
		{
			msg = "Appointment was null in addAppointment() | Error Msg: " + e.getMessage();
			log.error(msg);
		}
		catch (Exception e)
		{
			msg = "Unhandled exception in addAppointment() | " + e.getMessage();
			log.error(msg);
		}
		
		return msg;
	}

	@Override
	public String updateAppointment(Appointment obj) 
	{
		String msg = "";
		try
		{
			repo.save(obj);
			msg = "Appointment | Id: " + obj.getAppointmentId() + " | Date: " + obj.getAppointmentDate() + " | was updated in the database";
			log.info(msg);
		}
		catch (NullPointerException e)
		{
			msg = "Appointment was null in updateAppointment() | Error Msg: " + e.getMessage();
			log.error(msg);
		}
		catch (Exception e)
		{
			msg = "Unhandled exception in updateAppointment() | " + e.getMessage();
			log.error(msg);
		}
		
		return msg;
	}

	@Override
	public String deleteAppointment(Appointment obj) 
	{
		String msg = "";
		
		try
		{
			repo.delete(obj);
			
			msg = "Appointment | Id: " + obj.getAppointmentId() + " | Date: " + obj.getAppointmentDate() + " | was deleted to the database";
			log.info(msg);
		}
		catch (NullPointerException e)
		{
			msg = "Appointment was null in deleteAppointment() | Error Msg: " + e.getMessage();
			log.error(msg);
		}
		catch (Exception e)
		{
			msg = "Unhandled exception in deleteAppointment() | " + e.getMessage();
			log.error(msg);
		}
		
		return msg;
	}

	@Override
	public Appointment getAppointmentById(int id)
	{
		return null;
	}

	@Override
	public List<Appointment> getAppointments() 
	{
		ArrayList<Appointment> pList = null;
		
		try
		{
			pList = (ArrayList<Appointment>) repo.findAll();
			
			if(pList == null)
				throw new NullPointerException("AppointmentRepository returned a null list");
			
			log.info("getAppointments() called | Result: " + pList);
		}catch(NullPointerException e)
		{
			log.error("NullPointer exception in getAppointments() | Error: " + e.getMessage());
		}catch (Exception e)
		{
			log.error("Unhandled exception in getAppointments() | Error: " + e.getMessage());
		}
		
		return pList;
	}

	@Override
	public List<Appointment> getAppointmentsByPatient(Patient obj) 
	{
		ArrayList<Appointment> pList = null;
		
		try
		{
			ArrayList<Appointment> tList = (ArrayList<Appointment>) repo.findAll();
			
			if(tList == null)
				throw new NullPointerException("AppointmentRepository returned a null list");
			
			pList = new ArrayList<Appointment>();
			
			for(Appointment a : tList)
			{
				if(a.getPatient().getPatientId() == obj.getPatientId())
					pList.add(a);
			}
			
			log.info("getAppointmentsByPatient() called | Result: " + pList);
		}catch(NullPointerException e)
		{
			log.error("NullPointer exception in getAppointmentsByPatient() | Error: " + e.getMessage());
		}catch (Exception e)
		{
			log.error("Unhandled exception in getAppointmentsByPatient() | Error: " + e.getMessage());
		}
		
		return pList;
	}

	@Override
	public List<Appointment> getAppointmentsByDoctor(Doctor obj)
	{
		ArrayList<Appointment> pList = null;
		
		try
		{
			ArrayList<Appointment> tList = (ArrayList<Appointment>) repo.findAll();
			
			if(tList == null)
				throw new NullPointerException("AppointmentRepository returned a null list");
			
			pList = new ArrayList<Appointment>();
			
			for(Appointment a : tList)
			{
				if(a.getDoctor().getDoctorId() == obj.getDoctorId())
					pList.add(a);
			}
			
			log.info("getAppointmentsByPatient() called | Result: " + pList);
		}catch(NullPointerException e)
		{
			log.error("NullPointer exception in getAppointmentsByPatient() | Error: " + e.getMessage());
		}catch (Exception e)
		{
			log.error("Unhandled exception in getAppointmentsByPatient() | Error: " + e.getMessage());
		}
		
		return pList;
	}

}
