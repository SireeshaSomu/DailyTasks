package selenium.internship;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SortingArrayWithoutComparision {

	static int[] sortArray(int arr[], int n, int min, int max) {

		int range = max - min + 1;
		int[] countFreq = new int[range];
		int[] result = new int[n];

		for (int i = 0; i < n; i++) {
			countFreq[arr[i] - min]++;

		}
		int index = 0;
		for (int i = 0; i < range; i++) {

			for (int j = 0; j < countFreq[i]; j++) {
				result[index] = i + min;
				index++;

			}
		}
		return result;
	}

	@Test
	public void test1() {
		int[] input = { -2, -1, 4, -2, 3 };
		int[] output = { -2, -2, -1, 3, 4 };
		Assert.assertEquals(sortArray(input, input.length, -2, 4), output);
	}

	@Test
	public void test2() {
		int[] input = { 1, 2, 3, -4, -5 };
		int[] output = { -5, -4, 1, 2, 3 };
		Assert.assertEquals(sortArray(input, input.length, -5, 3), output);
	}

}
