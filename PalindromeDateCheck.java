package selenium.internship;

import org.testng.Assert;
import org.testng.annotations.Test;
//prog to check whether given date is palindrome or not 

public class PalindromeDateCheck {
	public int palindromeDate(int date) {

		int res = 0, rev;
		while (date > 0) {
			rev = date % 10;
			res = (res * 10) + rev;
			date = date / 10;

		}

		return res;
	}

	@Test
	public void verify1PalindromeDate() {
		Assert.assertEquals(palindromeDate(22022022), 22022022);
	}

	@Test
	public void notPalindromeDateTest() {
		Assert.assertEquals(palindromeDate(15092020), 2029051);
	}
}
