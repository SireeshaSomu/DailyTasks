package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationFormPage {
	WebDriver driver = null;

	public RegistrationFormPage(WebDriver driver) {
		this.driver = driver;

	}

	By byFirstName = By.id("input-firstname");
	By byLastName = By.id("input-lastname");
	By byEmail = By.id("input-email");
	By byPhoneNum = By.id("input-telephone");
	By byPassword = By.id("input-password");
	By byConfirmPassword = By.id("input-confirm");
	By byPrivacyPolicy = By.xpath("//input[@type='checkbox']");

	By submit = By.xpath("//input[@type='submit']");

	public String getRegistrationPageTitle() {

		return driver.getTitle();
	}

	public boolean fillRegistrationDetails(String firstName, String lastName, String email, String phoneNum,
			String password) {

		driver.findElement(byFirstName).sendKeys(firstName);
		driver.findElement(byLastName).sendKeys(lastName);
		driver.findElement(byEmail).sendKeys(email);
		driver.findElement(byPhoneNum).sendKeys(phoneNum);
		driver.findElement(byPassword).sendKeys(password);
		driver.findElement(byConfirmPassword).sendKeys(password);

		return true;
	}

	public boolean clickOnPrivacyPolicy() {

		driver.findElement(byPrivacyPolicy).click();

		return true;
	}

	public boolean submitRegistrationForm() {

		driver.findElement(submit).click();
		return true;
	}

	public String getAccountPageTitle() {
		return driver.getTitle();
	}

}
