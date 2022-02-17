package selenium.advanced;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GuessTheRandomNumber {
	public String generateRandomNumber(int inputNum) {
		int min = 1, max = 9;
		int range = max - min + 1;
		String message = null;
		int randomNum = (int) (Math.random() * range) + min;

		if (randomNum > inputNum) {
			message = "low";
		} else if (randomNum < inputNum) {
			message = "high";
		} else if (randomNum == inputNum) {
			message = "Right guess";
		}
		System.out.println("random number: " + randomNum + "  Input number: " + inputNum);
		System.out.println(message);
		return message;
	}

	@Test
	public void verifyGuessNumber1() {
		Assert.assertNotNull(generateRandomNumber(5));
	}

	@Test
	public void verifyGuessNumber2() {
		Assert.assertNotNull(generateRandomNumber(6));
	}
}
