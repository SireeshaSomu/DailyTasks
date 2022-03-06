package com.flipcart.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.TimeoutUtil;

public class FlipcartSearchResultsPage {
	WebDriver driver = null;

	public FlipcartSearchResultsPage(WebDriver driver) {
		this.driver = driver;

	}

	By mobilesFilter = By.xpath("//a[@title='Mobiles']");
	By brandFilter = By.xpath("//div[@title='SAMSUNG'] //input[@type='checkbox'] /following-sibling::div");
	By flipkartFilter = By.xpath(
			"//div[contains(text(), 'Customer Ratings')] /parent::div //parent::section /following-sibling::section /label /input[@type='checkbox'] /following-sibling::div");
	By sortByFilter = By.xpath("//div[contains(text(),'Price -- High to Low')]");
	By results = By.xpath(
			"//*[@id='container']/div/div[3]/div/div[2]/div[contains(@class, 'col-12-12')][position() > 1 and position() < 26]");
	By productNames = By.xpath("//div[@class='col col-7-12']/div[1]");
	By productPrices = By.xpath("//div[starts-with(@class, 'col col-5-12')]/div[1]/div[1]/div[1]");
	By productLinks = By.xpath("//*[@id='container']/div/div[3]/div/div[2]/div/div/div/div/a");

	public boolean clickOnMobilesFilter() {
		TimeoutUtil.waitSeconds(4);
		driver.findElement(mobilesFilter).click();
		return true;
	}

	public boolean clickOnBrandFilter() {
		TimeoutUtil.waitSeconds(4);
		driver.findElement(brandFilter).click();
		return true;

	}

	public boolean clickOnFlipkartFilter() {
		TimeoutUtil.waitSeconds(4);
		driver.findElement(flipkartFilter).click();
		return true;

	}

	public boolean clickOnSortByFilter() {
		TimeoutUtil.waitSeconds(4);
		driver.findElement(sortByFilter).click();
		return true;

	}

	public List<WebElement> fetchSearchResults() {
		TimeoutUtil.waitSeconds(4);
		List<WebElement> listOfMobiles = driver.findElements(results);
		List<WebElement> productNamesList = driver.findElements(productNames);
		List<WebElement> productPricesList = driver.findElements(productPrices);
		List<WebElement> productLinksList = driver.findElements(productLinks);

		for (int i = 0; i < listOfMobiles.size(); i++) {
			int productNum = i + 1;
			System.out.println("\n**************Product " + productNum + "**************");
			System.out.print("Product name: ");
			System.out.print(productNamesList.get(i).getText());
			System.out.print("\nProduct price: ");
			System.out.print(productPricesList.get(i).getText());
			System.out.print("\nProduct link: ");
			System.out.println(productLinksList.get(i).getAttribute("href"));
		}

		return listOfMobiles;
	}

	public List<WebElement> fetchProductPhones() {
		TimeoutUtil.waitSeconds(4);
		return driver.findElements(productNames);
	}
}
