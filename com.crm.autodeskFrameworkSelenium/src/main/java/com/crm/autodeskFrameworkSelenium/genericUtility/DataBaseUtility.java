package com.crm.autodeskFrameworkSelenium.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class is used to communicate with the Database
 * @author VAIBHAV
 *
 */
public class DataBaseUtility {
		Connection con;
		/**
		 * This method is used to establish the connection between java and database
		 * @param query
		 * @return
		 */
		public ResultSet connectToDatabase(String query) {
			ResultSet result = null;
			try {
				Driver driverRef= new Driver();
				DriverManager.registerDriver(driverRef);
				con = DriverManager.getConnection(IPathConstants.DATABASE_PATH, IPathConstants.DB_USERNAME, IPathConstants.DB_PASSWORD);
				result = con.createStatement().executeQuery(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
	}
		
		/**
		 * This method is used to close the Database
		 */
		public void closeDatabase() {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		/**
		 * This method is used to insert the data into database
		 * @param query
		 * @return
		 */
		public boolean insertQuery(String query) {
			boolean flag=false;
			int res=0;
			try {
				res=con.createStatement().executeUpdate(query);
				if (res==1) {
					flag=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
	}
}
