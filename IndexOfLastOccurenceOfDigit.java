package selenium.internship;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IndexOfLastOccurenceOfDigit {

	// Function to find the last occurrence of a given number
	// in an integer array
	public int findLastOccurrence(int[] nums, int target) {

		int index = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				index = i;
			}
		}
		return index;
	}

	@Test
	public void test1() {
		int[] a = { 7, 5, 2, 11, 2, 43, 1, 1 };
		Assert.assertEquals(findLastOccurrence(a, 2), 4);
	}

	@Test
	public void test2() {
		int[] a = { 7, 5, 2, 11, 2, 43, 1, 1 };
		Assert.assertEquals(findLastOccurrence(a, 1), 7);
	}

	@Test
	public void test3() {
		int[] a = { 7, 5, 2, 11, 2, 43, 1, 1 };
		Assert.assertEquals(findLastOccurrence(a, 10), -1);
	}

}
