package selenium.internship;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DuplicateCharsAndTheirFrequencyInAStringUsingHashMap {

	public HashMap<String, Integer> occurences(String str) {

		HashMap<String, Integer> occurencesMap = new HashMap<String, Integer>();

		for (int i = 0; i < str.length(); i++) {

			if (occurencesMap.get(String.valueOf(str.charAt(i))) == null) {
				occurencesMap.put(String.valueOf(str.charAt(i)), 1);
			} else {
				occurencesMap.put(String.valueOf(str.charAt(i)), occurencesMap.get(String.valueOf(str.charAt(i))) + 1);
			}

		}

		return occurencesMap;

	}

	@Test
	public void testValidateLettersCountFromHashMap() {
		HashMap<String, Integer> occurencesMap = occurences("AABBBCFFDD");

		Assert.assertEquals(occurencesMap.get("A"), Integer.valueOf(2));
		Assert.assertEquals(occurencesMap.get("B"), Integer.valueOf(3));
		Assert.assertEquals(occurencesMap.get("D"), Integer.valueOf(2));
		Assert.assertEquals(occurencesMap.get("F"), Integer.valueOf(2));

	}

}
