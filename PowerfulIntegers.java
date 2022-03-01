package selenium.internship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PowerfulIntegers {

	public List<Integer> allPowerfulIntegers(int x, int y, int bound) {

		Set<Integer> ans = new HashSet<>();
		for (int i = 1; i < bound; i *= x) {
			for (int j = 1; i + j <= bound; j *= y) {
				ans.add(i + j);
				if (y == 1)
					break;
			}
			if (x == 1)
				break;
		}

		ArrayList<Integer> list = new ArrayList<Integer>(ans);
		Collections.sort(list);
		return list;
	}

	@Test
	public void test1PowerfulIntegers() {
		List<Integer> output = allPowerfulIntegers(3, 5, 15);
		Assert.assertEquals(output.toString(), "[2, 4, 6, 8, 10, 14]");

	}

	@Test
	public void test2PowerfulIntegers() {
		List<Integer> output = allPowerfulIntegers(4, 3, 20);
		Assert.assertEquals(output.toString(), "[2, 4, 5, 7, 10, 13, 17, 19]");

	}
}
