package testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JConnector {
	
	private static final String USER = "root";
	private static final String PASS = "ezpass";
	private static final String CONNECTION_URL = "jdbc:mysql://localhost/test";
	
	public static void main(String[] args) {
		Connection connection = null;
		Statement st = null;
		ResultSet res = null;
		
		try {
			connection = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
			System.out.println("Connected");
			st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			res = st.executeQuery("SELECT * FROM student");
			System.out.println(res.next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(res!=null) res.close();
				if(st!=null) st.close();
				if(connection!=null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
