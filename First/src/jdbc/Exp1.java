package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Exp1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bank";
		String user = "root";
		String pas = "system";
		
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,user,pas);
		Statement stmt = con.createStatement();
		
		/*
		String sql1 = "insert into wip values(3,'varun')";
		String sql2 = "insert into wip values(4,'deepthi')";
		String sql3 = "insert into wip values(5,'varsha')";
		String sql4 = "update wip set e_name = 'varshini' where e_id = 5";
				
		stmt.addBatch(sql1);
		stmt.addBatch(sql2);
		stmt.addBatch(sql3);
		stmt.addBatch(sql4);
		
		stmt.executeBatch();
		*/
		
		String sql = "select * from wip";
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
		}
		
		//ResultSetMetaData rsd = rsd.getMetaData();
		
		
		
		
		
		con.close();

		
		

	}

}
