package stepdefinitions;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import core.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.DataTablesAndButtonStatesPage;

public class DataTablesAndButtonStatesStepDefinitions {

	private DataTablesAndButtonStatesPage dataTablesAndButtonStatesPage = null;

	private String mainPageHeaderTitle = null;
	private int totalNumOfTables = 0;
	private WebElement tableData = null;
	private boolean isSuccess = false;
	private int rowsCount = 0;

	@Before(order = 0)
	public void initialize(Scenario sc) {
		dataTablesAndButtonStatesPage = new DataTablesAndButtonStatesPage(Base.getInstance().getDriver());
	}

	@When("^user reads the main page header title$")
	public void user_reads_the_main_page_header_title() {
		mainPageHeaderTitle = dataTablesAndButtonStatesPage.getPageHeaderTitle();

		Assert.assertNotNull(mainPageHeaderTitle);
	}

	@Then("user validate the main page header title should be {string}")
	public void user_validate_the_main_page_header_title_should_be(String string) {
		Assert.assertEquals(mainPageHeaderTitle, string);
	}

	@When("^user reads the total number of tables count$")
	public void user_reads_the_total_number_of_tables_count() {
		totalNumOfTables = dataTablesAndButtonStatesPage.getTotalNumOfTables();

		Assert.assertNotNull(totalNumOfTables);
	}

	@Then("user validate the total number tables count should be {string}")
	public void user_validate_the_total_number_tables_count_should_be(String string) {
		Assert.assertEquals(String.valueOf(totalNumOfTables), string);
	}

	@When("^user reads the table one details$")
	public void user_reads_the_table_one_details() {
		tableData = dataTablesAndButtonStatesPage.getTableOneDetails();

		Assert.assertNotNull(tableData);
	}

	@Then("^user validate the contents of the table one with the following values$")
	public void user_validate_the_contents_of_the_table_one_with_the_following_values(DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.

		boolean isSuccess = dataTablesAndButtonStatesPage.verifyHtmlTableData(dataTable, tableData);

		Assert.assertTrue(isSuccess);
	}

	@When("^user reads the table two details$")
	public void user_reads_the_table_two_details() {
		tableData = dataTablesAndButtonStatesPage.getTableTwoDetails();

		Assert.assertNotNull(tableData);
	}

	@Then("^user validate the contents of the table two with the following values$")
	public void user_validate_the_contents_of_the_table_two_with_the_following_values(DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.

		boolean isSuccess = dataTablesAndButtonStatesPage.verifyHtmlTableData(dataTable, tableData);

		Assert.assertTrue(isSuccess);
	}

	@When("user enters the first name {string} and last name {string}")
	public void user_enters_the_first_name_and_last_name(String string, String string2) {
		isSuccess = dataTablesAndButtonStatesPage.enterFirstAndLastName(string, string2);
	}

	@Then("user validate the input fields")
	public void user_validate_the_input_fields() {
		Assert.assertTrue(isSuccess);
	}

	@When("user enters the input text as {string}")
	public void user_enters_the_input_text_as(String string) {
		isSuccess = dataTablesAndButtonStatesPage.enterInputTextBelow(string);
	}

	@Then("user validate the input text field")
	public void user_validate_the_input_text_field() {
		Assert.assertTrue(isSuccess);
	}

	@When("user checks the breadcrumb links count should be {string}")
	public void user_checks_the_breadcrumb_links_count_should_be(String string) {
		Assert.assertEquals(dataTablesAndButtonStatesPage.getBreadCrumbLinksCount(), 3);
	}

	@Then("user validate the home and about links are enabled and contact us not enabled")
	public void user_validate_the_home_and_about_links_are_enabled_and_contact_us_not_enabled() {
		Assert.assertTrue(dataTablesAndButtonStatesPage.validateBreadCrumbLinks());
	}

	@When("user checks pagination links")
	public void user_checks_pagination_links() {
		isSuccess = dataTablesAndButtonStatesPage.paginationLinksCheck();
	}

	@Then("user validate all pages href value is same")
	public void user_validate_all_pages_href_value_is_same() {
		Assert.assertTrue(isSuccess);
	}

	@When("user checks the table three details")
	public void user_checks_the_table_three_details() {
		rowsCount = dataTablesAndButtonStatesPage.tableThreeCheck();
	}

	@Then("user validate the table three rows count should be four")
	public void user_validate_table_three_rows_count_should_be_four() {
		Assert.assertEquals(rowsCount, 4);
	}

	@When("user checks the state of buttons")
	public void user_checks_the_state_of_buttons() {
		isSuccess = dataTablesAndButtonStatesPage.buttonstatesCheck();
	}

	@Then("user validate the warning button is not enabled")
	public void user_validate_the_warning_button_is_not_enabled() {
		Assert.assertTrue(isSuccess);
	}

	@Before(order = 1)
	public void beforeScenario(Scenario sc) {
		isSuccess = false;
		System.out.println("**********Scenario Starts***********");
		System.out.println(sc.getName());
		System.out.println("startTest");
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
