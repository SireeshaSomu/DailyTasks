package selenium.internship;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SortArrayElementsFirstOddThenEvenInAscendingOrder {

	public int sortingArray(int n, int k) {

		ArrayList<Integer> oddArray = new ArrayList<Integer>();
		ArrayList<Integer> evenArray = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {

			if ((i + 1) % 2 != 0) {
				oddArray.add(i + 1);

			} else
				evenArray.add(i + 1);

		}
		oddArray.addAll(evenArray);
		System.out.println("all sorted elements: " + oddArray.toString());

		return oddArray.get(k - 1);
	}

	@Test
	public void test1() {
		Assert.assertEquals(sortingArray(7, 4), 7);

	}

	@Test
	public void test2() {
		Assert.assertEquals(sortingArray(5, 3), 5);

	}

}
