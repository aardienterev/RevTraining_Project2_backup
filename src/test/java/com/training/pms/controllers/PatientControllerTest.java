package com.training.pms.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.training.pms.AbstractTest;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class PatientControllerTest extends AbstractTest {
	
	private String uri = "/patient";
	private int patientId = 1;

	@BeforeEach
	protected void setUp() {
		super.setUp();
	}

	@Test
	void testAddPatient() {
		fail("Not yet implemented");
	}

	@Test
	void testLoginPatient() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdatePatient() {
		fail("Not yet implemented");
	}

	@Test
	void testDeletePatient() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPatientById() {
		fail("Not yet implemented");
	}

	@Test
	void testDoesPatientExist() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPatients() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPatientsByName() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPatientsByInsurance() {
		fail("Not yet implemented");
	}

}
