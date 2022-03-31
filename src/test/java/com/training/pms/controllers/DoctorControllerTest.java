package com.training.pms.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.training.pms.AbstractTest;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class DoctorControllerTest extends AbstractTest {
	
	private String uri = "/doctors";
	private int doctorsId = 1;

	@BeforeEach
	protected void setUp() {
		super.setUp();
	}

	@Test
	void testAddDoctor() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateDoctor() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteDoctor() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDoctorById() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllDoctors() {
		fail("Not yet implemented");
	}

}
