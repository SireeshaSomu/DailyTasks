package selenium.internship;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Factorial {
	public int factorialAndModulo(int num, int modulo) {
		int result = 1;
		for (int i = 1; i <= num; i++) {
			result = result * i;

		}
		result = result % modulo;

		return result;
	}

	@Test
	public void test1() {
		Assert.assertEquals(factorialAndModulo(5, 3), 0);
	}

	@Test
	public void test2() {
		Assert.assertEquals(factorialAndModulo(4, 5), 4);
	}

}
