package selenium.internship;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PermutationOfStr1InSubstringOfStr2 {
	List<String> allPermutations;

	public void allPermutations(String str1, String permutations) {

		if (str1.length() == 0) {
			allPermutations.add(permutations);
		}
		for (int i = 0; i < str1.length(); i++) {
			char ch = str1.charAt(i);
			String leftSubstr = str1.substring(0, i);
			String rightSubstr = str1.substring(i + 1);
			String remainingstr = leftSubstr + rightSubstr;

			allPermutations(remainingstr, permutations + ch);
		}
	}

	public List<String> allSubStrings(String str2) {
		List<String> allSubStrings = new ArrayList<String>();
		for (int i = 0; i < str2.length(); i++) {
			for (int j = i + 1; j <= str2.length(); j++) {
				allSubStrings.add(str2.substring(i, j));
			}
		}

		return allSubStrings;
	}

	public boolean checkStr1IsTheSubStringOfStr2(String str1, String str2) {
		allPermutations = new ArrayList<String>();
		allPermutations(str1, "");
		List<String> allSubStrings = allSubStrings(str2);
		for (String s : allPermutations) {
			if (allSubStrings.contains(s)) {
				return true;
			}
		}
		return false;
	}

	@Test
	public void test1() {
		Assert.assertEquals(checkStr1IsTheSubStringOfStr2("ab", "aoba"), true);
	}

	@Test
	public void test2() {
		Assert.assertEquals(checkStr1IsTheSubStringOfStr2("ab", "ebbao"), true);
	}

	@Test
	public void test3() {
		Assert.assertEquals(checkStr1IsTheSubStringOfStr2("b", "acd"), false);
	}

}
