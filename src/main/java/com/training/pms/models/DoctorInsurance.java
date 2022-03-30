package com.training.pms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "doctorinsurance")
public class DoctorInsurance 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int insuranceId;
	
	@OneToOne
	@JoinColumn(name = "doctorId")
	private Doctor doctor;
	
	@OneToOne
	@JoinColumn(name = "providerId")
	private InsuranceProvider provider;
}
