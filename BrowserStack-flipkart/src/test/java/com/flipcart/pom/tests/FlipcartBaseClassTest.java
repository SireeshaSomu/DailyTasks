package com.flipcart.pom.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class FlipcartBaseClassTest {
	public static WebDriver driver = null;

	@BeforeSuite
	public WebDriver initialize() throws IOException {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();

		}
		return driver;
	}

	@AfterSuite
	public void closeTheBrowsers() {
		if (driver != null) {
			// driver.quit();
		}
	}
}
