package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 
{
	@Test(dataProvider = "getData")
	public void bookTickets(String src, String dest, int numOfPpl)
	{
		System.out.println("Book tickets from "+src+ " to " +dest+ " , No. of person = " +numOfPpl);
	}	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[3][3];
		
		objArr[0][0]="Bangalore";
		objArr[0][1]="Goa";
		objArr[0][2]=2;
		
		objArr[1][0]="Bangalore";
		objArr[1][1]="Mysore";
		objArr[1][2]=4;
		
		objArr[2][0]="Bangalore";
		objArr[2][1]="Mumbai";
		objArr[2][2]=3;
		
		return objArr;
	}
}
