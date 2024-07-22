package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage 
{
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Element Declaration
	@FindBy(css = "[alt='Create Organization...']")
	private WebElement orgPlusImg;
	
	@FindBy(name = "accountname")
	private WebElement orgName;
	
	@FindBy(name = "phone")
	private WebElement phoneNum;
	
	@FindBy(id = "email1")
	private WebElement emailId;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement orgSaveButton;

	//getter methods
	public WebElement getorgPlusImg() {
		return orgPlusImg;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getPhoneNum() {
		return phoneNum;
	}

	public WebElement getEmailId() {
		return emailId;
	}

	public WebElement getorgSaveButton() {
		return orgSaveButton;
	}
	
	/**
	 * This method is for clicking the org plus image
	 * @author Mittal
	 */
	public void clickOrgPlusImg()
	{
		orgPlusImg.click();
	}
	
	/**
	 * This method is for entering the organization data
	 * @author Mittal
	 */
	public void enterOrganizationData(String OrgName, String phoneNo, String email)
	{
		orgName.sendKeys(OrgName);
		phoneNum.sendKeys(phoneNo);
		emailId.sendKeys(email);
	}
	
	/**
	 * This method is for clicking on org save button
	 * @author Mittal
	 */
	public void clickOrgSaveButton()
	{
		orgSaveButton.click();
	}
}
