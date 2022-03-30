package com.training.pms.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.pms.models.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer>
{

}
