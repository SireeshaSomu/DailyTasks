package pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.JavascriptexecutorUtility;

public class WebmasterScrollPage {
	JavascriptexecutorUtility jsExecutorUtility = null;

	public WebmasterScrollPage(WebDriver driver) {
		jsExecutorUtility = new JavascriptexecutorUtility(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "zone1")
	WebElement zone1;

	@FindBy(id = "zone2-entries")
	WebElement zone2;

	@FindBy(id = "zone3-entries")
	WebElement zone3;

	@FindBy(id = "zone4")
	WebElement zone4;

	public String getScrollingPageTitle() {
		return JavascriptexecutorUtility.getTitle();
	}

	public String zone1Check() {
		JavascriptexecutorUtility.scrollIntoView(zone1);
		return zone1.getText();
	}

	public String zone2Check() {
		String zoneText = null;
		JavascriptexecutorUtility.scrollIntoView(zone2);
		zoneText = zone2.getText();

		JavascriptexecutorUtility.scrollIntoView(zone2);
		zoneText = zone2.getText();

		return zoneText;
	}

	public String scrollToEnd() {
		JavascriptexecutorUtility.scrollToEnd();
		return zone4.getAttribute("class");
	}

	public void flashingCheck() {
		JavascriptexecutorUtility.scrollIntoView(zone1);
		JavascriptexecutorUtility.flash(zone1);
	}
}