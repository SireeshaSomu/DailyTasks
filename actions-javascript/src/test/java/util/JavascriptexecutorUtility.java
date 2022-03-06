package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptexecutorUtility {
	public static JavascriptExecutor javaScriptExecutor = null;

	public JavascriptexecutorUtility(WebDriver driver) {
		javaScriptExecutor = (JavascriptExecutor) driver;
	}

	public static String getTitle() {
		return javaScriptExecutor.executeScript("return document.title;").toString();
	}

	public static void backgroundColor(String color, WebElement element) {

		javaScriptExecutor.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		TimeoutUtil.waitSeconds(3);
	}

	public static void flash(WebElement webElement) {
		String bgcolor = webElement.getCssValue("backgroundColor");
		for (int i = 0; i < 30; i++) {
			backgroundColor("#000000", webElement);
			backgroundColor(bgcolor, webElement);
		}
	}

	public static void scrollIntoView(WebElement element) {
		javaScriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static void scrollToEnd() {
		javaScriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
}