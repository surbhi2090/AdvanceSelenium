package Generic_Utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListernerImplementation implements ITestListener
{
	public void onTestFailure(ITestResult result) 
	{
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		TakesScreenshot ts = (TakesScreenshot)Base_Class.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/failedScripts"+ranNum+ ".png");
		
		try 
		{
			FileUtils.copyFile(src, dest);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
