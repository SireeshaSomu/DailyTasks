package selenium.internship;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NthTermOfGpSeries {
	public int findNthTermOfGp(int n, int a, int r) {

		return (a * (int) (Math.pow(r, n - 1)));
	}

	@Test
	public void test1() {
		Assert.assertEquals(findNthTermOfGp(5, 2, 3), 162);
	}

	@Test
	public void test2() {
		Assert.assertEquals(findNthTermOfGp(5, 3, 3), 243);
	}

}
