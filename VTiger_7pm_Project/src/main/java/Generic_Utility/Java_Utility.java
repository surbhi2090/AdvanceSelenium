package Generic_Utility;

import java.util.Date;
import java.util.Random;

public class Java_Utility 
{
	/**
	 * This method is used to avoid Duplicates
	 * @return
	 * @author Mittal
	 */
	//first push
	//hello
	public int getRandomNum()
	{
		Random ran= new Random();
		int ranNum = ran.nextInt();
		return ranNum;
	}
	
	/**
	 * This method is used to get Date and Time in IST Format
	 * @return
	 * @author Mittal
	 */
	public String getSystemDateAndTime()
	{
		Date date = new Date();
		String dateAndTime = date.toString();
		System.out.println(dateAndTime);
		return dateAndTime;
	}
	
	/**
	 * This method is used to get Date in YYYY-MM-DD Format
	 * @return
	 * @author Mittal
	 */
	public String getSystemDateWithFormat()
	{
		Date date = new Date();
		String dateAndTime = date.toString();
		System.out.println(dateAndTime);
		
		String YYYY = dateAndTime.split(" ")[5];
		String DD = dateAndTime.split(" ")[2];
		
		int MM = date.getMonth()+1;
		
		String FinalFormat = YYYY +"-"+MM+"-"+DD;
		System.out.println(FinalFormat);
		return FinalFormat;
	}
}
