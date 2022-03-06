package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import core.BaseTest;
import pf.WebmasterScrollPage;

public class WebmasterScrollTest extends BaseTest {

	WebmasterScrollPage webScrollingPage = null;

	@BeforeClass
	public void setUp() {
		String url = "https://webdriveruniversity.com/Scrolling/index.html";
		loadUrl(url);
		webScrollingPage = new WebmasterScrollPage(driver);
	}

	@Test(priority = 0)
	public void validateActionsPageTitle() {
		Assert.assertEquals(webScrollingPage.getScrollingPageTitle(), "WebDriver | Scrolling");
	}

	@Test(priority = 1)
	public void validateScrollToMeFirst() {
		Assert.assertEquals(webScrollingPage.zone1Check(), "Scroll to me first!");
	}

	@Test(priority = 2)
	public void validateEntries() {
		String zoneText = webScrollingPage.zone2Check();
		Assert.assertEquals(zoneText, "0 Entries");
	}

	@Test(priority = 3)
	public void verifyScrollToEle() {
		Assert.assertEquals(webScrollingPage.scrollToEnd(), "thumbnail");
	}

	@Test(priority = 4)
	public void verifyFlash() {
		webScrollingPage.flashingCheck();
	}

}