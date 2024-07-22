package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchingDataFromDataBase
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
		String query = "select * from student";
		
		//Step 4: execute query
		ResultSet result = state.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getInt(1)+ "\t" +result.getString(2)+ "\t"+ result.getString(3)+ "\t" + result.getString(4));
		}
		
		//Step 5: close the connection
		conn.close();
	}
}
