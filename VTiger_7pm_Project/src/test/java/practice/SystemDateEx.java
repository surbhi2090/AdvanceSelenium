package practice;

import java.util.Date;

import Generic_Utility.Java_Utility;

public class SystemDateEx 
{
	public static void main(String[] args) {
		
//		Date date = new Date();
//		String dateAndTime = date.toString();
//		System.out.println(dateAndTime);
//		
//		String YYYY = dateAndTime.split(" ")[5];
//		String DD = dateAndTime.split(" ")[2];
//		
//		int MM = date.getMonth()+1;
//		
//		String FinalFormat = YYYY +"-"+MM+"-"+DD;
//		System.out.println(FinalFormat); 
		
		Java_Utility jlib = new Java_Utility();
		jlib.getSystemDateWithFormat();
		
		jlib.getSystemDateAndTime();
	}
}
