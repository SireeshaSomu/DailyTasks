package selenium.internship;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CombinationOfStepsForNthStep {
	public int countWays(int n) {
		int[] res = new int[n + 1];
		res[0] = 1;
		res[1] = 1;
		res[2] = 2;

		for (int i = 3; i <= n; i++)
			res[i] = res[i - 1] + res[i - 2] + res[i - 3];

		System.out.println(res[n]);
		return res[n];
	}

	@Test
	public void test1CountWays() {
		Assert.assertEquals(countWays(4), 7);

	}

	@Test
	public void test2CountWays() {
		Assert.assertEquals(countWays(2), 2);

	}

	@Test
	public void test3CountWays() {
		Assert.assertEquals(countWays(3), 4);

	}

}
