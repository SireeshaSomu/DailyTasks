package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver = null;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	By continueButton = By.xpath("//a[contains(text(),'Continue')]");

	public String getLoginPageTitle() {

		return driver.getTitle();
	}

	public boolean clickOnContinueButton() {

		driver.findElement(continueButton).click();
		return true;
	}

}
