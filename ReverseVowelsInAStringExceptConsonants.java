package selenium.internship;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseVowelsInAStringExceptConsonants {

	public String reverseVowels(String str) {

		String vowelsStr = "aeiouAEIOU";

		int firstIndex = 0;
		int lastIndex = str.length() - 1;
		char[] ch = str.toCharArray();

		while (firstIndex < lastIndex) {

			if (!vowelsStr.contains(String.valueOf(str.charAt(firstIndex)))) {
				firstIndex++;
				continue;
			}

			if (!vowelsStr.contains(String.valueOf(str.charAt(lastIndex)))) {
				lastIndex--;
				continue;
			}

			swap(ch, firstIndex, lastIndex);
			firstIndex++;
			lastIndex--;
		}

		return String.valueOf(ch);
	}

	private void swap(char[] ch, int firstIndex, int lastIndex) {

		char tempArray = ch[firstIndex];
		ch[firstIndex] = ch[lastIndex];
		ch[lastIndex] = tempArray;

	}

	@Test
	public void test1ReverseVowels() {
		Assert.assertEquals(reverseVowels("hello"), "holle");
	}

	@Test
	public void test2ReverseVowels() {
		Assert.assertEquals(reverseVowels("InstanceOfJava"), "anstancOefJavI");
	}

	@Test
	public void test3ReverseVowels() {
		Assert.assertEquals(reverseVowels("Selenium"), "Sulineem");
	}

	@Test
	public void test4ReverseVowels() {
		Assert.assertEquals(reverseVowels("AMMA"), "AMMA");
	}

}
