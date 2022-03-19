package selenium.internship;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RearrangingWords {

	public String sortingWordsInAscending(String text) {
		String words[] = text.split(" ");
		Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

		StringBuilder sentence = new StringBuilder();
		sentence.append(words[0].substring(0, 1).toUpperCase() + words[0].substring(1));

		for (int i = 1; i < words.length; i++) {
			sentence.append(" " + words[i].toLowerCase());
		}

		return sentence.toString().trim();
	}

	@Test
	public void test1() {
		Assert.assertEquals(sortingWordsInAscending("I am a girl"), "I a am girl");
	}

	@Test
	public void test2() {
		Assert.assertEquals(sortingWordsInAscending("Do you have a knack for coding Hello ninjas"),
				"A do you for have knack hello coding ninjas");
	}

}
