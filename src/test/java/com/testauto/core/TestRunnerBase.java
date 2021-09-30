package com.testauto.core;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

// This is the base class for Test Runner class
// Setting up all of base configuration for driver
public class TestRunnerBase {

	protected WebDriver webDriver;

	@BeforeClass
	public static void prepareWebDriver() {
		WebDriverManager.chromedriver().setup();
	}

	@Before
	public void setUp() {
		createWebDriver();
	}

	private void createWebDriver() {
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");
		options.addArguments("--window-size=1920,1200");

		webDriver = new ChromeDriver(options);
		webDriver.get("http://localhost:8080");
	}

	@After
	public void afterEachBaseSeleniumTest() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}
}
