package selenium.internship;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrintCharsAtPrimeIndices {

	static boolean isPrime(int n) {
		if (n <= 1)
			return false;

		// Check from 2 to n-1
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	public String charsAtPrimeIndices(String str) {

		int n = str.length();

		String result = "";
		for (int i = 2; i < n; i++) {
			if (isPrime(i)) {
				result = result + str.charAt(i);
			}
		}
		return result.trim();
	}

	@Test
	public void test1() {
		Assert.assertEquals(charsAtPrimeIndices("CodingNinjasIsTheBest"), "digissBs");
	}

	@Test
	public void test2() {
		Assert.assertEquals(charsAtPrimeIndices("AmazonGoogleMicrosoftNetflix"), "aznoeisft");
	}
}
