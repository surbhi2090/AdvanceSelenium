package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertMultipleDataToExcelSheet {

	public static void main(String[] args) throws Throwable
	{
		//Step 1: Path connection of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\Mittal\\Desktop\\ExcelTestData7pm.xlsx");
		
		//Step 2: Keep excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
		
		//Step 3: Get control of the sheet
		Sheet sheet = book.getSheet("Sheet2");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		
		 List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		 int count =0;
		 for(int i=0; i<allLinks.size(); i++)
		 {
			 Row row = sheet.createRow(i);
			 Cell cell = row.createCell(0);
			 cell.setCellValue(allLinks.get(i).getAttribute("href"));
			 String ExcelData = cell.getStringCellValue();
			 System.out.println(ExcelData);
		     count++;
		 }
		 System.out.println();
		 System.out.println("Total no of links= "+count);
		 
		 FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\Mittal\\\\Desktop\\\\ExcelTestData7pm.xlsx");
		book.write(fos);
		book.close();
	}

}
