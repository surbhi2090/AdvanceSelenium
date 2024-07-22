package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.checkerframework.checker.units.qual.t;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx3 
{
	@Test(dataProvider = "getReadData")
	public void createOrganization(String orgName, String phoneNo , String emailId) throws Throwable
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("http://localhost:8888/");
//
//		driver.findElement(By.name("user_name")).sendKeys("admin");
//		driver.findElement(By.name("user_password")).sendKeys("admin");
//		driver.findElement(By.id("submitButton")).click();
		
		FileInputStream login = new FileInputStream("./src/test/resources/VtigerLoginPropertiesFile7pm.properties");
		Properties pro = new Properties();
		pro.load(login);
		
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("[alt='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.name("phone")).sendKeys(phoneNo);
		driver.findElement(By.id("email1")).sendKeys(emailId);
				
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();	
		Thread.sleep(5000);
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getReadData()
	{ 	
		Object[][] objArr = new Object[3][3];
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
		objArr[0][0] = "Apple"+ranNum;
		objArr[0][1] = "9555154844";
		objArr[0][2] = "apple@gmail.com";
		
		objArr[1][0] = "Samsung"+ranNum;
		objArr[1][1] = "9555154844";
		objArr[1][2] = "sumsung@gmail.com";
		
		objArr[2][0] = "OnePlus"+ranNum;
		objArr[2][1] = "9541024744";
		objArr[2][2] = "oneplus@gmail.com";
		
		return objArr;
	}
}
