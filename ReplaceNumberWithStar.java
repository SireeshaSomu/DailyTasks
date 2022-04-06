package selenium.internship;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReplaceNumberWithStar {
	public String replace(String str) {

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
				str = str.replace(str.charAt(i), '*');
			}
		}

		return str;

	}

	@Test
	public void test1() {
		Assert.assertEquals(replace("james678"), "james***");
	}

}
