package practice;

import org.testng.annotations.Test;

public class TestNGEnabledInvocationCount
{
	@Test(enabled = false)
	public void createContactTest()
	{
		System.out.println("Contact Created");
	}
	
	@Test(invocationCount = 2)
	public void modifyContactTest()
	{
		System.out.println("Contact Modified");
	}
	
	@Test
	public void deleteContactTest()
	{
		System.out.println("Contact Deleted");
	}
}
