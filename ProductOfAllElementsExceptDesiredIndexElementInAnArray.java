package selenium.advanced;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductOfAllElementsExceptDesiredIndexElementInAnArray {

	public int[] productOfAllArrayElementsExceptDesiredIndexElement(int[] inputArray, int length) {
		int leftArray[] = new int[length];
		int rightArray[] = new int[length];
		int productArray[] = new int[length];

		leftArray[0] = 1;

		for (int index = 1; index < length; index++) {
			leftArray[index] = inputArray[index - 1] * leftArray[index - 1];
		}

		rightArray[length - 1] = 1;

		for (int index = length - 2; index >= 0; index--) {
			rightArray[index] = inputArray[index + 1] * rightArray[index + 1];
		}

		for (int index = 0; index < length; index++) {
			productArray[index] = leftArray[index] * rightArray[index];
		}

		return productArray;
	}

	@Test
	public void test1ProductArray() {
		int[] inputArray = { 1, 2, 3, 4, 5 };
		int inputArrayLength = inputArray.length;
		int[] outputArray = { 120, 60, 40, 30, 24 };

		Assert.assertEquals(productOfAllArrayElementsExceptDesiredIndexElement(inputArray, inputArrayLength),
				outputArray);
	}

	@Test
	public void test2ProductArray() {
		int[] inputArray = { 10, 3, 5, 6, 2 };
		int inputArrayLength = inputArray.length;
		int[] outputArray = { 180, 600, 360, 300, 900 };

		Assert.assertEquals(productOfAllArrayElementsExceptDesiredIndexElement(inputArray, inputArrayLength),
				outputArray);
	}

	@Test
	public void test3ProductArray() {
		int[] inputArray = { 12, 20 };
		int inputArrayLength = inputArray.length;
		int[] outputArray = { 20, 12 };

		Assert.assertEquals(productOfAllArrayElementsExceptDesiredIndexElement(inputArray, inputArrayLength),
				outputArray);
	}

}
