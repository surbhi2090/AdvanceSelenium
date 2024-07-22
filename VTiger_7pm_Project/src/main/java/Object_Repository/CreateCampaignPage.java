package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage
{
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Element Declaration
	@FindBy(xpath = "//img[@alt=\"Create Campaign...\"]")
	private WebElement campPlusImg;
	
	@FindBy(name = "campaignname")
	private WebElement campName;	
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement campSaveButton;

	//getter methods
	public WebElement getCampPlusImg() {
		return campPlusImg;
	}

	public WebElement getCampName() {
		return campName;
	}

	public WebElement getCampSaveButton() {
		return campSaveButton;
	}
	
	/**
	 * This method is for clicking campaign plus image
	 * @author Mittal
	 */
	public void clickCampPlusImg()
	{
		campPlusImg.click();
	}
	
	/**
	 * This method is for entering campaign data
	 * @author Mittal
	 */
	public void enterCampaignData(String campaignName)
	{
		campName.sendKeys(campaignName);
	}
	
	/**
	 * This method is for clicking on campaign save button
	 * @author Mittal
	 */
	public void clickCampSaveButton()
	{
		campSaveButton.click();
	}
}