package com.training.pms.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctorId;
	private String doctorName;
	private String email;
	private String phoneNumber;
	private String specialty;
	
//	@Enumerated(EnumType.STRING)
//	private SpecialtyType specialty;
//
//	public static enum SpecialtyType
//	{
//		EyeDoctor("Eye Doctor"), Dentist("Dentist"), Psychiatrist("Psychiatrist"), Dermatologist("Dermatologist");
//		
//		private String value;
//		
//		SpecialtyType(String txt)
//		{
//			this.value = txt;
//		}
//		
//		@Override
//		public String toString()
//		{
//			return this.value;
//		}
//		
//		public SpecialtyType fromString(String str) // if null is returned there are no valid arguements
//		{
//			for(SpecialtyType type : SpecialtyType.values())
//				if(type.value.equalsIgnoreCase(str))
//					return type;
//			
//			return null;
//		}
//	}
	
}
