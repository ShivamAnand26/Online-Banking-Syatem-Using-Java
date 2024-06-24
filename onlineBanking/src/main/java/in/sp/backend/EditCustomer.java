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
@WebServlet("/EditCustomer")
public class EditCustomer extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String accno=req.getParameter("accno");
		String acctype=req.getParameter("acctype");
		String pno=req.getParameter("pno");
		String pass=req.getParameter("pass");
		
		PrintWriter out=resp.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost/banking", "root", "root");
			System.out.println("Connected");
			java.sql.PreparedStatement ps = con.prepareStatement("UPDATE customer SET name=?, accno=?, acctype=?, pno=?, pass=? WHERE id=?");		
			
			ps.setString(1,name);
			ps.setString(2, accno);
			ps.setString(3, acctype);
			ps.setString(4, pno);
			ps.setString(5, pass);
			ps.setString(6, id);
			
		
			
		int count=	ps.executeUpdate();
		if(count>0) {
			resp.setContentType("text/html");
            out.print("<h3 style='color:green'>Customer Details updated</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("/admin.jsp");
        	rd.include(req, resp);
			
		}
		else {
			resp.setContentType("text/html");
            out.print("<h3 style='color:red'>Error: Not Updated Successfully</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("/EditCustomer.jsp");	
        	rd.include(req, resp);
		}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception"+e.getMessage());
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'>Error: "+e.getMessage()+"</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/EditCustomer.jsp");
			rd.include(req, resp);
			
			
		}
		
		
		
		
	}

}
