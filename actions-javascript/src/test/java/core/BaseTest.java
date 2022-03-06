package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	public static WebDriver driver = null;

	@BeforeSuite
	public void initialize() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
			driver = new ChromeDriver();

			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
	}

	public void loadUrl(String url) {
		driver.get(url);
	}

	@AfterSuite
	public void quitBrowser() {
		driver.quit();
	}
}
