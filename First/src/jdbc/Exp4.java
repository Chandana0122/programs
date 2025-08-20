package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Exp4 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bank";
		String user = "root";
		String pas = "system";
		
		
		
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,user,pas);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the studnet id");
		int s_id = sc.nextInt();
		System.out.println("enter the student name");
		String s_name = sc.next();
		System.out.println("enter the passout year");
		String s_py = sc.next();
		System.out.println("enter the city name");
		String s_city = sc.next();
		
		
		//String sql = "create table student(s_id int,s_name varchar(20),s_py varchar(20),s_city varchar(20))";
		
		String sql1 = "insert into student(s_id, s_name, s_py, s_city) values (" + s_id + ",'" + s_name + "','" + s_py +"','" + s_city + "')";
		
		//String sql1 = "update student set s_py = 2024 where s_id = 1";
		//String sql1 = "delete from student where s_id = 2";
		Statement stmt = con.createStatement();
		
		stmt.addBatch(sql1);
		stmt.executeBatch();
		con.close();
		System.out.println("done");

	}

}
