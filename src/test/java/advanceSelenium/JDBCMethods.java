package advanceSelenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCMethods {
	public static void ReadDataFromSql() throws SQLException
	{
		//Step1: create an instance for JDBC driver
		// driver should be imported from com.mysql.cj.jdbc.driver
		//new Driver() throws SQLExeception
		Driver dbdriver = new Driver();
		//step2: Register to the dbdriver
		DriverManager.registerDriver(dbdriver);
		//step3: Establish database connection
		//import connection from java.sql package
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		//step4: Create Statement
		//import statement from java.sql package
		Statement st = connect.createStatement();
		//step5: Execute query to fetch data
		//import from java.sql package
		//ResultSet is an interface
		ResultSet result=st.executeQuery("select * from studentdetails;");
		//result.next() checks whether there is next row or not
		while(result.next())
		{
			System.out.println(result.getInt("id")+"\t"+result.getString("name")+"\t"+result.getString("address"));
		}
		
		//step6: close database
		connect.close();
	}
	
	public static void WriteDataIntoSql() throws SQLException
	{
		Driver dbdriver = new Driver();
		DriverManager.registerDriver(dbdriver);
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		Statement st = connect.createStatement();
		//since it sends 1 row affected result we will get result in the form of integer
		int result =st.executeUpdate("insert into studentdetails (id,name,address) values(104,'pqr','gadag');");
		if(result==1)
			System.out.println("DB updated successfully");
		else
			System.out.println("DB not updated");
		connect.close();
	}
	
	public static void main(String[] args) throws SQLException {
		WriteDataIntoSql();
	}
}
