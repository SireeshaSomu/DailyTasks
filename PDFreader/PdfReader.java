package com.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PdfReader {

	public static String readPdfContent(String filePath) {

		PDDocument doc = null;
		String content = "";
		try {
			File pdfFile = new File(filePath);

			FileInputStream fstream = new FileInputStream(pdfFile);
			BufferedInputStream bf = new BufferedInputStream(fstream);

			doc = PDDocument.load(bf);
			int numberOfPages = doc.getNumberOfPages();
			System.out.println("The total number of pages " + numberOfPages);

			content = new PDFTextStripper().getText(doc);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (doc != null) {
				try {
					doc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return content.trim();
	}

	@Test
	public void validatePDFContent() {
		String pdfFile = "C:\\Users\\adire\\OneDrive\\Documents\\Siri_Selenium\\excel\\SeleniumExcel.pdf";
		String data = PdfReader.readPdfContent(pdfFile);

		Assert.assertEquals(data, "stainless work table");
	}
}
