package selenium.internship;

import org.testng.Assert;
import org.testng.annotations.Test;

public class KthDigitFromRightInNToThePowerOfM {

	public int kthDigit(int N, int M, int K) {

		int power = (int) Math.pow(N, M);

		int count = 0;
		while (power > 0 && count < K) {
			int rem = power % 10;
			count++;

			if (count == K)
				return rem;

			power = power / 10;
		}

		return 0;
	}

	@Test
	public void test1KthElement() {
		Assert.assertEquals(kthDigit(5, 2, 1), 5);
	}

	@Test
	public void test2KthElement() {
		Assert.assertEquals(kthDigit(2, 4, 1), 6);
	}
}
