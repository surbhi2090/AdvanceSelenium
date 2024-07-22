package Campaign;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

import Generic_Utility.Base_Class;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import Object_Repository.CampWithProdWindowSwitching;
import Object_Repository.CreateCampaignPage;
import Object_Repository.CreateProductPage;
import Object_Repository.VtigerHomepage;
import Object_Repository.VtigerLoginPage;

//@Listeners(Generic_Utility.ListernerImplementation.class)
                                                                                                                               
public class CreateCampaignWithProductTest extends Base_Class
{
	@Test(groups= "regressionTest")
	public void CreateCampaignWithProductTest() throws Throwable 
	{
		//WebDriver driver = new ChromeDriver();
		//driver.get("http://localhost:8888/");
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		Excel_Utility elib = new Excel_Utility();
//		File_Utility flib = new File_Utility();
//		WebDriver_Utility wlib = new WebDriver_Utility();
//		Java_Utility jlib = new Java_Utility();
		
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
			
//			wlib.maximizingWindow(driver);
//			wlib.implicit_Wait(driver);
		
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

//		driver.findElement(By.linkText("Products")).click();
		
		VtigerHomepage homepage = new VtigerHomepage(driver);
		homepage.getProductLink().click();
		
	//	Assert.fail();
		
		CreateProductPage prodPage = new CreateProductPage(driver);
		prodPage.clickProdPlusSign();
		
	//	driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();
		
		// Random ran = new Random();
		// int ranNum = ran.nextInt(1000);
		
		int ranNum = jlib.getRandomNum();
		 
//		 	//Step 1: Path connection of the physical file
//			FileInputStream fis = new FileInputStream("C:\\Users\\Mittal\\Desktop\\OrgTestData7pm.xlsx");
//			
//			//Step 2: Keep excel file in read mode
//			Workbook book = WorkbookFactory.create(fis);
//			
//			//Step 3: Get control of the sheet
//			Sheet sheet = book.getSheet("Product");
//			
//			//Step 4: Get control of the Row
//			Row row = sheet.getRow(0);
//			
//			//Step 5: Get control of the cell
//			Cell cell = row.getCell(0);
//			
//			String prodData = cell.getStringCellValue()+ranNum;
		
			//String prodData = elib.getExcelData("Product", 0, 0)+ranNum;
			String prodData = elib.getExcelDataUsingDataFormatter("Product", 0, 0)+ranNum;

			prodPage.enterProductName(prodData);
			prodPage.clickProdSaveButton();
		
//			driver.findElement(By.name("productname")).sendKeys(prodData);
//			driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
			
//			driver.findElement(By.xpath("//td[@onmouseover=\"fnvshobjMore(this,'allMenu','');\"]")).click();
			homepage.getMoreLink().click();
			
//			driver.findElement(By.name("Campaigns")).click();
			homepage.getCampaignsLink().click();
			
			CreateCampaignPage campPage = new CreateCampaignPage(driver);
			campPage.clickCampPlusImg();
			
			Assert.assertEquals(true, true);
			
	//		driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();
			
//			//Step1:- Path Connection of the physical File
//			FileInputStream fis1 = new FileInputStream("C:\\Users\\Mittal\\Desktop\\OrgTestData7pm.xlsx");
//
//			        //step2:- keep Excel_File in Read mode
//			         Workbook book1 = WorkbookFactory.create(fis1);
//				
//			         //step3:- get control of the sheet
//			         Sheet sheet1 = book1.getSheet("Campaign");
//			         
//			         //step4:- get control of the Row
//			         Row row1 = sheet1.getRow(0);
//			
//			         //step5:- get control of the Cell
//			         Cell cell1 = row1.getCell(0);
//			         
//			         String campData = cell1.getStringCellValue()+ranNum;
			
			//String campData = elib.getExcelData("Campaign", 0, 0)+ranNum;
			String campData = elib.getExcelDataUsingDataFormatter("Campaign", 0, 0)+ranNum;
         
			campPage.enterCampaignData(campData);
			
//		driver.findElement(By.name("campaignname")).sendKeys(campData);
		
			CampWithProdWindowSwitching winSwitching = new CampWithProdWindowSwitching(driver);
			winSwitching.clickCampPageProdPlusSign();
			
	//	driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();
		
		wlib.windowHandling(driver, "Products&action");
		
//		Use iterator concept for window handling as per standards
//		Set<String> wins = driver.getWindowHandles();
//		
//		Iterator<String> it = wins.iterator();
//		
//		while(it.hasNext())
//		{
//			String win = it.next();
//			driver.switchTo().window(win);
//			String currentTitle = driver.getTitle();
//			
//			if(currentTitle.contains("Products&action"))
//			{
//				break;
//			}
//		}
		
		//Basic selenium approach
	/*	String mainWin = driver.getWindowHandle();//fetches current window ID
		System.out.println(mainWin);//window 1
		
		Set<String> allWin = driver.getWindowHandles();//to fetch all window ID's
		System.out.println(allWin);//window 1 , window 2
		
		for (String win : allWin) 
		{
			if(!mainWin.equals(win))
			{
				driver.switchTo().window(win);
				driver.findElement(By.linkText("HeroCycle")).click();
				driver.switchTo().window(mainWin);
			}
		}    */
		
		winSwitching.enterProdName(prodData);
		winSwitching.clickOnSearchProdName();
		
//		driver.findElement(By.name("search_text")).sendKeys(prodData+ranNum);
//		driver.findElement(By.name("search")).click();
		
		//we hv to make this generic as random number in name can change
		//driver.findElement(By.xpath("//a[text()=\"HeroCycle\"]")).click();
		
		//dynamic xpath
	//	driver.findElement(By.xpath("//a[text()='"+prodData+"']")).click();
		
		winSwitching.prodDynamicElement(driver, prodData);
		
		wlib.windowHandling(driver, "Campaigns&action");
		
//		 Set<String> wins1 = driver.getWindowHandles();
//		    Iterator<String> it1 = wins1.iterator();
//			 while(it1.hasNext())
//		    {
//		    	String win1 = it1.next();
//		    	driver.switchTo().window(win1);
//		    	String currentTitle1 = driver.getTitle();
//		    if(currentTitle1.contains("Campaigns&action"))
//		    {
//		    	break;
//		    }
//		    }
			 
//			 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			campPage.clickCampSaveButton();

			Thread.sleep(2000);
//			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//			driver.findElement(By.linkText("Sign Out")).click();
		
			//driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
			
//			homepage.getSignOutImageLink().click();
//			homepage.getSignOutLink().click();
//			homepage.logOut(driver);
	}
}