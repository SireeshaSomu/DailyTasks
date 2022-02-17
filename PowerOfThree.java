package selenium.advanced;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PowerOfThree {
	public int checkTheNumberIsPowerOf3(int number) {
		if (number <= 0)
			return 0;
		if (number == 1)
			return 1;
		if (number % 3 == 0)
			return checkTheNumberIsPowerOf3(number / 3);

		return 0;

	}

	@Test
	public void powerOf3Testcase1() {
		Assert.assertEquals(checkTheNumberIsPowerOf3(81), 1);

	}

	@Test
	public void powerOf3Testcase2() {
		Assert.assertEquals(checkTheNumberIsPowerOf3(6), 0);

	}

	@Test
	public void powerOf3Testcase3() {
		Assert.assertEquals(checkTheNumberIsPowerOf3(27), 1);

	}

	@Test
	public void powerOf3Testcase4() {
		Assert.assertEquals(checkTheNumberIsPowerOf3(4), 0);

	}

}
