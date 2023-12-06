package com.simplilearn.userdashboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
	static Connection getConnection() {
		
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/simplilearn";
		String username="root";
		String password="Nikunj@123";
		Connection conn=null;
		
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,username,password);
			if(conn!=null)
				return conn;
			else
				return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		 
	}

}
