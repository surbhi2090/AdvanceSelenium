package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertAndReadDataToProperties_File {

	public static void main(String[] args) throws Throwable 
	{
		//Inserting data to properties file
		FileInputStream fis = new FileInputStream("./src/test/resources/InsertPropertiesFileData7pm.properties");
		Properties pro = new Properties();
		pro.load(fis);
		
		pro.setProperty("URL","https://www.saucedemo.com/v1/");
		pro.setProperty("UserName", "standard_user");
		pro.setProperty("Password", "secret_sauce");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/InsertPropertiesFileData7pm.properties");
		pro.store(fos, "CommonData7pm");
		System.out.println("Data Added Successfully");
		
		//.......................................................................................
		//Reading data from properties file
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/InsertPropertiesFileData7pm.properties");
		Properties pro1 = new Properties();
		pro1.load(fis1);
		
		String URL1= pro1.getProperty("URL");
		String USERNAME1= pro1.getProperty("UserName");
		String PASSWORD1 = pro1.getProperty("Password");
		
		driver.get(URL1);
		driver.findElement(By.id("user-name")).sendKeys(USERNAME1);
		driver.findElement(By.id("password")).sendKeys(PASSWORD1);
		driver.findElement(By.id("login-button")).click();
	}
}
