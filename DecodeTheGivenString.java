package selenium.advanced;

import java.util.Vector;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DecodeTheGivenString {

	public String decodeString(String s) {

		Vector<Character> st = new Vector<Character>();

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == ']') {
				String temp = "";
				while (st.size() > 0 && st.get(st.size() - 1) != '[') {

					temp = st.get(st.size() - 1) + temp;
					st.remove(st.size() - 1);
				}

				st.remove(st.size() - 1);
				String num = "";

				while (st.size() > 0 && st.get(st.size() - 1) >= 48 && st.get(st.size() - 1) <= 57) {
					num = st.get(st.size() - 1) + num;
					st.remove(st.size() - 1);
				}

				int number = Integer.parseInt(num);
				String repeat = "";
				for (int j = 0; j < number; j++)
					repeat += temp;

				for (int c = 0; c < repeat.length(); c++)
					st.add(repeat.charAt(c));
			}

			else
				st.add(s.charAt(i));
		}
		String res = "";
		while (st.size() > 0) {
			res = st.get(st.size() - 1) + res;
			st.remove(st.size() - 1);
		}
		return res;
	}

	@Test
	public void test1DecodeString() {

		Assert.assertEquals(decodeString("3[a2[bc]]"), "abcbcabcbcabcbc");
	}

	@Test
	public void test2DecodeString() {

		Assert.assertEquals(decodeString("3[a]12[bc]"), "aaabcbcbcbcbcbcbcbcbcbcbcbc");
	}

	@Test
	public void test3DecodeString() {

		Assert.assertEquals(decodeString("a1[b]1[cc]"), "abcc");
	}
}
