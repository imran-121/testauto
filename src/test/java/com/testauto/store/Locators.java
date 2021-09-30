package com.testauto.store;


/*
 * This class is the repository for xpaths
 * xpaths are segregated on the basis of respective page object level
 * */
public final class Locators {
	
	public static final class Home{
		public static String xpathHomeTab = "//a[@title='home page']";
		public static String xpathWelcomeImg = "//img[@src='/resources/images/pets.png']"; 
	}
	
	
	
	public static final class Vets{
		public static String xpathVetsTab = "//a[@title='veterinarians']";
		public static String xpathVetsTable = "//table[@id='vets']//tbody/tr"; 
		public static String xpathVetsName = "//table[@id='vets']//tbody/tr[<<id>>]/td[1]";
	}
	
	public static final class Owners{
		public static String xpathFindOwnerTab = "//a[@title='find owners']";
		public static String xpathFindOwnerBtn = "//form[@id='search-owner-form']//button[contains(text(),'Find')]";
		public static String xpathOwnerTable = "//*[@id='owners']/tbody/tr";
		public static String xpathOwnerName = "//table[@id='owners']//tbody/tr[<<id>>]/td[1]/a";
		
	}
	
	public static final class Owner{
		public static String xpathOwnerName = "//h2[text()='Owner Information']/following-sibling::table[1]//tr/th[text()='Name']/following-sibling::td/b";
		public static String xpathOwnerAddress = "//h2[text()='Owner Information']/following-sibling::table[1]//tr/th[text()='Address']/following-sibling::td";
		public static String xpathOwnerCity = "//h2[text()='Owner Information']/following-sibling::table[1]//tr/th[text()='City']/following-sibling::td";
		public static String xpathTele = "//h2[text()='Owner Information']/following-sibling::table[1]//tr/th[text()='Telephone']/following-sibling::td";
		
	}
	
	
	public static final class AddOwner{
		public static String xpathAddOwnerBtn = "//*[@id='search-owner-form']//following-sibling::a[contains(text(),'Add Owner')]";
		public static String xpathFirstName = "//*[@id='firstName']";
		public static String xpathLastName = "//*[@id='lastName']";
		public static String xpathAddress = "//*[@id='address']";
		public static String xpathCity = "//*[@id='city']";
		public static String xpathTele = "//*[@id='telephone']";
		public static String xpathSubmitOwner = "//*[@id ='add-owner-form']//button[@type='submit' and text()='Add Owner']";
	}
	
	public static final class Pet{
		public static String xpathpetName = "//h2[text()='Pets and Visits']/following-sibling::table[1]//tr//dt[text()='Name']/following-sibling::dd[1]";
		public static String xpathBirthDate = "//h2[text()='Pets and Visits']/following-sibling::table[1]//tr//dt[text()='Birth Date']/following-sibling::dd[1]";
		public static String xpathPetType = "//h2[text()='Pets and Visits']/following-sibling::table[1]//tr//dt[text()='Type']/following-sibling::dd[1]";
	}
	
	public static final class AddPet{
		public static String xpathAddPetBtn = "//a[contains(text(),'New') and @class='btn btn-default']";
		public static String xpathpetName = "//*[@id='name']";
		public static String xpathBirthDate = "//*[@id='birthDate']";
		public static String xpathPetType = "//*[@id='type']";
		public static String xpathSubmitPet = "//button[text()='Add Pet']";
	}
	
	
	
	
	

}
