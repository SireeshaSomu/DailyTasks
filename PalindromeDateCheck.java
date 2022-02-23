package selenium.internship;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;
//prog to check whether given date is palindrome or not 

public class PalindromeDateCheck {

	public boolean isPalindromeDate(LocalDate date) {

		boolean isPalindrome = false;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
		String dateFormatted = date.format(formatter);

		if (dateFormatted.equalsIgnoreCase(new StringBuilder(dateFormatted).reverse().toString())) {
			isPalindrome = true;
		}

		return isPalindrome;
	}

	@Test
	public void verify1PalindromeDate() {
		Assert.assertTrue(isPalindromeDate(LocalDate.of(2022, 2, 22)));
	}

	@Test
	public void notPalindromeDateTest() {
		Assert.assertFalse(isPalindromeDate(LocalDate.of(2020, 9, 15)));
	}
}
