package com.training.pms.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "insuranceprovider")
public class InsuranceProvider 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int providerId;
	
	@Column(unique=true)
	private String providerName;
	private String phoneNumber;
	private String address;
}
