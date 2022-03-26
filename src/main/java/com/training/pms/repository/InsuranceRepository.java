package com.training.pms.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.pms.models.Insurance;


public interface InsuranceRepository  extends CrudRepository<Insurance, Integer>
{

}
