package com.simplilearn.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/insert")
public class CreateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		Connection conn=DBConfig.getConnection();
		
		if(conn!=null) {
			System.out.println("Connection Established");
			
			String sql="insert into student (name,email,username) values (?,?,?)";
						PreparedStatement stmt;
						int result=0;
						try {
							String name=req.getParameter("name");
							String email=req.getParameter("email");
							String username=req.getParameter("username");
							
							stmt= conn.prepareStatement(sql);
							stmt.setString(1, name);
							stmt.setString(2, email);
							stmt.setString(3, username);
							
							result=stmt.executeUpdate();
							
							if(result>0) {
								/*
								Statement fstmt = conn.createStatement();
								ResultSet  rs=fstmt.executeQuery("select * from student");
								
								while(rs.next()) {
									out.println("Id:"+rs.getInt(1)+",name:"+rs.getString(2)+", Email:"+rs.getString(3)+",username:"+rs.getString(4));
								}
								*/
								resp.sendRedirect("list");
							}

							
							
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
			
		}else {
			System.out.println("Error in The Connections");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	

}
