package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseQueryExecution {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
				Driver driverRef = new Driver();
				DriverManager.registerDriver(driverRef);
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra", "root","root");
				
				Statement stmt = con.createStatement();
				
				String query= "insert into practice values('1','Vaibhav','Murlidhar','Sondur')";
				int result = stmt.executeUpdate(query);
				
				if (result==1) {
					System.out.println("Pass query updated");
				}
				
		} catch (Exception e) {
			System.err.println("Handle the exception");
			System.err.println("Fail query not updated");
		}finally {
			con.close();
		}
	}

}
