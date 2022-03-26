package com.training.pms.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.pms.models.Appointment;


public interface AppointmentRepository extends CrudRepository<Appointment, Integer>
{

}
