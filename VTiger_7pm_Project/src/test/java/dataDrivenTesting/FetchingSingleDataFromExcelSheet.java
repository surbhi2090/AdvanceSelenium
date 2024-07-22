package dataDrivenTesting;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingSingleDataFromExcelSheet {

	public static void main(String[] args) throws Throwable
	{
		//Step 1: Path connection of the physical file
				FileInputStream fis = new FileInputStream("C:\\Users\\Mittal\\Desktop\\ExcelTestData7pm.xlsx");
				
				//Step 2: Keep excel file in read mode
				Workbook book = WorkbookFactory.create(fis);
				
				//Step 3: Get control of the sheet
				Sheet sheet = book.getSheet("Sheet1");
				
				//Step 4: Get control of the Row
				Row row = sheet.getRow(1);
				
				//Step 5: Get control of the cell
				Cell cell = row.getCell(1);
				
				String ExcelData = cell.getStringCellValue();
				System.out.println(ExcelData);
				//double ExcelData1 = cell.getNumericCellValue();
				//System.out.println(ExcelData1);
	}

}
