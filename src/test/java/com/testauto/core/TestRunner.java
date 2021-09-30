package com.testauto.core;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/*
 * Below class is starting point of test execution
 * Its a collection of test cases 
 */
public class TestRunner extends TestRunnerBase {

	// 1) Verify image on home page
	@Test
	public void verifyImageOnHomePage() {
		// Sending driver to executor and executor will respond back after completing
		// job
		Executor executor = new Executor(webDriver);
		assertEquals(true, executor.checkWelcomeImage());
	}

	// 2) Find all the Veterinarians which are added in the application
	@Test
	public void getListOfAllVets() {

		Executor executor = new Executor(webDriver);
		List<String> listVets = executor.findAllVets();
		assert (true);
	}

	// 3) Find all the existing owners which are added in application
	@Test
	public void getListOfAllOwners() {

		Executor executor = new Executor(webDriver);
		List<String> listOwners = executor.findAllOwners();
		assert (true);
	}

	// 4) Add a new owner, add pet for that owner and 5)Check all the information
	// added for the newly created owner and pet is correct
	@Test
	public void addNewOwnerAndPet() {

		Executor executor = new Executor(webDriver);
		// Setting up test data for owner
		Map<String, String> newOwnerData = new HashMap<>();
		newOwnerData.put("firstName", "imran");
		newOwnerData.put("lastName", "abbas");
		newOwnerData.put("address", "pakistan");
		newOwnerData.put("city", "islamabad");
		newOwnerData.put("telephone", "6085551700");
		// Setting up test data for pet
		Map<String, String> newPetData = new HashMap<>();
		newPetData.put("name", "Bean");
		newPetData.put("birthDate", "2021-11-30");
		newPetData.put("type", "cat");

		// Adding new owner and pet
		String url = executor.addNewOwnerAndPet(newOwnerData, newPetData);

		// Validating newly added owner and pet information
		boolean result = executor.checkOwnerInformation(url, newOwnerData, newPetData);
		assertEquals(true, result);

	}
}
