package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEx 
{//Non static so we will have to do the object creation
	@Test
	public void m1()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(true, false);
		System.out.println("Step 3");
		System.out.println("Step 4");
		soft.assertAll();
	}
	
	@Test
	public void m2() 
	{
		String expData = "Surbhi";
		String actData = "Surbhi";
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(expData, actData);
		soft.assertAll();
	}
}
