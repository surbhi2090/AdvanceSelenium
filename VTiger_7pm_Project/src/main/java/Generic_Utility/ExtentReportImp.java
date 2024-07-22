package Generic_Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImp implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	public void onTestFailure(ITestResult result) 
	{
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		System.out.println("------ I am taking Screenshot ------");
		String screenShot = null;
		
		try 
		{
			screenShot = WebDriver_Utility.takeScreenShot(Base_Class.sdriver, result.getMethod().getMethodName());
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(screenShot);
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}
	
	public void onTestStart(ITestResult result) 
	{
		test = report.createTest(result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}
	
	public void onStart(ITestContext context)
	{
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentsReportFile/Report" +ranNum+ ".html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("AutomationTesting");
		spark.config().setReportName("Surbhi");
		
		report = new ExtentReports();
		
		report.attachReporter(spark);
		report.setSystemInfo("Platform", "Windows 10");
		report.setSystemInfo("Executed By", "Surbhi");
		report.setSystemInfo("Reviewed By", "Nakul");
	}
	
	public void onFinish(ITestContext context)
	{
		report.flush();
	}
}
