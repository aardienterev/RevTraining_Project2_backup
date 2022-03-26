package com.training.pms.models;

import java.sql.Date;

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
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name = "appointments")
public class Appointment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointmentId;
	private String appointmentDescription;
	private String notableSymptoms;
	private Date appointmentDate; // java.sql.Date; Make sure you're reading the right documentation.
	
	@OneToOne
	@JoinColumn(name = "patientId")
	private Patient patient;
	
	@OneToOne
	@JoinColumn(name = "doctorId")
	private Doctor doctor;
}
