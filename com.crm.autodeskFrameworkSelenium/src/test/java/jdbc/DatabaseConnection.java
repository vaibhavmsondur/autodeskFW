package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseConnection {

	public static void main(String[] args) throws SQLException {
		Connection con= null;
		ResultSet rs;
		try {
			Driver driverRef= new Driver();
			DriverManager.registerDriver(driverRef);
			
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
			Statement stmt = con.createStatement();
			
			String query= "select * from practice";
			
			rs=stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+ rs.getString(3)+"\t"+rs.getString(4));
			}
		} catch (Exception e) {
			System.out.println("Handle the exception");
		}finally {
			con.close();
		}
		
	}
}
