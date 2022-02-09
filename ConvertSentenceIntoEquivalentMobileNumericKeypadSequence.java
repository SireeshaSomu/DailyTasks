package selenium.advanced;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConvertSentenceIntoEquivalentMobileNumericKeypadSequence {

	public String sentenceIntoMobileKeypadSequence(String[] mobileKeypadNumbers, String inputStr) {

		String output = "";
		inputStr = inputStr.toLowerCase();

		for (int i = 0; i < inputStr.length(); i++) {
			// Checking for space
			if (inputStr.charAt(i) == ' ')
				output = output + "0";

			else {
				// Calculating index for each
				// character
				int position = inputStr.charAt(i) - 'a';
				output = output + mobileKeypadNumbers[position];

			}
		}

		// Output sequence
		return output;
	}

	// Driver Function
	@Test(priority = 0)
	public void testWithLowercaseInputSentenceIntoMobileKeypadSequence() {
		// storing the sequence in array
		String[] mobileKeypadNumbers = { "2", "22", "222", "3", "33", "333", "4", "44", "444", "5", "55", "555", "6",
				"66", "666", "7", "77", "777", "7777", "8", "88", "888", "9", "99", "999", "9999" };

		String inputStr = "codingninjas";
		Assert.assertEquals(sentenceIntoMobileKeypadSequence(mobileKeypadNumbers, inputStr),
				"22266634446646644466527777");
	}

	@Test(priority = 1)
	public void testWithUppercaseInputSentenceIntoMobileKeypadSequence() {
		// storing the sequence in array
		String[] mobileKeypadNumbers = { "2", "22", "222", "3", "33", "333", "4", "44", "444", "5", "55", "555", "6",
				"66", "666", "7", "77", "777", "7777", "8", "88", "888", "9", "99", "999", "9999" };

		String inputStr = "CODINGNINJAS";
		Assert.assertEquals(sentenceIntoMobileKeypadSequence(mobileKeypadNumbers, inputStr),
				"22266634446646644466527777");
	}

	@Test(priority = 2)
	public void testWithMixedInputSentenceIntoMobileKeypadSequence() {
		// storing the sequence in array
		String[] mobileKeypadNumbers = { "2", "22", "222", "3", "33", "333", "4", "44", "444", "5", "55", "555", "6",
				"66", "666", "7", "77", "777", "7777", "8", "88", "888", "9", "99", "999", "9999" };

		String inputStr = "CodiNgNinJas";
		Assert.assertEquals(sentenceIntoMobileKeypadSequence(mobileKeypadNumbers, inputStr),
				"22266634446646644466527777");
	}

	@Test(priority = 3)
	public void testWithSinglecharInputSentenceIntoMobileKeypadSequence() {
		// storing the sequence in array
		String[] mobileKeypadNumbers = { "2", "22", "222", "3", "33", "333", "4", "44", "444", "5", "55", "555", "6",
				"66", "666", "7", "77", "777", "7777", "8", "88", "888", "9", "99", "999", "9999" };

		String inputStr = "f";
		Assert.assertEquals(sentenceIntoMobileKeypadSequence(mobileKeypadNumbers, inputStr), "333");
	}
}
