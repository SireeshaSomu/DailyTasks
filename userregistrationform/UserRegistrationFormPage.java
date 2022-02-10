package com.userregistrationform.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class UserRegistrationFormPage {
	public WebDriver driver;

	public UserRegistrationFormPage(WebDriver driver) {

		this.driver = driver;
	}

	// locators for this page
	By firstname = By.name("firstname");
	By middlename = By.name("middlename");
	By lastname = By.name("lastname");
	By course = By.xpath("//body//form//select");
	By male = By.name("male");
	By female = By.name("female");
	By other = By.name("other");
	By phonenum = By.name("phone");
	By address = By.xpath("//textarea[@value='address']");
	By email = By.id("email");
	By password = By.id("pass");
	By repass = By.id("repass");
	By submit = By.xpath("//input[@value='Submit']");
	By thankyouText = By.xpath("//body//h1");

	public boolean fillUserDetailsAndSubmit(String ufirstname, String umiddlename, String ulastname, String ucourse,
			String ugender, String uphonenum, String uaddress, String uemail, String upassword) {
		driver.findElement(firstname).sendKeys(ufirstname);
		driver.findElement(middlename).sendKeys(umiddlename);
		driver.findElement(lastname).sendKeys(ulastname);

		Select courseSelector = new Select(driver.findElement(course));
		courseSelector.selectByValue(ucourse);

		if ("Male".equalsIgnoreCase(ugender)) {
			driver.findElement(male).click();
		} else if ("Female".equalsIgnoreCase(ugender)) {
			driver.findElement(female).click();
		} else {
			driver.findElement(other).click();
		}
		driver.findElement(phonenum).sendKeys(uphonenum);
		driver.findElement(address).sendKeys(uaddress);
		driver.findElement(email).sendKeys(uemail);
		driver.findElement(password).sendKeys(upassword);
		driver.findElement(repass).sendKeys(upassword);

		driver.findElement(submit).click();
		return true;
	}

	public String getThankYouText() {
		return driver.findElement(thankyouText).getText();
	}

	public String navigateToPreviousPageAndRefresh() {
		driver.navigate().back();
		driver.navigate().refresh();

		return driver.getCurrentUrl();
	}

}
