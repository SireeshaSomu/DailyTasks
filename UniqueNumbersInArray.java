package selenium.internship;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UniqueNumbersInArray {
	public int uniqueDigit(int[] input) {
		int unique = 0;
		for (int i = 0; i < input.length; i++) {
			boolean isItDuplicateDigit = false;
			for (int j = 0; j < input.length; j++) {
				if ((i != j) && (input[i] == input[j])) {
					isItDuplicateDigit = true;
					break;
				}
			}

			if (!isItDuplicateDigit) {
				unique = input[i];
			}
		}
		return unique;
	}

	@Test
	public void test1() {
		int[] a = { 2, 2, 3, 1, 4, 4, 3 };
		Assert.assertEquals(uniqueDigit(a), 1);
	}

	@Test
	public void test2() {
		int[] a = { 5, 6, 9, 6, 1, 9, 1, 5, 3 };
		Assert.assertEquals(uniqueDigit(a), 3);
	}

}
