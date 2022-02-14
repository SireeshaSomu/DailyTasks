package com.bbc;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BBCTechTest {

	private WebDriver driver = null;
	private BBCTechExcelData bbcTechExcelData = null;
	private final String EXCEL_FILE_LOCATION = "C:\\Users\\adire\\OneDrive\\Documents\\Siri_Selenium\\excel\\";
	private final String EXCEL_FILE = EXCEL_FILE_LOCATION + "BBC_HomePage.xlsx";
	private final String SCREENSHOT_FILE = EXCEL_FILE_LOCATION + "BBC_HomePage.jpg";

	public boolean takeScreenShotOfBBCPage() {
		boolean isSuccess = false;

		try {
			// Convert WebDriver object to TakesScreenshot
			TakesScreenshot screenshot = (TakesScreenshot) driver;

			// Call getScreenshotAs method to create the image file
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

			// Copy file to the desired location
			File destinationFile = new File(SCREENSHOT_FILE);
			FileUtils.copyFile(sourceFile, destinationFile);

			isSuccess = true;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

	@BeforeClass
	public void setUp() {
		bbcTechExcelData = new BBCTechExcelData(EXCEL_FILE);

		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		// options.setHeadless(true);
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.get("https://www.bbc.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void testThePageIsLoaded() {
		Assert.assertEquals(driver.getTitle(), "BBC - Homepage");
	}

	@Test(priority = 0)
	public void identifyAllLinksAndWriteIntoExcel() {

		Set<String> uniqueLinks = new HashSet<String>();

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		System.out.println(allLinks.size());

		for (WebElement link : allLinks) {
			uniqueLinks.add(link.getAttribute("href"));
		}

		System.out.println(uniqueLinks.size());

		Assert.assertTrue(allLinks.size() > 0);
		Assert.assertTrue(uniqueLinks.size() > 0);

		boolean isSuccess = bbcTechExcelData.createSheetAndWriteTheData("Links", uniqueLinks);
		Assert.assertTrue(isSuccess);
	}

	@Test(priority = 1)
	public void identifyTheTilesOfAllTopicsAndWriteIntoExcel() {

		Set<String> uniqueTitles = new HashSet<String>();

		List<WebElement> allTitles = driver.findElements(
				By.xpath("//div[@class='media__content'] /h3[@class='media__title'] /a[@class='media__link']"));

		System.out.println(allTitles.size());

		for (WebElement title : allTitles) {
			uniqueTitles.add(title.getText());
		}

		System.out.println(uniqueTitles.size());

		Assert.assertTrue(allTitles.size() > 0);
		Assert.assertTrue(uniqueTitles.size() > 0);

		boolean isSuccess = bbcTechExcelData.createSheetAndWriteTheData("TitlesOfAllTopics", uniqueTitles);
		Assert.assertTrue(isSuccess);
	}

	@Test(priority = 2)
	public void identifyTheDescriptionOfEachTopicAndWriteIntoExcel() {

		Set<String> uniqueTopicDesc = new HashSet<String>();

		List<WebElement> allTopicsDesc = driver
				.findElements(By.xpath("//div[@class='media__content'] /p[@class='media__summary']"));

		System.out.println(allTopicsDesc.size());

		for (WebElement topicDesc : allTopicsDesc) {
			uniqueTopicDesc.add(topicDesc.getText());
		}

		System.out.println(uniqueTopicDesc.size());

		Assert.assertTrue(allTopicsDesc.size() > 0);
		Assert.assertTrue(uniqueTopicDesc.size() > 0);

		boolean isSuccess = bbcTechExcelData.createSheetAndWriteTheData("DescriptionOfEachTopic", uniqueTopicDesc);
		Assert.assertTrue(isSuccess);
	}

	@Test(priority = 3)
	public void testScreenShotOfBBCPage() throws IOException {
		Assert.assertTrue(takeScreenShotOfBBCPage());
	}

	@AfterClass
	public void quit() {
		if (driver != null) {
			driver.quit();
		}

		if (bbcTechExcelData != null) {
			bbcTechExcelData.closeWorkBook();
		}
	}

}
