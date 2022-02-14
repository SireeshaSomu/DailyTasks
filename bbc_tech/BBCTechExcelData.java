package com.bbc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class BBCTechExcelData {

	private XSSFWorkbook workbook = null;
	private String excelFile = null;

	public BBCTechExcelData(String excelFile) {
		workbook = new XSSFWorkbook();
		this.excelFile = excelFile;
	}

	public boolean createSheetAndWriteTheData(String sheetName, Set<String> inputData) {
		boolean isSuccess = false;

		XSSFSheet sheet = workbook.createSheet(sheetName);

		int rowNum = 0;
		for (Iterator<String> data = inputData.iterator(); data.hasNext(); rowNum++) {
			sheet.createRow(rowNum).createCell(0).setCellValue(data.next());
		}

		try {
			workbook.write(new FileOutputStream(excelFile));

			isSuccess = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

	public boolean closeWorkBook() {
		boolean isSuccess = false;
		if (workbook != null) {
			try {
				workbook.close();
				isSuccess = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return isSuccess;
	}

	public static void main(String[] args) {
		String excelFile = "C:\\Users\\adire\\OneDrive\\Documents\\Siri_Selenium\\excel\\bbc.xlsx";
		BBCTechExcelData writeExcel = new BBCTechExcelData(excelFile);

		Set<String> data = new HashSet<String>();
		data.add("abc");
		data.add("bcd");

		boolean isSuccess = writeExcel.createSheetAndWriteTheData("sheet1", data);

		Assert.assertTrue(isSuccess);
	}

}
