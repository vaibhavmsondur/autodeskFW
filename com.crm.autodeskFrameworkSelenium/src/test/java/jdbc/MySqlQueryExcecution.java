package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class MySqlQueryExcecution {

	public static void main(String[] args) throws SQLException {
		Connection con= null;
		int result=0;
		try {
			Driver driverRef= new Driver();
			DriverManager.registerDriver(driverRef);
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra", "root", "root");
			
			Statement stmt = con.createStatement();
			
			String query="insert into students_info values('6','Roja','K','K')";
			result = stmt.executeUpdate(query);
			if (result==1) {
				System.out.println("Query is Updated");
			}
		} catch (Exception e) {
			System.err.println("Handle Exception");
			System.err.println("Query is Not Updated");
		}finally {
			con.close();
		}
	}

}
