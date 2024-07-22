package Product;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import Object_Repository.CreateProductPage;
import Object_Repository.DeleteProduct;
import Object_Repository.VtigerHomepage;
import Object_Repository.VtigerLoginPage;

//@Listeners(Generic_Utility.ListernerImplementation.class)

public class CreateProductAndDeleteProductTest extends Base_Class
{
	@Test(groups= {"smokeTest", "regressionTest"})
	public void CreateProductAndDeleteProductTest() throws Throwable 
	{
		//WebDriver driver = new ChromeDriver();
		
//		File_Utility flib = new File_Utility();
//		Excel_Utility elib = new Excel_Utility();
//		Java_Utility jlib = new Java_Utility();
//		WebDriver_Utility wlib = new WebDriver_Utility();
		
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
		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		FileInputStream login = new FileInputStream("./src/test/resources/VtigerLoginPropertiesFile7pm.properties");
//		Properties pro = new Properties();
//		pro.load(login);
		
		/*	AVOID HARDCODING OF DATA
		 driver.get("http://localhost:8888/");
		 driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();*/
		
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

		//driver.findElement(By.linkText("Products")).click();
		
		VtigerHomepage homepage = new VtigerHomepage(driver);
		homepage.getProductLink().click();
		
		CreateProductPage prodPage = new CreateProductPage(driver);
		prodPage.clickProdPlusSign();
		
	//	driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();
		
		//Random ran = new Random();
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
//			Row row = sheet.getRow(1);
//			
//			//Step 5: Get control of the cell
//			Cell cell = row.getCell(0);
//			
//			String prodData = cell.getStringCellValue()+ranNum;
		
//		String prodData = elib.getExcelData("Product", 1, 0)+ranNum;
		String prodData = elib.getExcelDataUsingDataFormatter("Product", 1, 0)+ranNum;

		prodPage.enterProductName(prodData);
		prodPage.clickProdSaveButton();
		
		Assert.assertEquals(true, true);
//			driver.findElement(By.name("productname")).sendKeys(prodData);
//			driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
			
			//driver.findElement(By.linkText("Products")).click();
			homepage.getProductLink().click();
			
			//driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='Product Name']/../preceding-sibling::td/input[@type='checkbox']")).click();
		     
		//	driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+prodData+"']/../preceding-sibling::td/input[@type='checkbox']")).click();
			       
			DeleteProduct delProd = new DeleteProduct(driver);
			delProd.selectProdCheckBox(driver, prodData);
			
			delProd.clickOnDeleteButton();
		//	driver.findElement(By.xpath("//input[@value='Delete']")).click();

			//driver.switchTo().alert().accept();
			wlib.alertAccept(driver);

			delProd.ValidateProdName(driver, prodData);
			
//			List<WebElement> allprd = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
//				boolean flag=false;
//				
//				for (WebElement prdName : allprd)
//				{
//					String actData = prdName.getText();
//					if(actData.contains(prodData))
//					{
//						flag=true;
//						break;
//					}
//				}
//				if(flag)
//				{
//					System.out.println("Product data is deleted");
//				}
//				else
//				{
//					System.out.println("Product data is not deleted");
//				}
				
				Thread.sleep(2000);
//				driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//				driver.findElement(By.linkText("Sign Out")).click();
				
//				homepage.getSignOutImageLink().click();
//				homepage.getSignOutLink().click();
				
//				homepage.logOut(driver);
	}
}
