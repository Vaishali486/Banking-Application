package com.ty;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/che")
public class Checkbal extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String accountno=req.getParameter("ano");
		String uname=req.getParameter("un");
		String password=req.getParameter("ps");
		
		String qry="select * from bank_db.details where Accountno=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("step1");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("step 2");
			
			
			PreparedStatement pstmt= con.prepareStatement(qry);
			System.out.println("step 3");
			
			
			pstmt.setString(1, accountno);
			
			ResultSet rs=pstmt.executeQuery();
			
			PrintWriter out=res.getWriter();
			if(rs.next())
			{
				String accno=rs.getString(1);
				String fname=rs.getString(2);
				String mname=rs.getString(3);
				String lname=rs.getString(4);
				String mob=rs.getString(5);
				String un=rs.getString(6);
				String pass=rs.getString(7);
				String bal=rs.getString(8);
				
				out.println("<html><body bgcolor='cyan'><h1>details are: "+"<br>"+"Account no:"+accno+"<br>"+
				"First name:"+fname+"<br>"+"Middle name: "+mname+"<br>"+"Last name: "+lname+
				"<br> "+"Mobile no: "+mob+"<br>"+"Username: "+un+"<br>"+"Balance: "+bal+"</h1></body></html>");
			}
			
} 
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	

}
