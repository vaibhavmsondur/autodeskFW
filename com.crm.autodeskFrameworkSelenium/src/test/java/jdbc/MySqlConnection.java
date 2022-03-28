package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class MySqlConnection {

	public static void main(String[] args) throws Throwable {
		Connection con=null;
		ResultSet rs;
		try {
			// Step 1: load/register the database
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			//Step 2: Connect to database
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra", "root", "root");
			
			//Step 3: Issue SQL Query
			 Statement stmt = con.createStatement();
			 
			//Step 4: execute query
			 String query= "select * from students_info";
			rs= stmt.executeQuery(query);
			 while (rs.next()) {
				System.out.println(rs.getInt(1)+"\t" +rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));	
			}
			 
		} catch (Exception e) {
			System.err.println("Handle the exception");
		}finally {
			//Step 5: Close the database
			con.close();
		}
	}

}
