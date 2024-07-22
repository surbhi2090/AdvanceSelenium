package Generic_Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v120.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mysql.cj.jdbc.Driver;

import Object_Repository.VtigerHomepage;
import Object_Repository.VtigerLoginPage;

public class Base_Class
{
	public WebDriver driver;
	
	public WebDriver_Utility wlib = new WebDriver_Utility();
	public static WebDriver sdriver;
	public File_Utility flib = new File_Utility();
	public Java_Utility jlib = new Java_Utility();
	public Excel_Utility elib = new Excel_Utility();		
	
	@BeforeSuite(groups= {"smokeTest", "regressionTest"})
	public void BS() throws Throwable
	{
		//Step 1 : Register/ load the mysql database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		System.out.println("Database open");
	}
	
	@BeforeTest(groups= {"smokeTest", "regressionTest"})
	public void BT()
	{
		System.out.println("Parallel execution Started");
	}
	
//	@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest", "regressionTest"})
//	public void BC(String BROWSER) throws Throwable
	public void BC() throws Throwable
	{		
		//reading browser value from cmd line
//		String BROWSER = System.getProperty("browser");
//		System.out.println(BROWSER);
		
		String BROWSER = flib.getKeyAndValuePair("browser");
			
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else
			{
				if(BROWSER.equalsIgnoreCase("edge"))
				{
					driver = new EdgeDriver();
				}
				else
				{
					if(BROWSER.equalsIgnoreCase("firefox"))
					{
						driver = new FirefoxDriver();
					}
					else
					{
						driver = new ChromeDriver();
					}
				}
			}
			sdriver = driver;
		System.out.println("Browser Launched");
	}
	
//	@Parameters({"URL","USERNAME" , "PASSWORD"})
	@BeforeMethod(groups= {"smokeTest", "regressionTest"})
//	public void BM(String URL, String USERNAME , String PASSWORD) throws Throwable
	public void BM() throws Throwable
	{
		wlib.maximizingWindow(driver);
		wlib.implicit_Wait(driver);
		
		 String URL = flib.getKeyAndValuePair("url");
		 String USERNAME = flib.getKeyAndValuePair("username");
		 String PASSWORD = flib.getKeyAndValuePair("password");
		
		//reading url value from cmd line
		//	String URL = System.getProperty("url");
		 
		//reading username value from cmd line
		//	String USERNAME = System.getProperty("username");
			
		//reading password value from cmd line
		//	String PASSWORD = System.getProperty("password");
		 
		driver.get(URL);
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToVtigerApp(USERNAME, PASSWORD);
		
		System.out.println("Login to application");
	}
	
	@AfterMethod(groups= {"smokeTest", "regressionTest"})
	public void AM()
	{
		VtigerHomepage homepage = new VtigerHomepage(driver);
		homepage.logOut(driver);
		System.out.println("Logout from application");
	}
	
	@AfterClass(groups= {"smokeTest", "regressionTest"})
	public void AC()
	{
		driver.close();
		System.out.println("Browser Closed");
	}
	
	@AfterTest(groups= {"smokeTest", "regressionTest"})
	public void AT()
	{
		System.out.println("Parallel execution closed");
	}
	
	@AfterSuite(groups= {"smokeTest", "regressionTest"})
	public void AS() throws Throwable
	{
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_details", "root", "root");
		conn.close();
		System.out.println("Database closed");
	}
}
