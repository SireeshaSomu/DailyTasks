package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;

public class DataTablesAndButtonStatesPage {

	public DataTablesAndButtonStatesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='main-header']/h1")
	private WebElement pageHeader;

	@FindBy(tagName = "table")
	private List<WebElement> totalNumOfTables;

	@FindBy(xpath = "//table[@id='t01']")
	private WebElement htmlTableOneElement;

	@FindBy(xpath = "//table[@id='t02']")
	private WebElement htmlTableTwoElement;

	@FindBy(name = "firstname")
	private WebElement firstName;
	@FindBy(name = "lastname")
	private WebElement lastName;

	@FindBy(tagName = "textarea")
	private WebElement inputTextBelow;

	@FindAll(@FindBy(xpath = "//li[starts-with(@class, 'breadcrumb-item')]"))
	private List<WebElement> breadCrumbLinks;

	@FindAll(@FindBy(xpath = "//nav//ul//li/a"))
	private List<WebElement> paginationLinks;

	@FindAll(@FindBy(xpath = "//table[@class='table table-light traversal-table']//tr"))
	private List<WebElement> tableThreeRows;
	@FindAll(@FindBy(xpath = "//table[@class='table table-light traversal-table']//tr[@class='bg-primary']/th"))
	private List<WebElement> tableThreeColumns;
	@FindAll(@FindBy(xpath = "//table[@class='table table-light traversal-table']//tr/th"))
	private List<WebElement> headerData;
	@FindAll(@FindBy(xpath = "//table[@class='table table-light traversal-table']//tr/td"))
	private List<WebElement> tableThreedata;
	private int tableThreeRowsCount;

	@FindAll(@FindBy(xpath = "//div[@class='traversal-button-states']//button[@type='button']"))
	private List<WebElement> buttonStates1;
	@FindAll(@FindBy(xpath = "//div[@class='btn-group btn-group-toggle']//button[@type='button']"))
	private List<WebElement> buttonStates2;
	@FindBy(xpath = "//button[@class='btn btn-outline-warning disabled']")
	private WebElement warningButton;

	public String getPageHeaderTitle() {
		return pageHeader.getText();
	}

	public int getTotalNumOfTables() {
		return totalNumOfTables.size();
	}

	public WebElement getTableOneDetails() {
		return htmlTableOneElement;
	}

	public WebElement getTableTwoDetails() {
		return htmlTableTwoElement;
	}

	public boolean verifyHtmlTableData(DataTable dataTable, WebElement tableData) {
		// get all of the row WebElements from the table
		List<WebElement> rowElements = tableData.findElements(By.xpath(".//tr"));
		// remove the "header" row from the list of row WebElements
		// rowElements.remove(0);

		// outer List<> is rows, inner List<> is cells
		List<List<String>> dataTableRows = dataTable.asLists();
		// loop through every row in the DataTable input
		boolean isHeaderCell = true;
		for (List<String> row : dataTableRows) {
			int rowIdx = dataTableRows.indexOf(row);

			// get the row WebElement based on the index of the current row in the DataTable
			WebElement rowElem = rowElements.get(rowIdx);

			// get all for the header cells/data cells from the row WebElement
			List<WebElement> cellElements = null;
			if (isHeaderCell) {
				cellElements = rowElem.findElements(By.xpath(".//th"));
				isHeaderCell = false;
			} else {
				cellElements = rowElem.findElements(By.xpath(".//td"));
			}

			// loop through every cell in the current DataTable row
			for (String expectedCell : row) {
				int cellIdx = row.indexOf(expectedCell);
				String actualCell = cellElements.get(cellIdx).getText();

				// for demonstration purposes
				// System.out.println("DataTable row " + rowIdx + ", cell " + cellIdx + ": " +
				// expectedCell);
				// System.out.println("Actual value on the page: " + actualCell);

				Assert.assertEquals(actualCell, expectedCell);
			}
		}

		return true;
	}

	public boolean enterFirstAndLastName(String fName, String lName) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);

		return firstName.isEnabled() && lastName.isEnabled();
	}

	public boolean enterInputTextBelow(String inputText) {
		inputTextBelow.sendKeys(inputText);

		return inputTextBelow.isEnabled();
	}

	public int getBreadCrumbLinksCount() {
		return breadCrumbLinks.size();
	}

	public boolean validateBreadCrumbLinks() {
		boolean isSuccess = false;
		for (WebElement link : breadCrumbLinks) {
			isSuccess = link.isEnabled();
			System.out.println(link.getAttribute("href"));
			System.out.println(link.getText());
			System.out.println(link.isEnabled());
		}

		return isSuccess;
	}

	public boolean paginationLinksCheck() {
		boolean isSuccess = false;
		for (WebElement pagLinks : paginationLinks) {
			isSuccess = pagLinks.getAttribute("href")
					.contentEquals("https://webdriveruniversity.com/Data-Table/index.html#");

		}

		return isSuccess;
	}

	public int tableThreeCheck() {
		tableThreeRowsCount = tableThreeRows.size();
		System.out.println("Number of rows in TableThree : " + tableThreeRowsCount);
		System.out.println("Number of rows in TableThree : " + tableThreeColumns.size());

		for (WebElement headData : headerData) {
			System.out.println("Table three header data : " + headData.getText());
		}

		for (WebElement tableData : tableThreedata) {
			System.out.println("Table three data : " + tableData.getText());
		}

		return tableThreeRowsCount;
	}

	public boolean buttonstatesCheck() {
		for (WebElement button1 : buttonStates1) {
			System.out.println(button1.isEnabled());
			System.out.println(button1.getText());
		}

		for (WebElement button2 : buttonStates2) {
			System.out.println(button2.isEnabled());
			System.out.println(button2.getText());
			button2.click();
			System.out.println(button2.getText());
		}

		return warningButton.isEnabled();
	}
}