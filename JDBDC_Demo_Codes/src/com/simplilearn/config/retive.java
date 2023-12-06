package com.simplilearn.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class retive {

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
				String sql="select * from eproduct";
				 
				Statement stmt= con.createStatement();
				stmt.execute(sql);
				ResultSet rs=stmt.executeQuery(sql);
				
				System.out.println("Data fetched Successfully");
				while(rs.next()) {
					int id=rs.getInt("id");
					String Name=rs.getString("name");
					double Price=rs.getDouble("price");
					Date date=rs.getDate("date_added");
					System.out.println("id:"+id+",Name:"+Name+", Price:"+Price+",Date:"+date);
				}
			}
			else
				System.out.println("Error while connecting with database");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}