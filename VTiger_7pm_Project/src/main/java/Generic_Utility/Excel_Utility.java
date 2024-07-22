package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility 
{
	/**
	 * This method is used to fetch sheetName, RowNum and CellNum from the excel file
	 * @param sheetName
	 * @param RowNum
	 * @param CellNum
	 * @return
	 * @throws Throwable
	 * @author Mittal
	 */
	public String getExcelData(String sheetName, int RowNum, int CellNum) throws Throwable
	{
		//Step 1: Path connection of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\Mittal\\Desktop\\OrgTestData7pm.xlsx");
		
		//Step 2: Keep excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
		
		//Step 3: Get control of the sheet
		Sheet sheet = book.getSheet(sheetName);
		
		//Step 4: Get control of the Row
		Row row = sheet.getRow(RowNum);
		
		//Step 5: Get control of the cell
		Cell cell = row.getCell(CellNum);
		
		String ExcelData = cell.getStringCellValue();
		return ExcelData;		
	}
	
	/**
	 * Read single data using dataformatter
	 * @param sheetName
	 * @param RowNum
	 * @param CellNum
	 * @return
	 * @throws Throwable
	 * @author Mittal
	 */
	public String getExcelDataUsingDataFormatter(String sheetName, int RowNum, int CellNum) throws Throwable
	{
		//Step 1: Path connection of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\Mittal\\Desktop\\OrgTestData7pm.xlsx");
		
		//Step 2: Keep excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
		
		//Step 3: Get control of the sheet
		Sheet sheet = book.getSheet(sheetName);
		
		//Step 4: Get control of the Row
		Row row = sheet.getRow(RowNum);
		
		//Step 5: Get control of the cell
		Cell cell = row.getCell(CellNum);
		
		DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cell);
		return ExcelData;
	}
	
	/**
	 * This method is used to read org data from excel sheet using data provider
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 * @author Mittal
	 */
	public Object[][] readDataUsingDataProvider(String sheetName) throws Throwable
	{ 	
		//Step 1: Path connection of the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/OrgTestData7pm.xlsx");
		
		//Step 2: Keep excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
		
		//Step 3: Get control of the sheet
		Sheet sheet = book.getSheet(sheetName);
		
		//Step 4: Get control of the Row
		int lastRow = sheet.getLastRowNum()+1;
		short lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] objArr = new Object[lastRow][lastCell];
		
		for( int i = 0; i <lastRow; i++)
		{
			for(int j = 0; j<lastCell; j++)
			{
				objArr[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return objArr;
	}
}
