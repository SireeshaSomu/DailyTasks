package selenium.internship;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BeautyOfFrequencies {
	public Integer[] occurancesOfEachInteger(Integer[] numArray) {

		Map<Integer, Integer> occurencesMap = new HashMap<Integer, Integer>();

		for (Integer number : numArray) {
			if (occurencesMap.containsKey(number)) {
				occurencesMap.put(number, occurencesMap.get(number) + 1);
			} else {
				occurencesMap.put(number, 1);
			}
		}

		return occurencesMap.values().toArray(new Integer[0]);
	}

	public int mostOccuringElementValue(Integer[] numArray) {
		Integer[] frequencyOfEachNum = occurancesOfEachInteger(numArray);
		frequencyOfEachNum = occurancesOfEachInteger(frequencyOfEachNum);
		Arrays.sort(frequencyOfEachNum);

		return frequencyOfEachNum[frequencyOfEachNum.length - 1];
	}

	@Test
	public void test1() {
		Assert.assertEquals(mostOccuringElementValue(new Integer[] { 1, 2, 1, 2, 3 }), 2);
	}

	@Test
	public void test2() {
		Assert.assertEquals(mostOccuringElementValue(new Integer[] { 7, 5, 5 }), 1);
	}

}
