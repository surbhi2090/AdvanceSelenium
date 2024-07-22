package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PhoneNameAndPrice 
{
	public static void main(String[] args) throws Throwable
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//input[@title=\"Search for Products, Brands and More\"]")).sendKeys("iphone");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        
        List<WebElement> iPhoneList= driver.findElements(By.xpath("//div[@class=\\\"KzDlHZ\\\"]"));
        List<WebElement> iPhonePrice = driver.findElements(By.xpath("//div[@class=\"KzDlHZ\"]/parent::div/following-sibling::div/child::div//div[@class=\"hl05eU\"]"));
		 		
		int count=0;
		//for(WebElement List: iPhoneList)
		for(int i = 0; i<iPhoneList.size(); i++)
		{
	//		System.out.println("IPhone name: " +List.getText() + "\n IPhone Price: " +iPhonePrice.get(count).getText());
			System.out.println(iPhoneList.get(i).getText()+ "----------------" +iPhonePrice.get(i).getText());
			count++;
		}
		
		System.out.println("Total no of iPhone = "+count);
		Thread.sleep(1000);
		driver.close();
	}
}
