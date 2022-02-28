package selenium.internship;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CountCharsNumbersWhiteSpacesInAString {
	public String count(String str) {
		int lower = 0, number = 0, whitespaces = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 'a' && ch <= 'z')
				lower++;
			else if (ch >= '0' && ch <= '9')
				number++;
			else if (ch == ' ' || ch == '\t' || ch == '\n')
				whitespaces++;
		}

		return String.valueOf(lower) + " " + String.valueOf(number) + " " + String.valueOf(whitespaces);
	}

	@Test
	public void test1Count() {
		Assert.assertEquals(count("abc ef4 5$"), "5 2 2");
	}

	@Test
	public void test2Count() {
		Assert.assertTrue(count("390a\t\t 4cbef\n z$").equals("6 4 5"));
	}

}