package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.WebDriver_Utility;
 
//Rule 1: Class name same as webpage name
public class VtigerLoginPage 
{
	//Rule 2: Method name same as class name
	public VtigerLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Rule 3: Annotations
	//Element Declaration
	@FindBy(name = "user_name")
	private WebElement UserTextField;
	
	@FindBy(name = "user_password")
	private WebElement PasswordTextField;
	
	@FindBy(id = "submitButton")
	private WebElement LoginButton;

	//Rule 4 : Declare getter methods
	//getter methods
	public WebElement getUserTextField() 
	{
		return UserTextField;
	}
	public WebElement getPasswordTextField() 
	{
		return PasswordTextField;
	}

	public WebElement getLoginButton() 
	{
		return LoginButton;
	}	
	
	//Rule 5 : Business Logics
	/**
	 * This method is used for login to Vtiger Application
	 */
	
	public void loginToVtigerApp(String username, String password)
	{
		UserTextField.sendKeys(username);
		PasswordTextField.sendKeys(password);
		LoginButton.click();
	}	
}
