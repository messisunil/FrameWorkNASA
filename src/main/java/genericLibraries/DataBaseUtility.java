package genericLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;
/**
 * This class consists of methods required to fetch or modify the data in database
 * @author sunil
 *
 */
public class DataBaseUtility {
	private Connection connect;
	/**
	 * This method is used to initialize database
	 * @param url
	 * @param username
	 * @param password
	 */
	public void databaseInitialization(String url, String username, String password)
	{
		Driver dbDriver = null;
		try {
			dbDriver = new Driver();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			DriverManager.registerDriver(dbDriver);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connect = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to read the data in database
	 * @param query
	 * @param columnName
	 * @return
	 * @throws SQLException
	 */
	public List<String> readDataFromDatabase(String query, String columnName) throws SQLException
	{
		Statement statement = null;
		try {
			statement = connect.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet result = null;
		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<String> columnData = new ArrayList<>();
		while(result.next())
		{
			columnData.add(result.getString(columnName));
		}
		return columnData;
	}
	
	/**
	 * This method is used to modify the data in database
	 * @param query
	 * @return
	 */
	public int modifyDatabase(String query)
	{
		Statement statement = null;
		try {
			statement = connect.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int result = 0;
		try {
			result = statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * This method is used to close the database connection
	 */
	public void closeDatabase()
	{
		try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
