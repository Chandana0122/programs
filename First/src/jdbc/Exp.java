package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Exp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bank";
		String user = "root";
		String pas = "system";
		
		try {
			Class.forName(driver);
			
			// 2 establish the connection
			Connection con = DriverManager.getConnection(url,user,pas);
			
			//3 create statement object
			Statement stmt = con.createStatement();
			
			//String sql = "create table wip(e_id int, e_name varchar(20))";
			//String sql = "insert into wip values(1,'chandu')";
			//String  sql = "update wip set e_name = 'chandana'";
			//String sql = "insert into wip values(2,'chandu')";
			String sql = "delete from wip where e_id = 1";
			
			//4 execute the query
			stmt.execute(sql);
			
			//5 close the connection
			con.close();
			System.out.println("done");
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
