package selenium.internship;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Anagrams {
	public boolean checkAnagrams(String str1, String str2) {
		String s1 = str1.replaceAll("\\s", "");
		String s2 = str2.replaceAll("\\s", "");
		boolean result = false;

		if (s1.length() == s2.length()) {
			char[] array1 = s1.toLowerCase().toCharArray();
			char[] array2 = s2.toLowerCase().toCharArray();
			Arrays.sort(array1);
			Arrays.sort(array2);
			result = Arrays.equals(array1, array2);

		} else
			result = false;

		return result;

	}

	@Test(priority = 0)
	public void positiveTestAnagram() {
		Assert.assertTrue(checkAnagrams("books", "skoob"));

	}

	@Test(priority = 1)
	public void negativeTestAnagram() {
		Assert.assertFalse(checkAnagrams("winter", "inter"));

	}

	@Test(priority = 2)
	public void positiveTestWithWhiteSpaces() {
		Assert.assertTrue(checkAnagrams("Mother In Law", "Hitler Woman"));

	}

}
