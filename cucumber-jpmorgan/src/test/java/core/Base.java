package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//singleton architechture

public class Base {
	private static Base base;
	private WebDriver driver;

	private Base() {
		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public static Base getInstance() {
		if (base == null) {
			base = new Base();
		}

		return base;
	}

	public WebDriver getDriver() {
		return driver;
	}
}
