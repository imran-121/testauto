package com.testauto.core;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.testauto.store.Locators;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/* Below class is solely responsible for processing test case backend tasks
 * Its takes the WebDriver class object and performs the actions on it
 * It also leverages the functionality from Logger Class and Locators Class  
 */
public class Executor {
	private final WebDriver driver;
	private static Logger logger = LogManager.getLogger("executor_logs");

	public Executor(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkWelcomeImage() {
		boolean present = false;
		try {
			driver.findElement(By.xpath(Locators.Home.xpathHomeTab)).click();
			driver.findElement(By.xpath(Locators.Home.xpathWelcomeImg));
			present = true;
		} catch (NoSuchElementException e) {
			// writing exception to target/test/logs/executor_logs.log file
			logger.error(Helpers.convertExcepToStr(e));
		}
		return present;

	}

	// below function is fetching all of the Veterinarians and stores them to String array
	public List<String> findAllVets() {
		List<String> listVets = new ArrayList<String>();
		try {
			driver.findElement(By.xpath(Locators.Vets.xpathVetsTab)).click();
			int totalVets = driver.findElements(By.xpath(Locators.Vets.xpathVetsTable)).size();

			for (int i = 1; i <= totalVets; i++) {
				String xpath = Locators.Vets.xpathVetsName.replace("<<id>>", String.valueOf(i));
				String vetName = driver.findElement(By.xpath(xpath)).getText();
				listVets.add(vetName);
			}
		} catch (Exception e) {
			logger.error(Helpers.convertExcepToStr(e));
		}
		return listVets;
	}

	// below function is responsible for fetching all of the owners and stores them to String array
	public List<String> findAllOwners() {
		List<String> listOwners = new ArrayList<String>();
		try {
			driver.findElement(By.xpath(Locators.Owners.xpathFindOwnerTab)).click();
			driver.findElement(By.xpath(Locators.Owners.xpathFindOwnerBtn)).click();

			int totalOwners = driver.findElements(By.xpath(Locators.Owners.xpathOwnerTable)).size();

			for (int i = 1; i <= totalOwners; i++) {
				String xpath = Locators.Owners.xpathOwnerName.replace("<<id>>", String.valueOf(i));
				String OwnerName = driver.findElement(By.xpath(xpath)).getText();
				listOwners.add(OwnerName);
			}
		} catch (Exception e) {
			logger.error(Helpers.convertExcepToStr(e));
		}
		return listOwners;
	}

	// Below function is responsible for adding new owner and pets
	// It takes data in the form of Map as key and value
    // Its also returns the url of specific owner for further processing
	public String addNewOwnerAndPet(Map<String, String> ownerData, Map<String, String> petData) {
		String url = "";
		try {
			driver.findElement(By.xpath(Locators.Owners.xpathFindOwnerTab)).click();
			driver.findElement(By.xpath(Locators.AddOwner.xpathAddOwnerBtn)).click();

			driver.findElement(By.xpath(Locators.AddOwner.xpathFirstName))
					.sendKeys((String) ownerData.get("firstName"));
			driver.findElement(By.xpath(Locators.AddOwner.xpathLastName)).sendKeys((String) ownerData.get("lastName"));
			driver.findElement(By.xpath(Locators.AddOwner.xpathAddress)).sendKeys((String) ownerData.get("address"));
			driver.findElement(By.xpath(Locators.AddOwner.xpathCity)).sendKeys((String) ownerData.get("city"));
			driver.findElement(By.xpath(Locators.AddOwner.xpathTele)).sendKeys((String) ownerData.get("telephone"));
			driver.findElement(By.xpath(Locators.AddOwner.xpathSubmitOwner)).click();

			driver.findElement(By.xpath(Locators.AddPet.xpathAddPetBtn)).click();
			driver.findElement(By.xpath(Locators.AddPet.xpathpetName)).sendKeys((String) petData.get("name"));
			driver.findElement(By.xpath(Locators.AddPet.xpathBirthDate)).sendKeys((String) petData.get("birthDate"));
			Select petTypeSelect = new Select(driver.findElement(By.xpath(Locators.AddPet.xpathPetType)));
			petTypeSelect.selectByVisibleText((String) petData.get("type"));
			driver.findElement(By.xpath(Locators.AddPet.xpathSubmitPet)).click();

			url = driver.getCurrentUrl();
		} catch (Exception e) {
			logger.error(Helpers.convertExcepToStr(e));
		}

		return url;
	}
	
	// Below function takes the string url of specific owner and extracts the information
	// After extracting information it compares with given owner data and pet data, as in parameters
	// Returns boolean after validating the information
	public boolean checkOwnerInformation(String ownerUrl, Map<String, String> ownerData, Map<String, String> petData) {
		try {
			driver.navigate().to(ownerUrl);

			String ownerName = driver.findElement(By.xpath(Locators.Owner.xpathOwnerName)).getText();
			String address = driver.findElement(By.xpath(Locators.Owner.xpathOwnerAddress)).getText();
			String city = driver.findElement(By.xpath(Locators.Owner.xpathOwnerCity)).getText();
			String tele = driver.findElement(By.xpath(Locators.Owner.xpathTele)).getText();

			String petName = driver.findElement(By.xpath(Locators.Pet.xpathpetName)).getText();
			String birthDate = driver.findElement(By.xpath(Locators.Pet.xpathBirthDate)).getText();
			String petType = driver.findElement(By.xpath(Locators.Pet.xpathPetType)).getText();

			if (!ownerName.equals(ownerData.get("firstName") + " " + ownerData.get("lastName"))
					|| !address.equals(ownerData.get("address"))) {
				return false;
			}

			if (!city.equals(ownerData.get("city")) || !tele.equals(ownerData.get("telephone"))) {
				return false;
			}

			if (!petName.equals(petData.get("name")) || !birthDate.equals(petData.get("birthDate"))
					|| !petType.equals(petData.get("type"))) {
				return false;
			}

			return true;
		} catch (Exception e) {
			logger.error(Helpers.convertExcepToStr(e));
			return false;
		}
	}

}

