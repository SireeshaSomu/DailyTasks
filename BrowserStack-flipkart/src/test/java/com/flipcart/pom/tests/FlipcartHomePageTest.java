package com.flipcart.pom.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.flipcart.pom.FlipcartHomepage;

public class FlipcartHomePageTest extends FlipcartBaseClassTest {
	WebDriver driver = null;
	FlipcartHomepage homePage = null;

	@BeforeClass
	public void init() throws Exception {
		driver = initialize();
		homePage = new FlipcartHomepage(driver);
	}

	@Test
	public void verifySearchForMobiles() {
		Assert.assertTrue(homePage.searchForMobiles("Samsung Galaxy S10"));
	}

}
