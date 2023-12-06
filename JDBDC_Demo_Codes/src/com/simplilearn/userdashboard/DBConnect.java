package com.simplilearn.userdashboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	public static void main(String[] args) {
		
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/simplilearn";
		String username="root";
		String password="Nikunj@123";
		
		try {
			Class.forName(driver);
			Connection conn= DriverManager.getConnection(url,username,password);
			if(conn!=null)
				System.out.println("Connection Established");
			else
				System.out.println("Error in The Connectivity");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
