package selenium.advanced;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MinimumPossibleSumOfTwoNumbersInArray {

	public int minimumPossibleSumOf2NumbersFormedByAllDigitsOnceInArray(int[] inputArray) {

		Arrays.sort(inputArray);

		int number1 = 0, number2 = 0;

		for (int index = 0; index < inputArray.length; index++) {
			if (index % 2 == 0) {
				number1 = number1 * 10 + inputArray[index];

			} else {
				number2 = number2 * 10 + inputArray[index];
			}

		}

		return number1 + number2;
	}

	@Test(priority = 0)
	public void testingOne() {
		int[] inputArray = { 2, 5, 7, 1, 3, 8, 4 };
		Assert.assertEquals(minimumPossibleSumOf2NumbersFormedByAllDigitsOnceInArray(inputArray), 1605);
	}

	@Test(priority = 1)
	public void testingWithZero() {
		int[] inputArray = { 2, 5, 7, 1, 3, 0, 4, 9 };
		Assert.assertEquals(minimumPossibleSumOf2NumbersFormedByAllDigitsOnceInArray(inputArray), 1606);
	}

	@Test(priority = 2)
	public void testingWithNegativeNumbers() {
		int[] inputArray = { 2, 5, 7, -1, 3, 8, -4 };
		Assert.assertEquals(minimumPossibleSumOf2NumbersFormedByAllDigitsOnceInArray(inputArray), -3805);
	}

}
