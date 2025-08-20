package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Exp3  {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bank";
		String user = "root";
		String pas = "system";
		
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,user,pas);
		
		String sql = "insert into wip values(?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		
		pst.setInt(1, 11);
		pst.setString(2, "teju");
		pst.execute();
		System.out.println("done");

	}

}
