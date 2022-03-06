package com.flipcart.pom.tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.flipcart.pom.FlipcartSearchResultsPage;

public class FlipcartSearchResultsPageTest extends FlipcartBaseClassTest {
	WebDriver driver = null;
	FlipcartSearchResultsPage searchResultsPage = null;

	@BeforeClass
	public void init() throws Exception {
		driver = initialize();
		searchResultsPage = new FlipcartSearchResultsPage(driver);
	}

	@Test(priority = 0)
	public void clickOnMobilesFilter() {
		Assert.assertTrue(searchResultsPage.clickOnMobilesFilter());
	}

	@Test(priority = 1)
	public void clickOnBrandFilter() {
		Assert.assertTrue(searchResultsPage.clickOnBrandFilter());
	}

	@Test(priority = 2)
	public void clickOnFlipkartFilter() {
		Assert.assertTrue(searchResultsPage.clickOnFlipkartFilter());
	}

	@Test(priority = 3)
	public void clickOnSortByFilter() {
		Assert.assertTrue(searchResultsPage.clickOnSortByFilter());
	}

	@Test(priority = 4)
	public void fetchSearchResults() {
		List<WebElement> mobilesList = searchResultsPage.fetchSearchResults();

		Assert.assertTrue(mobilesList.size() > 0);

		for (WebElement mobile : mobilesList) {
			// System.out.println(mobile.findElement(By.xpath("//div[@class='col
			// col-7-12']/div[1]")).getText());
		}
	}
}
