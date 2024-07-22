package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingMultipleDataFromExcelSheet {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("C:\\\\Users\\\\Mittal\\\\Desktop\\\\ExcelTestData7pm.xlsx");
		
		//Step2: Keep excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
		
		//Step3: Get control of sheet
		Sheet sheet = book.getSheet("Sheet2");
		
		int rowNum = sheet.getLastRowNum();
		System.out.println(rowNum+1);
		
		for(int i = 0; i<rowNum; i++)
		{
			Row row = sheet.getRow(i);
			for(int j=0; j<row.getLastCellNum();j++)
			{
				Cell cell = row.getCell(j);
				String link = cell.getStringCellValue();
				System.out.println(link);
			}
		}
	}
}
