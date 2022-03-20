package stepdefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.employeedirectory.Base;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeDirectoryStepdefinitions {
	WebDriver driver = null;

	@Before(order = 0)
	public void setup() {
		driver = Base.getInstance().getDriver();
	}

	@Before(order = 1)
	public void beforeScenario(Scenario sc) {
		System.out.println("**********Scenario Starts***********");
		System.out.println(sc.getName());
		System.out.println("startTest");
	}

	@Given("launch url")
	public void launch_url() {
		System.out.println("launch url");
		driver.get("http://54.200.154.26/");

	}

	@Given("user is on home page")
	public void user_is_on_home_page() {
		Assert.assertEquals(driver.getCurrentUrl(), "http://54.200.154.26/");
		Assert.assertEquals(driver.getTitle(), "Employee Directory");

	}

	@Then("user click on add button")
	public void user_click_on_add_button() {
		driver.findElement(By.xpath("//a[contains(text(),'Add')]")).click();

	}

	@And("user navigated to add page")
	public void user_navigated_to_add_page() {
		Assert.assertEquals(driver.getCurrentUrl(), "http://54.200.154.26/add");

	}

	@When("user enters the following details")
	public void user_enters_the_following_details(DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		List<List<String>> userList = dataTable.asLists(String.class);
		List<String> userData = userList.get(1);

		driver.findElement(By.xpath("//input[@id='full_name']")).sendKeys(userData.get(0));
		driver.findElement(By.xpath("//input[@id='location']")).sendKeys(userData.get(1));
		driver.findElement(By.xpath("//input[@id='job_title']")).sendKeys(userData.get(2));

		if (userData.get(3) != null && "Windows User".equals(userData.get(3))) {
			driver.findElement(By.xpath("//input[@id='windows']")).click();
		}

	}

	@And("user click on save button")
	public void user_click_on_save_button() {
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

	}

	@Then("user validate the details provided are saved")
	public void user_validate_the_details_provided_are_saved() {
		String savedMsg = driver.findElement(By.xpath("//div[@class='alert alert-primary']")).getText();
		Assert.assertEquals(savedMsg, "Saved!");
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
