package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertSingleDataToExcel {

	public static void main(String[] args) throws Throwable 
	{
		//Step 1: Path connection of the physical file
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\ExcelTestData7pm.xlsx");
		
		//Step 2: Keep excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
		
		//Step 3: Get control of the sheet
		Sheet sheet = book.getSheet("Sheet1");
		
		//Step 4: Set Row Number
		Row row = sheet.createRow(4);
		
		//Step 5: Set cell Number
		Cell cell = row.createCell(4);
		
		//Step 6: Set cell value
		cell.setCellValue("Bluetooth1");
		
		//Step 7: Excel Sheet in a write mode
		FileOutputStream fos = new FileOutputStream("./src\\test\\resources\\ExcelTestData7pm.xlsx");
		book.write(fos);
		book.close();
	}

}
