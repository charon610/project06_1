package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public Connection dbConn;
	
	public Connection getConnection() {
		String dbDriver = "oracle.jdbc.driver.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUser = "dbtest";
		String dbPassword = "1234";
		
		try {
			Class.forName(dbDriver);
			dbConn = DriverManager.getConnection(
					dbUrl, dbUser, dbPassword
			);
			//System.out.println("?λΉ? ?°κ²? ?λ£?~!");
		} catch(Exception e) {
			//System.out.println("?λΉ? ?°κ²? ?€?¨..");
			e.printStackTrace();
		}
		
		return dbConn;
	}
}
