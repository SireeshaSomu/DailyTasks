package selenium.advanced;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseRowElementsInATwoDimensionalArray {

	public int[][] reverse(int[][] array, int rowCount, int colCount) {

		for (int i = 0; i < rowCount; i++) {
			int startIndex = 0, endIndex = colCount - 1;
			while (startIndex < endIndex) {
				int temp = array[i][startIndex];
				array[i][startIndex] = array[i][endIndex];
				array[i][endIndex] = temp;

				startIndex++;
				endIndex--;

			}

		}
		return array;

	}

	@Test
	public void test1() {
		int[][] inputArray = new int[][] { { 1, 2 }, { 3, 4 } };
		int[][] outputArray = new int[][] { { 2, 1 }, { 4, 3 } };
		Assert.assertEquals(reverse(inputArray, 2, 2), outputArray);
	}

	@Test
	public void test2() {
		int[][] inputArray = new int[][] { { 4, 6, 8 }, { 3, 7, 9 } };
		int[][] outputArray = new int[][] { { 8, 6, 4 }, { 9, 7, 3 } };
		Assert.assertEquals(reverse(inputArray, 2, 3), outputArray);
	}

	@Test
	public void test3() {
		int[][] inputArray = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		Assert.assertEquals(reverse(inputArray, 3, 3), new int[][] { { 3, 2, 1 }, { 6, 5, 4 }, { 9, 8, 7 } });
	}
}
