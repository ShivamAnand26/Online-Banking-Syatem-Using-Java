package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;


import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FindCustomer")
public class FindCustomer extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String id=req.getParameter("id");

    	
    	
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost/banking", "root", "root");
			System.out.println("Connected");
			java.sql.PreparedStatement ps=con.prepareStatement("select * from  customer where id=?");			
			ps.setString(1, id);

			ResultSet rs=ps.executeQuery();
			
		    if(rs.next()) {
		    	 // Retrieve details from ResultSet
		        String C_id = rs.getString("id");
		        String name = rs.getString("name");
		        String accno = rs.getString("accno");
		        String acctype = rs.getString("acctype");
		        String pno = rs.getString("pno");
		        String pass = rs.getString("pass");
		        String balance = rs.getString("balance");
		 
		        req.setAttribute("id", C_id);
		        req.setAttribute("name", name);
		        req.setAttribute("accno", accno);
		        req.setAttribute("acctype", acctype);
		        req.setAttribute("pno", pno);
		        req.setAttribute("pass", pass);
		        req.setAttribute("balance", balance);

		        
		        resp.setContentType("text/html");
		        out.print("<h3 style='color:green'>Details Fetched</h3>");
		        RequestDispatcher rd = req.getRequestDispatcher("/EditCustomer.jsp");
		        rd.include(req, resp);
		       
		    } else {
		        resp.setContentType("text/html");
		        out.print("<h3 style='color:red'>Error: User Id Not found</h3>");
		        RequestDispatcher rd = req.getRequestDispatcher("/FindCustomer.jsp");
		        rd.include(req, resp);
		    }

		    rs.close();
		    ps.close();
		    
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception"+e.getMessage());
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'>Error: "+e.getMessage()+"</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/FindCustomer.jsp");
			rd.include(req, resp);			
		}
    	
    	
    	
    	
    	
    	
		
		
	}

}
