package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtility {

	static Actions actions = null;

	public ActionsUtility(WebDriver driver) {
		actions = new Actions(driver);
	}

	public static void dragAndDrop(WebElement source, WebElement target) {
		actions.dragAndDrop(source, target).build().perform();
	}

	public static void doubleClick(WebElement element) {
		actions.doubleClick(element).build().perform();
	}

	public static void moveToElement(WebElement element) {
		actions.moveToElement(element).build().perform();
	}

	public static void clickAndHold(WebElement element) {
		actions.clickAndHold(element).build().perform();
	}
}