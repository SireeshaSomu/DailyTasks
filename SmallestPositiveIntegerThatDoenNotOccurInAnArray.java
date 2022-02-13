package selenium.advanced;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SmallestPositiveIntegerThatDoenNotOccurInAnArray {
	public int smallestPositiveInteger(int[] array) {
		int lowestNum = 1;

		Arrays.sort(array);

		for (int i = 0; i < array.length; i++) {
			if (array[i] == lowestNum) {
				lowestNum++;
			} else if (array[i] > lowestNum) {
				break;
			}

		}
		return lowestNum;
	}

	@Test
	public void test1SmallestPositiveInteger() {
		int[] a = { 1, 3, 6, 4, 1, 2 };
		Assert.assertEquals(smallestPositiveInteger(a), 5);

	}

	@Test
	public void test2SmallestPositiveInteger() {
		int[] a = { 1, 2, 3 };
		Assert.assertEquals(smallestPositiveInteger(a), 4);

	}

	@Test
	public void test3SmallestPositiveInteger() {
		int[] a = { -1, -3 };
		Assert.assertEquals(smallestPositiveInteger(a), 1);

	}

}
