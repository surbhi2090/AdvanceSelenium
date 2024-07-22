package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx
{
	@Test
	public void m1()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		Assert.assertEquals(true, false);
		System.out.println("Step 3");
		System.out.println("Step 4");
	}
	
	@Test
	public void m2() 
	{
		String expData = "Surbhi";
		String actData = "Surbhi";
		Assert.assertEquals(expData, actData);
	}
}
