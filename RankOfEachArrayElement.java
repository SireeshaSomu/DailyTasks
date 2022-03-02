package selenium.internship;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RankOfEachArrayElement {

	public String rank(int[] input) {

		int newArray[] = Arrays.copyOfRange(input, 0, input.length);

		Arrays.sort(newArray);

		Map<Integer, Integer> ranks = new HashMap<>();

		int rank = 1;

		for (int index = 0; index < newArray.length; index++) {

			int element = newArray[index];

			if (ranks.get(element) == null) {

				ranks.put(element, rank);
				rank++;
			}
		}

		for (int index = 0; index < input.length; index++) {

			input[index] = ranks.get(input[index]);
			System.out.println(input[index]);
		}
		return Arrays.toString(input);

	}

	@Test
	public void testCase1() {
		int[] inputArray = { 100, 2, 70, 2 };

		Assert.assertEquals(rank(inputArray), "[3, 1, 2, 1]");
	}

	@Test
	public void testCase2() {
		int[] inputArray = { 100, 100, 100 };

		Assert.assertEquals(rank(inputArray), "[1, 1, 1]");
	}

	@Test
	public void testCase3() {
		int[] inputArray = { 4, -2 };

		Assert.assertEquals(rank(inputArray), "[2, 1]");
	}
}
