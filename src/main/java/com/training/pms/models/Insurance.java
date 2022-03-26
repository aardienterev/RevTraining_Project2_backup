package com.training.pms.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name = "insurance")
public class Insurance
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int insuranceId;

	private String insuranceName;
	private String phoneNumber;
	private String address;
	
	@OneToMany
	@JoinColumn(name = "insuranceId")
	List<Patient> customerList = new ArrayList<Patient>();
}
