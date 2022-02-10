package com.userregistrationform.pom;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.util.ExcelUserRegistrationDetails;

public class UserRegistrationFormPageTest extends BaseTest {
	public WebDriver driver = null;
	public UserRegistrationFormPage userRegistrationFormPage;

	@BeforeClass
	public void setUp() {
		driver = initialize();
		userRegistrationFormPage = new UserRegistrationFormPage(driver);
	}

	@DataProvider(name = "userRegistrationDetails")
	public Object[][] retriveUserRegistrationDetails() {
		String excelFile = "C:\\Users\\adire\\OneDrive\\Documents\\Siri_Selenium\\excel\\UserRegistrationFormDetails.xlsx";
		ExcelUserRegistrationDetails excelUserRegistrationDetails = new ExcelUserRegistrationDetails(excelFile);
		Object[][] userRegistrationDetails = excelUserRegistrationDetails.getUserData("UserDetails");

		excelUserRegistrationDetails.closeWorkbook();

		return userRegistrationDetails;
	}

	@Test(dataProvider = "userRegistrationDetails")
	public void enterRegistrationformDetailsAndSubmit(String ufirstname, String umiddlename, String ulastname,
			String ucourse, String ugender, String uphonenum, String uaddress, String uemail, String upassword) {

		boolean isSuccess = userRegistrationFormPage.fillUserDetailsAndSubmit(ufirstname, umiddlename, ulastname,
				ucourse, ugender, uphonenum, uaddress, uemail, upassword);

		Assert.assertTrue(isSuccess);

		String thankYouText = userRegistrationFormPage.getThankYouText();

		Assert.assertEquals(thankYouText.trim(), "THANK YOU");

		String currentUrl = userRegistrationFormPage.navigateToPreviousPageAndRefresh();

		Assert.assertEquals(currentUrl, "http://assignmentbucket123.s3-website.us-east-2.amazonaws.com/");
	}
}
