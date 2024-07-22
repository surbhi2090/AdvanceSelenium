package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.collect.Multiset.Entry;

public class InsertDataToExcelUsingMap {

	public static void main(String[] args) throws Throwable 
	{
		//Step 1: path connection of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\Mittal\\Desktop\\InsertDataUsingMap.xlsx");
				
				//Step 2: Keep excel file in read mode
				Workbook book = WorkbookFactory.create(fis);
				
				//Step 3: Get control of the sheet
				Sheet sheet = book.getSheet("Sheet1");
				
				LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
				map.put("10", "Surbhi");
				map.put("20", "Shobha");
				map.put("30", "Sonal");
				map.put("40", "Nakul");
				
				int rowNo = 0;
				for(java.util.Map.Entry<String, String> m : map.entrySet())
				{
					Row row = sheet.createRow(rowNo++);
					row.createCell(0).setCellValue((String)m.getKey());
					row.createCell(1).setCellValue((String)m.getValue());
				}
				
				FileOutputStream fos = new FileOutputStream("C:\\Users\\Mittal\\Desktop\\InsertDataUsingMap.xlsx");
				book.write(fos);
				book.close();
	}
}
