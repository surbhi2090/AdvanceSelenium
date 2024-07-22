package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;

public class DataProviderEx4 
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
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		driver.findElement(By.name("accountname")).sendKeys(orgName+ranNum);
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
	public Object[][] getReadData() throws Throwable
	{ 	
		Excel_Utility elib = new Excel_Utility();
		Object[][] values = elib.readDataUsingDataProvider("orgDataProvider");
		return values;
	}
}
