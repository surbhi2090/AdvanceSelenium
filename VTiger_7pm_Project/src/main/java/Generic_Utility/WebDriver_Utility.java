package Generic_Utility;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class WebDriver_Utility 
{
	/**
	 * This method is used to maximize the window
	 * @param driver
	 * @author Mittal
	 */
	public void maximizingWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to wait elements to get loaed in webpage
	 * @param driver
	 * @author Mittal
	 */
	public void implicit_Wait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method is used for Window Switching
	 * @param driver
	 * @param partialValue
	 * @author Mittal
	 */
	public void windowHandling(WebDriver driver, String partialValue)
	{
		Set<String> wins = driver.getWindowHandles();
		
		Iterator<String> it = wins.iterator();
		
		while(it.hasNext())
		{
			String win = it.next();
			driver.switchTo().window(win);
			String currentTitle = driver.getTitle();
			
			if(currentTitle.contains(partialValue))
			{
				break;
			}
		}
	}
	
	/**
	 * This method is used for accepting the alert pop up
	 * @param driver
	 * @author Mittal
	 */
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();	
	}
	
	/**
	 * This method is used for dismissing the alert pop up
	 * @param driver
	 * @author Mittal
	 */
	public void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();	
	}	
	
	public void moveToElement(WebDriver driver, WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	public static String takeScreenShot(WebDriver driver, String screenShotName) throws Throwable
	{
		TakesScreenshot takeScreenShot = (TakesScreenshot)driver; //upcasting
		File src = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShots/" +screenShotName+ ".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}
}
