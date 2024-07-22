package practice;

import org.testng.annotations.Test;

public class TestNGTDependsOn 
{
	//If the independent method fails, then the dependent test scripts will be skipped.
	@Test
	public void createContactTest()
	{
		System.out.println("Contact Created");
	}
	
	@Test(dependsOnMethods = "createContactTest")
	public void modifyContactTest()
	{
		System.out.println("Contact Modified");
	}
	
	@Test(dependsOnMethods = "createContactTest")
	public void deleteContactTest()
	{
		System.out.println("Contact Deleted");
	}
}
