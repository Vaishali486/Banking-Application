package com.ty;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/log")
public class Login extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
	{
		String account=req.getParameter("an");
		String uname=req.getParameter("un");
		String pwd=req.getParameter("pw");
		
		String qry="select Uname,Password from bank_db.details where Accountno=? and Uname=? and Password=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("step 1");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("step 2");
			
			
			PreparedStatement pstmt= con.prepareStatement(qry);
			System.out.println("step 3");
			
			pstmt.setString(1, account);
			pstmt.setString(2, uname);
			pstmt.setString(3, pwd);
			
			ResultSet rs=pstmt.executeQuery();
			System.out.println("data executed");
			
			
			if(rs.next())
			{
				
					RequestDispatcher rd = req.getRequestDispatcher("Bwork.html");
					rd.forward(req, resp);
					System.out.println("present");
			}
				
			else
				{
					RequestDispatcher rd = req.getRequestDispatcher("Index.html");
					rd.include(req, resp);
					System.out.println("not present");
				}
			
			
			} 
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

		
	}
}
