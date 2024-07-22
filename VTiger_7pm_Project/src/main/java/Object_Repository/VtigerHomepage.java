package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.WebDriver_Utility;

public class VtigerHomepage 
{
	public VtigerHomepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Element Declaration
	@FindBy(linkText = "Products")
	private WebElement ProductLink;
	
//	@FindBy(xpath = "//td[@onmouseover=\\\"fnvshobjMore(this,'allMenu','');\\\"]")
	@FindBy(linkText = "More")
	private WebElement MoreLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLink;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement SignOutImageLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLink;
	
	@FindBy(name = "Campaigns")
	private WebElement CampaignsLink;
	
	//getter method
	public WebElement getProductLink() {
		return ProductLink;
	}

	public WebElement getMoreLink() {
		return MoreLink;
	}

	public WebElement getCampaignsLink()
	{
		return CampaignsLink;
	}
	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}

	public WebElement getSignOutImageLink() {
		return SignOutImageLink;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}
	
	/**
	 * This method is used for Organization link
	 */
	public void OrgLink()
	{
		OrganizationsLink.click();
	}
	
	/**
	 * This method is for Product Link
	 */
	public void ProductLink()
	{
		ProductLink.click();
	}
	
	/**
	 * This method is for More Link
	 */
	public void MoreLink()
	{
		MoreLink.click();
	}
	
	/**
	 * This method is for campaign Link
	 */
	public void CampaignsLink()
	{
		CampaignsLink.click();
	}
	
	/**
	 * This method is for SignOutImage Link
	 */
	public void SignOutImageLink()
	{
		SignOutImageLink.click();
	}
	
	/**
	 * This method is for SignOut Link
	 */
	public void SignOutLink()
	{
		SignOutLink.click();
	}
	
	/**
	 * This method is for SignOut Link
	 */
	public void logOut(WebDriver driver)
	{
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.moveToElement(driver, SignOutImageLink);
		SignOutLink.click();
	}
}
