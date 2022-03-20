package com.employeedirectory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	private static Base base;
	private WebDriver driver;

	private Base() {
		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static Base getInstance() {
		if (base == null) {
			base = new Base();
		}

		return base;
	}

	public WebDriver getDriver() {
		return driver;
	}
}
