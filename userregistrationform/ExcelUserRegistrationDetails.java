package com.util;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUserRegistrationDetails {

	private Workbook workbook = null;

	public ExcelUserRegistrationDetails(String excelFile) {
		try {
			workbook = WorkbookFactory.create(new File(excelFile));
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String[][] getUserData(String sheet) {

		if (workbook == null) {
			return null;
		}

		Sheet sheet1 = workbook.getSheet(sheet);
		int rows = sheet1.getPhysicalNumberOfRows();
		int cells = 9;
		String[][] userData = new String[rows - 1][cells];

		DataFormatter dataFormatter = new DataFormatter();
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cells; j++) {
				userData[i - 1][j] = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(j));
			}
		}

		return userData;

	}

	public void closeWorkbook() {
		if (workbook != null) {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String excelFile = "C:\\Users\\adire\\OneDrive\\Documents\\Siri_Selenium\\excel\\UserRegistrationFormDetails.xlsx";
		ExcelUserRegistrationDetails excelUserRegistrationDetails = new ExcelUserRegistrationDetails(excelFile);
		String[][] data = excelUserRegistrationDetails.getUserData("UserDetails");
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.println(data[i][j]);
			}

			System.out.println("\n");
		}
	}
}
