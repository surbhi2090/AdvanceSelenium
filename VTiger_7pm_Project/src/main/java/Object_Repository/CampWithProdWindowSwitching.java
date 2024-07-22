package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampWithProdWindowSwitching 
{
	public CampWithProdWindowSwitching(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt=\"Select\"]")
	private WebElement campPageProdPlusSign;
	
	@FindBy(name = "search_text")
	private WebElement enterProdName;
	
	@FindBy(name = "search")
	private WebElement searchProdName;

	//getter methods
	
	public WebElement getCampPageProdPlusSign() {
		return campPageProdPlusSign;
	}

	public WebElement getEnterProdName() {
		return enterProdName;
	}

	public WebElement getSearchProdName() {
		return searchProdName;
	}
	
	/**
	 * This method is used to click on product plus sign on campaign page
	 * @author Mittal
	 */
	public void clickCampPageProdPlusSign()
	{
		campPageProdPlusSign.click();
	}
	
	/**
	 * This method is used to enter the product data
	 * @author Mittal
	 */
	public void enterProdName(String prodName)
	{
		enterProdName.sendKeys(prodName);
	}
	
	/**
	 * This method is used to search the product name
	 * @author Mittal
	 */
	public void clickOnSearchProdName()
	{
		searchProdName.click();
	}
	
	public void prodDynamicElement(WebDriver driver , String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
	}
}