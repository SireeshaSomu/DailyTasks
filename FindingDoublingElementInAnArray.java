package selenium.internship;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FindingDoublingElementInAnArray {
	public boolean methodToCheckIfDoubleElementExistsInArray(int[] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i != j) && array[j] == array[i] * 2) {
					return true;

				}
			}

		}

		return false;

	}

	@Test
	public void test1DoubleElement() {
		int[] array1 = { 2, 5, 7, 4, 9 };
		Assert.assertEquals(methodToCheckIfDoubleElementExistsInArray(array1), true);
	}

	@Test
	public void test2DoubleElement() {
		int[] array1 = { 6, 13, 8, 5 };
		Assert.assertEquals(methodToCheckIfDoubleElementExistsInArray(array1), false);
	}

	@Test
	public void test3DoubleElement() {
		int[] array1 = { 4, 9, 2, 1, 7 };
		Assert.assertEquals(methodToCheckIfDoubleElementExistsInArray(array1), true);
	}

}
