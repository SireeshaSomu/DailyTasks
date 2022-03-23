package selenium.internship;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SumOfTwoNumsGivenAsStrings {
	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int result = 0;

		for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || result > 0; i--, j--) {
			int digit1 = i < 0 ? 0 : num1.charAt(i) - '0';
			int digit2 = j < 0 ? 0 : num2.charAt(j) - '0';
			sb.append((digit1 + digit2 + result) % 10);
			result = (digit1 + digit2 + result) / 10;
		}

		return sb.reverse().toString();
	}

	@Test
	public void test1() {
		Assert.assertEquals(addStrings("10", "9"), "19");
	}

	@Test
	public void test2() {
		Assert.assertEquals(addStrings("5", "21"), "26");
	}

}
