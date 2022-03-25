package com.training.pms.models;

import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "doctors")
public class Doctor 
{
	@Id
	private int doctorId;
	private String fName;
	private String lName;
	private String email;

}
