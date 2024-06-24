package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//when close account form is  submitted

@WebServlet("/closeAccount")
public class CloseAccount extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String C_id=req.getParameter("C_id");
		String C_name=req.getParameter("C_name");
		PrintWriter out=resp.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost/banking", "root", "root");
			System.out.println("Connected");
			java.sql.PreparedStatement ps=con.prepareStatement("delete from  customer where id=? and name=?");			
			ps.setString(1, C_id);
			ps.setString(2, C_name);
			
		int count=	ps.executeUpdate();
		if(count>0) {
			resp.setContentType("text/html");
            out.print("<h3 style='color:green'>Account Closed</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("/closeAccount.jsp");
        	rd.include(req, resp);
			
		}
		
		else {
			resp.setContentType("text/html");
            out.print("<h3 style='color:red'>Error: Incorrect Username or ID</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("/closeAccount.jsp");
        	rd.include(req, resp);
		}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception"+e.getMessage());
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'>Error: "+e.getMessage()+"</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/closeAccount.jsp");
			rd.include(req, resp);			
		}
		
	
	
	
	
	}
	

}
