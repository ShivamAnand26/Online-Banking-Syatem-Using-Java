package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/openAccount")
public class openAccount extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
			PrintWriter out=resp.getWriter();
			
			String C_id=req.getParameter("C_id");
			String C_name=req.getParameter("C_name");
			String C_accno=req.getParameter("C_accno");
			String C_acctype=req.getParameter("C_acctype");
			String C_balance=req.getParameter("C_balance");
			String C_pno=req.getParameter("C_pno");
			String C_pass=req.getParameter("C_pass");
			
			
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost/banking", "root", "root");
				System.out.println("Connected");
				java.sql.PreparedStatement ps=con.prepareStatement("insert into customer values(?,?,?,?,?,?,?)");			
				ps.setString(1, C_id);
				ps.setString(2, C_name);
				ps.setString(3, C_accno);
				ps.setString(4, C_acctype);
				ps.setString(5, C_balance);
				ps.setString(6, C_pno);
				ps.setString(7, C_pass);
				
			int count=	ps.executeUpdate();
			if(count>0) {
				resp.setContentType("text/html");
	            out.print("<h3 style='color:green'>Account Opened Successfully</h3>");
	            RequestDispatcher rd = req.getRequestDispatcher("/openAccount.jsp");
	        	rd.include(req, resp);
				
			}
			else {
				resp.setContentType("text/html");
	            out.print("<h3 style='color:red'>Error: Please Enter All Details</h3>");
	            RequestDispatcher rd = req.getRequestDispatcher("/openAccount.jsp");
	        	rd.include(req, resp);
			}
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println("Exception"+e.getMessage());
				resp.setContentType("text/html");
				out.print("<h3 style='color:red'>Error: "+e.getMessage()+"</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/openAccount.jsp");
				rd.include(req, resp);
				
				
			}
	}

}
