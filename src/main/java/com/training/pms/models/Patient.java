package com.training.pms.models;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "patients")
//@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class,
//property="patientId")
public class Patient 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	
	@Column(unique=true)
	private String username;
	private String password;
	
	@Column(unique=true)
	private String email;
	private String address;
	private String phoneNumber;
	
	//@JsonIgnore//
	//@JsonBackReference 
	//@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)	
	//@JoinColumn(name = "insuranceId")
	//public Insurance insuranceProvider;
	
//	@JsonIgnore
//	public Insurance getInsuranceProvider()
//	{
//		return this.insuranceProvider;
//	}

}
