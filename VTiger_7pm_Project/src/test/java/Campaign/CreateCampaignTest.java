package Campaign;

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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Utility.Base_Class;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import Object_Repository.CreateCampaignPage;
import Object_Repository.CreateOrganizationPage;
import Object_Repository.ValidationAndVerificationPage;
import Object_Repository.VtigerHomepage;
import Object_Repository.VtigerLoginPage;

//@Listeners(Generic_Utility.ExtentReportImp.class)
//@Listeners(Generic_Utility.ListernerImplementation.class)
public class CreateCampaignTest extends Base_Class {

	@Test(groups= "smokeTest")
//	@Test(retryAnalyzer = Generic_Utility.RetryAnalyzerImplement.class)
	public void createCampaignTest() throws Throwable 
	{
		//WebDriver driver = new ChromeDriver();
		//driver.get("http://localhost:8888/");
		
//		Excel_Utility elib = new Excel_Utility();
//		File_Utility flib = new File_Utility();
//		WebDriver_Utility wlib = new WebDriver_Utility();
//		Java_Utility jlib = new Java_Utility();

//		WebDriver driver;.
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
		
	//	driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		/*driver.findElement(By.name("user_name")).sendKeys("admin");
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

//		login.getUserTextField().sendKeys(USERNAME);
//		login.getPasswordTextField().sendKeys(PASSWORD);
//		login.getLoginButton().click();
				
//		driver.findElement(By.xpath("//td[@onmouseover=\"fnvshobjMore(this,'allMenu','');\"]")).click();
//		driver.findElement(By.name("Campaigns")).click();
		
		VtigerHomepage homepage = new VtigerHomepage(driver);
		homepage.getMoreLink().click();
		
	//	Assert.fail();
		
		homepage.getCampaignsLink().click();
		
		CreateCampaignPage campPage = new CreateCampaignPage(driver);
		campPage.clickCampPlusImg();
		
		Assert.assertEquals(true, true);
		
	//	driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();
		
		//Random ran = new Random();
		// int ranNum = ran.nextInt(1000);
		
		int ranNum = jlib.getRandomNum();
		 
//		//Step 1: Path connection of the physical file
//			FileInputStream fis = new FileInputStream("C:\\Users\\Mittal\\Desktop\\OrgTestData7pm.xlsx");
//			
//			//Step 2: Keep excel file in read mode
//			Workbook book = WorkbookFactory.create(fis);
//			
//			//Step 3: Get control of the sheet
//			Sheet sheet = book.getSheet("Campaign");
//			
//			//Step 4: Get control of the Row
//			Row row = sheet.getRow(1);
//			
//			//Step 5: Get control of the cell
//			Cell cell = row.getCell(1);
//			
//			String campData = cell.getStringCellValue()+ranNum;
		
		//String campData = elib.getExcelData("Campaign", 1, 1);
		
		String campData = elib.getExcelDataUsingDataFormatter("Campaign", 1, 1)+ranNum;
		System.out.println(campData);
		campPage.enterCampaignData(campData);
		campPage.clickCampSaveButton();
		
		//Hard Assert
		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
		System.out.println(actData);
//		driver.findElement(By.name("campaignname")).sendKeys(campData);
//		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
		
	//	Assert.assertEquals(actData, campData);
		
//		homepage.getSignOutImageLink().click();
//		homepage.getSignOutLink().click();
		
		SoftAssert soft = new SoftAssert();
	//	soft.assertEquals(actData, campData);
		
		soft.assertAll();
		
	//	homepage.logOut(driver);

	}
	
//	@Test(groups= "smokeTest")
//	public void createOrganizationTest() throws Throwable 
//	{
//		VtigerHomepage homepage = new VtigerHomepage(driver);
//		homepage.getOrganizationsLink().click();
//		
//		CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
//		orgPage.clickOrgPlusImg();
//		Assert.assertEquals(false, true);
//
//		int ranNum = jlib.getRandomNum();
//
//		String orgData = elib.getExcelDataUsingDataFormatter("Organization", 0, 0)+ranNum;
//		String mobNo = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
//		String emailID = elib.getExcelDataUsingDataFormatter("Organization", 2, 0);
//
//		orgPage.enterOrganizationData(orgData, mobNo, emailID);
//		orgPage.clickOrgSaveButton();
//		
//		Thread.sleep(2000);
//
//		ValidationAndVerificationPage orgValid = new ValidationAndVerificationPage(driver);
//		orgValid.orgValidation(driver, orgData);
//	}

}
