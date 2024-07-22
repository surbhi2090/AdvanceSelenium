package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataUsingDataFormatter {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("C:\\\\Users\\\\Mittal\\\\Desktop\\\\ExcelTestData7pm.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sheet = book.getSheet("Sheet1");
		
		Row row = sheet.getRow(1);
		
		Cell cell = row.getCell(1);
		
		DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cell);
		System.out.println(ExcelData);
	}
}
