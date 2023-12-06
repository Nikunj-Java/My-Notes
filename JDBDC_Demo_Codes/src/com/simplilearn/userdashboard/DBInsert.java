package com.simplilearn.userdashboard;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInsert {
	public static void main(String[] args) {
		Connection conn=DBConfig.getConnection();
		// create table eproduct (id bigint primary key auto_increment,name varchar(100),price decimal(10,2),date_added timestamp default now());
		if(conn!=null)
			{
			Statement stmt;
			try {
				stmt = conn.createStatement();
				//stmt.execute("insert into eproduct (name,price) values ('HP-Idigo',56000)");
				//stmt.execute("update eproduct set name='Hp-Indigo-Laptop' where id=5");
				//stmt.execute("delete from eproduct where id=5");
				stmt.execute("select * from eproduct");
				ResultSet rs=stmt.executeQuery("select * from eproduct");
				
				System.out.println("Data Inserted Successfully");
				while (rs.next()) {
					System.out.println(rs.getInt("id")+","+rs.getString("name")+rs.getDouble("price")+rs.getDate("date_added"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
		else
			System.out.println("Error While Connecting");
		
	}
	static void insert() {
		
	}
	 

}
