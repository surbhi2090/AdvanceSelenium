package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage 
{
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title=\"Create Product...\"]")
	private WebElement prodPlusSign;
	
	@FindBy(name = "productname")
	private WebElement productName;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement prodSaveButton;

	//getter methods
	public WebElement getCreateProductLink() {
		return prodPlusSign;
	}

	public WebElement getProductnameLink() {
		return productName;
	}

	public WebElement getProdSaveButton() {
		return prodSaveButton;
	}
	
	/**
	 * This method is used click on plus sign 
	 * @author Mittal
	 */
	public void clickProdPlusSign()
	{
		prodPlusSign.click();
	}
	
	/**
	 * This method is used to enter the product name 
	 * @author Mittal
	 */
	public void enterProductName(String prodName)
	{
		productName.sendKeys(prodName);
	}
	
	/**
	 * This method is used to save the product details
	 * @author Mittal
	 */
	public void clickProdSaveButton()
	{
		prodSaveButton.click();
	}	
}