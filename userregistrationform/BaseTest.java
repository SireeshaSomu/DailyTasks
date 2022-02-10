package com.userregistrationform.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	private static WebDriver driver;

	@BeforeSuite
	public WebDriver initialize() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://assignmentbucket123.s3-website.us-east-2.amazonaws.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
		return driver;
	}

	@AfterSuite
	public void quit() {
		if (driver != null) {
			driver.quit();
		}
	}
}
