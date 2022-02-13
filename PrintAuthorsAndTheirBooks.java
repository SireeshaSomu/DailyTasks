package selenium.advanced;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrintAuthorsAndTheirBooks {
	public String printAuthorsAndTheirBooks(String[][] input) {

		String authorAndBooks = "";
		int authorIndex = 1;

		for (int i = 0; i < input.length; i++, authorIndex++) {
			authorAndBooks = authorAndBooks + authorIndex + ". " + input[i][0] + "\n";

			String[] authorBooks = input[i][1].split(" ");
			int booksIndex = 65;
			for (int j = 0; j < authorBooks.length; j++, booksIndex++) {
				authorAndBooks = authorAndBooks + "\t" + (char) booksIndex + ". " + authorBooks[j] + "\n";
			}
		}

		authorAndBooks = authorAndBooks.trim();

		System.out.println(authorAndBooks);

		return authorAndBooks;
	}

	@Test
	public void test1() {
		String[][] authors = { { "ChetanBhagat", "TwoStates Revolution HalfGirlfriend OneIndianGirl" },
				{ "JKRowling", "HarryPotter FantasticBeasts" } };

		String expectedOutput = "1. ChetanBhagat\n\tA. TwoStates\n\tB. Revolution\n\tC. HalfGirlfriend\n\tD. OneIndianGirl\n2. JKRowling\n\tA. HarryPotter\n\tB. FantasticBeasts";
		Assert.assertEquals(printAuthorsAndTheirBooks(authors), expectedOutput);
	}

	@Test
	public void test2() {
		String[][] authors = { { "JeffreyArcher", "OldLove FalseImpression" } };

		String expectedOutput = "1. JeffreyArcher\n\tA. OldLove\n\tB. FalseImpression";
		Assert.assertEquals(printAuthorsAndTheirBooks(authors), expectedOutput);
	}

}
