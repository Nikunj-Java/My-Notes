package com.simplilearn.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert {

	public static void main(String[] args) {
		
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/simplilearn";
		String username="root";
		String password="Nikunj@123";
		
		try {
			//load driver
			Class.forName(driver);
			//get connection and store it in con object
			Connection con= DriverManager.getConnection(url,username,password);
			//check if the connection is not null
			if(con!=null)
			{
				String sql="insert into eproduct (name,price) values "+
			"('HP Laptop ABC3',27000)";
				Statement stmt= con.createStatement();
				stmt.execute(sql);
				
				System.out.println("Data Inserted Successfully");
			}
			else
				System.out.println("Error while connecting with database");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}