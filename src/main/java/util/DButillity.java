package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButillity {

	public Connection getDBConnection(String url, String username, String password) {
		Connection con = null;
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection(url, username,password);
				//Class.forName("oracle.jdbc.driver.OracleDriver");
				//con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sam","sam");
			
		}
		catch (Exception e) 
		{
			System.out.println("=====> "+e);
		}

		return con;

	}


}



