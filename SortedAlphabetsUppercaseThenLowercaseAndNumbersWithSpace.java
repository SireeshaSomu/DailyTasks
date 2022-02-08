package selenium.advanced;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SortedAlphabetsUppercaseThenLowercaseAndNumbersWithSpace {
	public String formattedString(String str) {

		// Remove duplicate characters and numbers
		// find distinct characters and numbers from given string & loop through each
		// char and add to sb(stringbuilder)

		StringBuilder sb = new StringBuilder();
		str.chars().distinct().forEach(c -> sb.append((char) c)); // for each using lamda expression

		// Sort characters and numbers
		char[] chars = sb.toString().toCharArray();
		Arrays.sort(chars);

		str = String.valueOf(chars);

		// Extract numbers and characters as separate
		String numbers = str.replaceAll("[A-Za-z]", "");
		String characters = str.replaceAll("[0-9]", "");

		// Concatenate characters and numbers with space
		str = characters.trim() + " " + numbers.trim();

		System.out.println(str);

		return str;
	}

	@Test
	public void testFormattedString() {
		Assert.assertEquals(formattedString("Show09allBC 1950AD"), "ABCDSahlow 0159");
	}
}
