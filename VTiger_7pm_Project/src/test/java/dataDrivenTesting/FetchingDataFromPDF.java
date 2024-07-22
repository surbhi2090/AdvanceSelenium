package dataDrivenTesting;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchingDataFromPDF {

	public static void main(String[] args) throws Throwable 
	{
		File file = new File("C:\\Users\\Mittal\\Desktop\\accenture Vbanswers.pdf");
		
		PDDocument doc = PDDocument.load(file);
		
		int pages = doc.getNumberOfPages();
		System.out.println(pages);
		
		PDFTextStripper pdfData = new PDFTextStripper();
		//String data = pdfData.getText(doc);
		//System.out.println(data);
		
		//pdfData.setStartPage(4);
		//String pageData = pdfData.getText(doc);
		//System.out.println(pageData);
		
		pdfData.setStartPage(10);
		pdfData.setEndPage(15);
		String pageData = pdfData.getText(doc);
		System.out.println(pageData);
	}

}
