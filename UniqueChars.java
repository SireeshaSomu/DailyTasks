package selenium.internship;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UniqueChars {
	public String checkIfStringHasAllUniqueChars(String str) {
		char[] ch = str.toLowerCase().toCharArray();
		String result;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {

				if (ch[i] == ch[j])
					return result = "NO";

			}

		}
		return result = "YES";
	}

	@Test
	public void test1() {
		Assert.assertEquals(checkIfStringHasAllUniqueChars("coding12$%^n  & *injas"), "NO");
	}

	@Test
	public void test2() {
		Assert.assertEquals(checkIfStringHasAllUniqueChars("coding123"), "YES");
	}

	@Test
	public void test3() {
		Assert.assertEquals(checkIfStringHasAllUniqueChars("cod%@ingC"), "NO");
	}

}
