package selenium.advanced;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GreatestCommonDivisorUsingRecursiveMethod {
	public int gcd(int a, int b) {
		if (a == 0) {
			return b;
		} else if (b == 0) {
			return a;
		} else if (a == b) {
			return a;
		} else if (a > b) {
			return gcd(a - b, b);
		}
		return gcd(a, b - a);
	}

	@Test
	public void verifyGCD1() {
		Assert.assertEquals(gcd(20, 15), 5);
	}

	@Test
	public void verifyGCD2() {
		Assert.assertEquals(gcd(8, 32), 8);
	}

	@Test
	public void verifyGCD3() {
		Assert.assertEquals(gcd(98, 56), 14);
	}
}
