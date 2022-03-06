package stepdefinitions;

import java.util.List;

import org.junit.Assert;

import core.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.LoginPage;
import pom.RegistrationFormPage;

public class RegistrationStepDefinition {

	private LoginPage loginPage = null;
	private RegistrationFormPage registrationFormPage = null;

	@Before(order = 0)
	public void initialize(Scenario sc) {
		loginPage = new LoginPage(Base.getInstance().getDriver());
		registrationFormPage = new RegistrationFormPage(Base.getInstance().getDriver());
	}

	@Before(order = 1)
	public void beforeScenario(Scenario sc) {
		System.out.println("**********Scenario Starts***********");
		System.out.println(sc.getName());
		System.out.println("startTest");
	}

	@Given("^user is on login page$")
	public void user_is_on_login_page() {

		String pageTitle = "Account Login";
		Assert.assertTrue(loginPage.getLoginPageTitle().contains(pageTitle));

	}

	@When("^user clicks on continue button$")
	public void user_clicks_on_continue_button() {
		Assert.assertTrue(loginPage.clickOnContinueButton());

	}

	@Then("^user is navigated to the registration page$")
	public void user_is_navigated_to_the_registration_page() {
		String pageTitle = "Register Account";
		Assert.assertTrue(registrationFormPage.getRegistrationPageTitle().contains(pageTitle));

	}

	@Given("^user is on registration page to enter the personal details$")
	public void user_is_on_registration_page_to_enter_the_personal_details() {

		System.out.println("user is on registration page to enter the personal details");

	}

	@When("^user reads the following details$")
	public void user_reads_the_following_details(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.

		List<List<String>> userList = dataTable.asLists(String.class);
		List<String> userData = userList.get(1);

		String firstName = userData.get(0);
		String lastName = userData.get(1);
		String email = userData.get(2);
		String phoneNum = userData.get(3);
		String password = userData.get(4);

		boolean isSuccess = registrationFormPage.fillRegistrationDetails(firstName, lastName, email, phoneNum,
				password);
		Assert.assertTrue(isSuccess);
	}

	@And("^select privacy policy checkbox$")
	public void select_privacy_policy_checkbox() {
		Assert.assertTrue(registrationFormPage.clickOnPrivacyPolicy());

	}

	@And("^click on submit button$")
	public void click_on_submit_button() {
		Assert.assertTrue(registrationFormPage.submitRegistrationForm());

	}

	@Then("^user should be able to create an account$")
	public void user_should_be_able_to_create_an_account() {
		String pageTitle = "Your Account Has Been Created!";
		Assert.assertTrue(registrationFormPage.getAccountPageTitle().contains(pageTitle));

	}

	@After(order = 1)
	public void afterStep(Scenario sc) {
		System.out.println("endTest");
	}

	@After(order = 0)
	public void afterScenario(Scenario sc) {
		System.out.println(sc.getStatus());
	}
}
