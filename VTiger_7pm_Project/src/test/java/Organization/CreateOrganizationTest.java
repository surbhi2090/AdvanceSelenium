package Organization;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.Base_Class;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import Object_Repository.CreateOrganizationPage;
import Object_Repository.ValidationAndVerificationPage;
import Object_Repository.VtigerHomepage;
import Object_Repository.VtigerLoginPage;

//@Listeners(Generic_Utility.ListernerImplementation.class)

public class CreateOrganizationTest extends Base_Class {

	//1. Login to vtiger application->click on organizations link->click on create organization 
	//lookup image->Enter organisation name,phone number and email->click on save Btn->verify 
	//whether the organization is created in Organization Information page and Logout from the
	//application
	
	@Test(groups= "smokeTest")
	public void createOrganizationTest() throws Throwable 
	{
		//WebDriver driver = new ChromeDriver();
		//driver.get("http://localhost:8888/");
		
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		WebDriver_Utility wlib = new WebDriver_Utility();
//		File_Utility flib = new File_Utility();
//		Java_Utility jlib = new Java_Utility();
//		Excel_Utility elib = new Excel_Utility();		
		
//		WebDriver driver;
//		String BROWSER = flib.getKeyAndValuePair("browser");
//			
//			if(BROWSER.equalsIgnoreCase("chrome"))
//			{
//				driver = new ChromeDriver();
//			}
//			else
//			{
//				if(BROWSER.equalsIgnoreCase("edge"))
//				{
//					driver = new EdgeDriver();
//				}
//				else
//				{
//					if(BROWSER.equalsIgnoreCase("firefox"))
//					{
//						driver = new FirefoxDriver();
//					}
//					else
//					{
//						driver = new ChromeDriver();
//					}
//				}
//			}
			
//		wlib.maximizingWindow(driver);
//		wlib.implicit_Wait(driver);
		
	/*	driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();*/
		
//		FileInputStream login = new FileInputStream("./src/test/resources/VtigerLoginPropertiesFile7pm.properties");
//		Properties pro = new Properties();
//		pro.load(login);
//		
//		String URL = pro.getProperty("url");
//		String USERNAME = pro.getProperty("username");
//		String PASSWORD = pro.getProperty("password");
		
//		 String URL = flib.getKeyAndValuePair("url");
//		 String USERNAME = flib.getKeyAndValuePair("username");
//		 String PASSWORD = flib.getKeyAndValuePair("password");
//		
//		driver.get(URL);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
//		VtigerLoginPage login = new VtigerLoginPage(driver);
//		login.loginToVtigerApp(USERNAME, PASSWORD);
		
	//	driver.findElement(By.linkText("Organizations")).click();
		
		VtigerHomepage homepage = new VtigerHomepage(driver);
		homepage.getOrganizationsLink().click();
		
		CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
		orgPage.clickOrgPlusImg();
		
	//	driver.findElement(By.cssSelector("[alt='Create Organization...']")).click();
		
		//Random ran = new Random();
		//int ranNum = ran.nextInt(1000);
		
		int ranNum = jlib.getRandomNum();
		
//		//Step 1: Path connection of the physical file
//		FileInputStream fis = new FileInputStream("C:\\Users\\Mittal\\Desktop\\OrgTestData7pm.xlsx");
//		
//		//Step 2: Keep excel file in read mode
//		Workbook book = WorkbookFactory.create(fis);
//		
//		//Step 3: Get control of the sheet
//		Sheet sheet = book.getSheet("Organization");
//		
//		//Step 4: Get control of the Row
//		Row row = sheet.getRow(0);
//		
//		//Step 5: Get control of the cell
//		Cell cell = row.getCell(0);
//		
//		String orgData = cell.getStringCellValue()+ranNum;
		
		//String orgData = elib.getExcelData("Organization", 0, 0);
		
		String orgData = elib.getExcelDataUsingDataFormatter("Organization", 0, 0)+ranNum;
	//	driver.findElement(By.name("accountname")).sendKeys(orgData);
				
		Assert.assertEquals(true, true);
		
		String mobNo = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
	//	driver.findElement(By.name("phone")).sendKeys(mobNo);
		
		String emailID = elib.getExcelDataUsingDataFormatter("Organization", 2, 0);
	//	driver.findElement(By.id("email1")).sendKeys(emailID);
		
		orgPage.enterOrganizationData(orgData, mobNo, emailID);
		orgPage.clickOrgSaveButton();
		
	//	driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
		
		ValidationAndVerificationPage orgValid = new ValidationAndVerificationPage(driver);
		orgValid.orgValidation(driver, orgData);
		
		
//		homepage.getSignOutImageLink().click();
//		homepage.getSignOutLink().click();
		
//		homepage.logOut(driver);
	}

}
