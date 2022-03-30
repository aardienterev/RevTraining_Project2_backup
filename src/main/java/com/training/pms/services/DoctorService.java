package com.training.pms.services;

import java.util.List;

import com.training.pms.models.Doctor;

public interface DoctorService 
{
	public String addDoctor(Doctor obj);
	public String updateDoctor(Doctor obj);
	public String deleteDoctor(Doctor obj);
	
	public Doctor getDoctorById(int id);
	public List<Doctor> getDoctoryBySpecialty(String spec);//Doctor.SpecialtyType type);
	public List<Doctor> getAllDoctors();
}
