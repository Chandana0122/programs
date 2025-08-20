package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnectionExample {
	    public static void main(String[] args) {
	        Connection connection = null;
	        Statement statement = null;
	        ResultSet resultSet = null;
	 
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver"); // For MySQL
	            String url = "jdbc:mysql://localhost:3306/bank";
	            String user = "root";
	            String password = "system";
	            connection = DriverManager.getConnection(url, user, password);
	 
	            // Step 3 & 4: Create Statement and Execute Query
	            statement = connection.createStatement();
	            String sql = "SELECT * FROM wip";
	            resultSet = statement.executeQuery(sql);
	 
	            // Step 5: Process Results
	            while (resultSet.next()) {
	                // Process data from resultSet
	                System.out.println("Column1: " + resultSet.getString("e_id"));
	            }
	 
	        } catch (ClassNotFoundException e) {
	            System.err.println("JDBC Driver not found: " + e.getMessage());
	        } catch (SQLException e) {
	            System.err.println("Database error: " + e.getMessage());
	        } finally {
	            // Step 6: Close Resources
	            try {
	                if (resultSet != null) resultSet.close();
	                if (statement != null) statement.close();
	                if (connection != null) connection.close();
	            } catch (SQLException e) {
	                System.err.println("Error closing resources: " + e.getMessage());
	            }
	        }
	    }
	}


