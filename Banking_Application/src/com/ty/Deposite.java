package com.ty;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet; 

@WebServlet("/dep")
public class Deposite extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String accountno=req.getParameter("ano");
		String money=req.getParameter("mo");
		double mon=Double.parseDouble(money);
		
		double val= 0.0;
		
		String qry="select Balance from bank_db.details where Accountno=?";
		String qry1="update bank_db.details set Balance=? where Accountno=?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("step1");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("step 2");
			
			
			PreparedStatement pstmt= con.prepareStatement(qry);
			System.out.println("step 3");
			
			
			pstmt.setString(1, accountno);
			
			ResultSet rs=pstmt.executeQuery();
			 
			 if(rs.next())
			 {
				  val=rs.getDouble(1);
				 
				 val=val+mon;
				 System.out.println(val);
				 
			 }
			 
			 PreparedStatement pstmt1 = con.prepareStatement(qry1);
			 pstmt1.setDouble(1, val);
			 pstmt1.setString(2, accountno);
			 pstmt1.executeUpdate();
			 System.out.println("executed");
			 
			 PrintWriter out=res.getWriter();
			 out.println("<html><body bgcolor='cyan'><h1> your amount is deposited</h1></body></html>");
		} 
		
		
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
