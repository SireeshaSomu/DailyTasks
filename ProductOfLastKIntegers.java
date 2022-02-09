package selenium.advanced;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductOfLastKIntegers {

	public int getProduct(ArrayList<Integer> list, int k) {
		int product = 1;
		for (int i = list.size() - k; i < list.size(); i++) {
			product *= (int) list.get(i);
		}
		return product;

	}

	public String productOfLastKIntegers(int[][] array) {
		String result = "";
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < array.length; i++) {

			if (array[i][0] == 0) {
				list.add(array[i][1]);
			}
			if (array[i][0] == 1) {

				result = result + " " + getProduct(list, array[i][1]);

			}
		}

		return result.trim();

	}

	@Test
	public void testProductofLastnumbers() {
		int[][] array = { { 0, 3 }, { 0, 0 }, { 0, 2 }, { 0, 5 }, { 0, 4 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 0, 8 },
				{ 1, 2 } };
		Assert.assertEquals(productOfLastKIntegers(array), "20 40 0 32");
	}

}
