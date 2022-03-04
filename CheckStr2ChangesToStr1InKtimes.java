package selenium.internship;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckStr2ChangesToStr1InKtimes {

	public String findCommonChars(String a, String b, int k) {

		String result = "no";
		if (a.length() != b.length()) {
			return result;
		}

		int countOfCommonChars = 0;
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if (a.charAt(i) == b.charAt(j)) {
					countOfCommonChars++;
					break;
				}
			}
		}
		if (a.length() - countOfCommonChars <= k) {
			result = "yes";
		}
		return result;
	}

	@Test
	public void test1() {
		Assert.assertEquals(findCommonChars("coding", "ninjaa", 4), "yes");
	}

	@Test
	public void test2() {
		Assert.assertEquals(findCommonChars("coding", "ninjaa", 3), "no");
	}

	@Test
	public void test3() {
		Assert.assertEquals(findCommonChars("abcde", "bbecb", 1), "no");
	}
}
