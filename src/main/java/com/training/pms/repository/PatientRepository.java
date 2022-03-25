package com.training.pms.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.pms.models.Patient;


public interface PatientRepository extends CrudRepository<Patient, Integer>
{

}
