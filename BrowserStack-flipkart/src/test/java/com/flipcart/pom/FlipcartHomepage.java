package com.flipcart.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlipcartHomepage {
	/**
	 * Create a free trial account on BrowserStack to automate this test case using
	 * any programming language of your choice.
	 * 
	 * Using Selenium, load the flipkart.com desktop home page. Search for the
	 * product "Samsung Galaxy S10" on that page. On the search results click on
	 * "Mobiles" in categories. Apply the following filters (in filters section on
	 * the left hand side): Brand: Samsung Select Flipkart assured Sort the entries
	 * with Price -> High to Low. Read the set of results that show up on page 1.
	 * Create a list with the following parameters, and print this on the console.
	 * 
	 * Product Name Display Price Link to Product Details Page Please configure such
	 * that the same test case is run in parallel on different desktop browser / OS
	 * combinations, using the 5 parallels of your free trial account on
	 * BrowserStack Automate product.
	 */

	WebDriver driver = null;

	public FlipcartHomepage(WebDriver driver) {
		this.driver = driver;
	}

	// locators for this page
	By closePopup = By.xpath("//button[contains(text(),'✕')]");
	By search = By.xpath("//input[@type='text']");

	public boolean searchForMobiles(String searchStr) {
		driver.findElement(closePopup).click();
		driver.findElement(search).click();
		driver.findElement(search).sendKeys(searchStr + "\n");
		return true;
	}
}
