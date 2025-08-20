package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class exp5 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bank";
		String user = "root";
		String pas = "system";
		
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,user,pas);
	}

}
