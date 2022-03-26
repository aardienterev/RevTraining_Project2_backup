package com.training.pms.services;

import java.util.List;

import com.training.pms.models.Appointment;
import com.training.pms.models.Doctor;
import com.training.pms.models.Patient;

public interface AppointmentService 
{
	public String addAppointment(Appointment obj);
	public String updateAppointment(Appointment obj);
	public String deleteAppointment(Appointment obj);
	
	public Appointment getAppointmentById(int id);
	
	public List<Appointment> getAppointments();
	public List<Appointment> getAppointmentsByPatient(Patient obj);
	public List<Appointment> getAppointmentsByDoctor(Doctor obj);

}
