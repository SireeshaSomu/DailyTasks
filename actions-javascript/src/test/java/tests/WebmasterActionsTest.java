package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import core.BaseTest;
import pf.WebmasterActionsPage;

public class WebmasterActionsTest extends BaseTest {

	WebmasterActionsPage webActionsPage = null;

	@BeforeClass
	public void setUp() {
		String url = "https://webdriveruniversity.com/Actions/index.html";
		loadUrl(url);
		webActionsPage = new WebmasterActionsPage(driver);
	}

	@Test(priority = 0)
	public void validateActionsPageTitle() {
		Assert.assertEquals(webActionsPage.getActionsPageTiltle(), "WebDriver | Actions");
	}

	@Test(priority = 1)
	public void validateDragAndDrop() {
		String afterDragAndDrop = webActionsPage.dragAndDrop();
		Assert.assertEquals(afterDragAndDrop, "Dropped!");
	}

	@Test(priority = 2)
	public void validateDoubleClick() {
		String afterDoubleClick = webActionsPage.doubleClick();
		Assert.assertEquals(afterDoubleClick, "div-double-click double");
	}

	@Test(priority = 3)
	public void validateMouseOvers() {
		String alertText = webActionsPage.mouseOverAndAlerts();
		Assert.assertEquals(alertText, "Well done you clicked on the link!");
	}

	@Test(priority = 4)
	public void validateClickAndHold() {
		String afterClickAndHold = webActionsPage.clickAndHold();
		Assert.assertEquals(afterClickAndHold, "Well done! keep holding that click now.....");
	}
}