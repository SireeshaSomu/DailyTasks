package pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ActionsUtility;

public class WebmasterActionsPage {

	WebDriver driver = null;
	ActionsUtility actionsUtility = null;

	public WebmasterActionsPage(WebDriver driver) {
		this.driver = driver;
		actionsUtility = new ActionsUtility(driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(id = "draggable")
	WebElement drag;

	@FindBy(id = "droppable")
	WebElement drop;

	@FindBy(xpath = "//div[@id='droppable']//p/b")
	WebElement dropHere;

	@FindBy(id = "double-click")
	WebElement doubleClick;

	@FindBy(xpath = "//button[text()='Hover Over Me First!']")
	WebElement hoverMeFirst;

	@FindBy(xpath = "//button[text()='Hover Over Me Second!']")
	WebElement hoverMeSecond;

	@FindBy(xpath = "//button[text()='Hover Over Me Third!']")
	WebElement hoverMeThird;

	@FindBy(xpath = "//div[@class='dropdown hover']//a[@class='list-alert']")
	WebElement firstLink;

	@FindBy(xpath = "//div[@class='dropdown']//a[@class='list-alert'][1]")
	WebElement secondLink;

	@FindBy(xpath = "//button[text()='Hover Over Me Third!'] //parent::div//div//a[2]")
	WebElement thirdLink;

	@FindBy(id = "click-box")
	WebElement clickHold;

	public String getActionsPageTiltle() {
		return driver.getTitle();
	}

	public String dragAndDrop() {
		ActionsUtility.dragAndDrop(drag, drop);

		return dropHere.getText();
	}

	public String doubleClick() {
		ActionsUtility.doubleClick(doubleClick);

		return doubleClick.getAttribute("class");
	}

	public String mouseOverAndAlerts() {
		String alertsText = null;

		ActionsUtility.moveToElement(hoverMeFirst);
		ActionsUtility.moveToElement(firstLink);
		firstLink.click();
		alertsText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();

		ActionsUtility.moveToElement(hoverMeSecond);
		ActionsUtility.moveToElement(secondLink);
		secondLink.click();
		alertsText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();

		ActionsUtility.moveToElement(hoverMeThird);
		ActionsUtility.moveToElement(thirdLink);
		thirdLink.click();
		alertsText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();

		return alertsText;
	}

	public String clickAndHold() {
		ActionsUtility.clickAndHold(clickHold);

		return clickHold.getText();
	}

}