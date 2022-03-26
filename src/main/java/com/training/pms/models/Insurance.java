package com.training.pms.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
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
	
	@OneToMany 									// "Hey guys, I have a foreign key to mutlple patients"
	@JsonIgnore									// "Don't be a dick and give me a normal json message." 
	@JoinColumn(name = "insuranceId")			// "Oh I know dat guy"
	List<Patient> customerList = new ArrayList<Patient>();
	
}
