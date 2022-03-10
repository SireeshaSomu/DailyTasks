package selenium.internship;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseStringExceptSpecialChars {

	public String reverse(String str) {

		char[] ch = str.toCharArray();
		int i = 0, length = str.length() - 1;
		while (i < length) {
			char firstCh = str.charAt(i);
			char lastCh = str.charAt(length);

			if (!isAlphabet(firstCh)) {
				i++;
			} else if (!isAlphabet(lastCh)) {
				length--;
			} else {
				char temp = ch[i];
				ch[i] = ch[length];
				ch[length] = temp;
				i++;
				length--;
			}
		}

		return String.copyValueOf(ch);
	}

	private static boolean isAlphabet(char ch) {
		if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
			return true;
		}

		return false;
	}

	@Test
	public void test1() {
		Assert.assertEquals(reverse("$aggh#hjjjn$"), "$njjj#hhgga$");
	}

	@Test
	public void test2() {
		Assert.assertEquals(reverse("$,bghn lkjh/.tuv"), "$,vuth jkln/.hgb");
	}

}
