
package selenium.advanced;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RearrangingArrayElementsSuchThatAdjacentElementsAreDistinct {
	public String reArrangingAdjacentElements(int[] array) {
		String result = "";

		HashMap<Integer, Integer> MAP = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; ++i) {
			if (MAP.containsKey(array[i])) {
				int x = MAP.get(array[i]) + 1;
				MAP.put(array[i], x);
			} else {
				MAP.put(array[i], 1);
			}
		}

		int maxFreq = 0;
		for (int i = 0; i < array.length; ++i)
			if (maxFreq < MAP.get(array[i]))
				maxFreq = MAP.get(array[i]);
		if (maxFreq > (array.length + 1) / 2) {
			result = "NO";
		} else {
			result = "YES";
		}

		return result;

	}

	@Test
	public void test1Array() {
		int[] arr = { 1, 1, 1, 2, 2 };
		Assert.assertEquals(reArrangingAdjacentElements(arr), "YES");

	}

	@Test
	public void test2Array() {
		int[] arr = { 89, 47, 89, 47, 42, 21 };
		Assert.assertEquals(reArrangingAdjacentElements(arr), "YES");

	}

	@Test
	public void test3Array() {
		int[] arr = { 10, 10, 10, 10, 5 };
		Assert.assertEquals(reArrangingAdjacentElements(arr), "NO");

	}

}
