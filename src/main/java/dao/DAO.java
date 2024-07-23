package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

	Connection con;
	
	public void getCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/pro2";
			String user="root";
			String password="1111";
			
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
