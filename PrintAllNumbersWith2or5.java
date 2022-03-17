package selenium.internship;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrintAllNumbersWith2or5 {
	String result = null;

	public void printNumbers(int number) {

		boolean isExpectedDigit = true;

		int temp = number;

		if (number > 0) {

			while (temp > 0 && isExpectedDigit) {

				int digit = temp % 10;

				if (digit != 2 && digit != 5) {
					isExpectedDigit = false;
				}

				temp = temp / 10;
			}

			if (isExpectedDigit) {
				result = result + number + " ";
			}

			printNumbers(number - 1);
		}
	}

	@Test
	public void testcase1() {

		result = new String();
		printNumbers(30);

		Assert.assertEquals(result.trim(), "25 22 5 2");
	}

	@Test
	public void testcase2() {

		result = new String();
		printNumbers(10);

		Assert.assertEquals(result.trim(), "5 2");
	}

	@Test
	public void testcase3() {

		result = new String();
		printNumbers(100);

		Assert.assertEquals(result.trim(), "55 52 25 22 5 2");
	}

}
