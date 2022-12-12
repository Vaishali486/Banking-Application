package com.ty;

import java.io.IOException;
import java.sql.*;
import java.util.Random;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/reg")

public class Register extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
	 {
		
		String fname=req.getParameter("fn");
		String mname= req.getParameter("mn");
		String lname= req.getParameter("ln");
		String mno= req.getParameter("mob");
		String uname= req.getParameter("un");
		String password= req.getParameter("pw");
		String cpassword= req.getParameter("cpw");
		double balance=0.0;
		
		String s1="KELP";
		
		Random r=new Random();
		int r1=r.nextInt(10000);
		String s2= s1+""+r1;
		
		String qry="insert into bank_db.details values(?,?,?,?,?,?,?,?)";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("step 1");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("step 2");
			
			PreparedStatement pstmt= con.prepareStatement(qry);
			System.out.println("step 3");
			
			pstmt.setString(1, s2);
			pstmt.setString(2, fname);
			pstmt.setString(3, mname);
			pstmt.setString(4, lname);
			pstmt.setString(5, mno);
			pstmt.setString(6, uname);
			pstmt.setString(7, password);
			pstmt.setDouble(8, balance);
			
			pstmt.executeUpdate();
			System.out.println("4th done");

			
			
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
	
	}

	
		
	}
}
