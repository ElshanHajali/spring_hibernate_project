package spring_demo.spring_jdbs;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBS {
	
	public static void main(String[] args) {
		
		String jdbcURL = "jdbc:mysql://localhost:3306/hb-05-many-to-many?useSSL=false&serverTimezone=UTC";
		String user="hbstudent";
		String password = "hbstudent";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			System.out.println("Connecting to the database: "+jdbcURL);

			Class.forName(driver);
			
			Connection connection = 
					   DriverManager.getConnection(jdbcURL,user,password);
						
			System.out.println("Connection successful!!!");
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
