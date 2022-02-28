package selenium.internship.csvFile;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

/**
 * Create and Update CSV files using Open CSV Libraries
 */
public class CSVWith2000Records {

	private String getRandomName(int n) {
		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {
			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	public String getRandomMarks() {

		// initializing min and max values
		int min = 0, max = 100;

		// setting the range between min & max
		int range = max - min + 1;

		// generating random number using java.lang.Math.random() which is a static
		// method and returns a double value. so, type casted to int.
		int randomNum = (int) (Math.random() * range) + min;

		return String.valueOf(randomNum);
	}

	public List<String[]> generateStudentRecords(int noOfrecords) {
		// create a List which contains String array
		List<String[]> records = new ArrayList<String[]>();

		String[] newRecord = null;
		for (int index = 0; index <= noOfrecords; index++) {
			if (index == 0) {
				newRecord = new String[] { "FirstName", "LastName", "Subject1", "Subject2", "Subject3", "Subject4",
						"Subject5" };
			} else {
				newRecord = new String[] { getRandomName(10), getRandomName(5), getRandomMarks(), getRandomMarks(),
						getRandomMarks(), getRandomMarks(), getRandomMarks() };
			}

			records.add(index, newRecord);
		}

		return records;
	}

	public List<String[]> updateStudentRecordsWithAverageMarks(List<String[]> records) {

		List<String[]> updatedRecords = new ArrayList<String[]>();
		String[] updatedRecord = null;
		for (int index = 0; index < records.size(); index++) {
			String[] record = records.get(index);

			// update the header with average marks which is on 0 index
			if (index == 0) {
				updatedRecord = new String[] { record[0], record[1], record[2], record[3], record[4], record[5],
						record[6], "AverageMarks" };

			} else {
				// update all sub marks by parsing String to Integer with average marks starting
				// from index 1
				int subject1 = Integer.parseInt(record[2]);
				int subject2 = Integer.parseInt(record[3]);
				int subject3 = Integer.parseInt(record[4]);
				int subject4 = Integer.parseInt(record[5]);
				int subject5 = Integer.parseInt(record[6]);

				int averageMarks = Math.round((subject1 + subject2 + subject3 + subject4 + subject5) / 5);

				updatedRecord = new String[] { record[0], record[1], record[2], record[3], record[4], record[5],
						record[6], String.valueOf(averageMarks) };
			}

			updatedRecords.add(index, updatedRecord);
		}

		return updatedRecords;
	}

	public boolean writeRecordsToCSV(String filePath, List<String[]> records) {

		boolean isSuccess = false;

		try {
			// create a writer
//			Writer writer = Files.newBufferedWriter(Paths.get(filePath), StandardCharsets.UTF_8);
			Writer writer = Files.newBufferedWriter(Paths.get(filePath));

			// create csv writer
			CSVWriter csvWriter = new CSVWriter(writer);

			// write all records at once
			csvWriter.writeAll(records);

			// close writers
			csvWriter.close();
			writer.close();

			isSuccess = true;

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return isSuccess;
	}

	public List<String[]> readRecordsFromCSV(String filePath) {

		List<String[]> records = new ArrayList<String[]>();

		try {
			// create a reader
//			Reader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8);
			Reader reader = Files.newBufferedReader(Paths.get(filePath));

			// create csv reader
			CSVReader csvReader = new CSVReader(reader);

			// read all records at once
			records = csvReader.readAll();

			// close readers
			csvReader.close();
			reader.close();

		} catch (IOException | CsvException ex) {
			ex.printStackTrace();
		}

		return records;
	}

	@Test(enabled = true)
	public void testToCreateCSVFileWithStudentInformation() {
		String filePath = "C:\\Users\\adire\\eclipse-workspace\\TestNG\\src\\selenium\\internship\\csvFile\\CSVWith2000Records.csv";

		List<String[]> records = generateStudentRecords(2000);
		Assert.assertNotNull(records);
		Assert.assertTrue(records.size() == 2001, "Total records should be 2001 that includes headers");

		boolean isSuccess = writeRecordsToCSV(filePath, records);
		Assert.assertTrue(isSuccess, "Successfully written all records to the CSV file");
	}

	@Test(enabled = true)
	public void testToReadAndUpdateTheCSVFileWithStudentAverageMarks() {
		String filePath = "C:\\Users\\adire\\eclipse-workspace\\TestNG\\src\\selenium\\internship\\csvFile\\CSVWith2000Records.csv";

		List<String[]> records = readRecordsFromCSV(filePath);
		Assert.assertNotNull(records);
		Assert.assertTrue(records.size() == 2001, "Total records should be 2001 that includes headers");

		records = updateStudentRecordsWithAverageMarks(records);
		Assert.assertNotNull(records);
		Assert.assertTrue(records.size() == 2001,
				"Total records should be 2001 that includes headers and new column AverageMarks for each record");

		boolean isSuccess = writeRecordsToCSV(filePath, records);
		Assert.assertTrue(isSuccess, "Successfully updated all records with AverageMarks to the CSV file");
	}
}
