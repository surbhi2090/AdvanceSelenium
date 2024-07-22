package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx2 
{
	@Test(dataProvider = "getData")
	public void bookTickets(String name, String hometown, int age)
	{
		System.out.println("Employee name "+name+ " from " +hometown+ " , Age = " +age);
	}	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[3][3];
		
		objArr[0][0]="Sonal";
		objArr[0][1]="Goa";
		objArr[0][2]=12;
		
		objArr[1][0]="Nakul";
		objArr[1][1]="Mysore";
		objArr[1][2]=14;
		
		objArr[2][0]="Surbhi";
		objArr[2][1]="Mumbai";
		objArr[2][2]=10;
		
		return objArr;
	}
}
