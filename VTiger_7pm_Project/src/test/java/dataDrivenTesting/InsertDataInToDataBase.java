package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataInToDataBase
{
	public static void main(String[] args) throws Throwable 
	{
			//Step 1: Register/load mysql database
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			//Step 2: get connection to the database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_details", "root", "root");
			
			//Step 3: create sql statement
			Statement state = conn.createStatement();
			String query = "insert into student(first_name,last_name,address)values('Ayman','Ali','Banah'),('Surbhi','Mittal','Gwalior')";
			
			int result = state.executeUpdate(query);
			
			if(result != 1)
			{
				System.out.println("Data is updated");
			}
			else
			{
				System.out.println("Data is not updated");
			}
			conn.close();
	}
}
