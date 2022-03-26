package com.training.pms.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "insurance")
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.StringIdGenerator.class,
//        property="insuranceId")
public class Insurance
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int insuranceId;

	private String insuranceName;
	private String phoneNumber;
	private String address;
	
	
	//@Column(nullable = true)// "Hey guys, I have a foreign key to mutlple patients"
	//@JoinColumn(name = "insuranceId")			// "Oh I know dat guy"
	//@JsonIgnore//(mappedBy="insuranceProvider", targetEntity=Insurance.class) 
	@JsonManagedReference 
	@OneToMany
	@JoinColumn(name = "insuranceId")
	private List<Patient> customerList = new ArrayList<Patient>();
	
	@JsonIgnore
	public List<Patient> getCustomerList()
	{
		return this.customerList;
	}
	
}
