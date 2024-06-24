package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.sp.datahandlers.Myconnection;
import in.sp.datahandlers.allCustomers;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/showcustomer")
public class ShowCustomer extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		 List<allCustomers> Customers = new ArrayList<>();
		
		try {
				Connection con=Myconnection.connect();
	            PreparedStatement ps = con.prepareStatement("select * from customer");
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                String id = rs.getString("id");
	                String name = rs.getString("name");
	                String accno = rs.getString("accno");
	                String acctype=rs.getString("acctype");
	                String balance=rs.getString("balance");
	                String pno=rs.getString("pno");
	                String pass=rs.getString("pass");	                
	                allCustomers st= new allCustomers(id,name,accno,acctype,balance,pno,pass);
	                Customers.add(st);
	            }

	            rs.close();
	            ps.close();
	            con.close();
	           
	            req.setAttribute("allCustomer", Customers);
	            RequestDispatcher rd = req.getRequestDispatcher("/showcustomer.jsp");
	            rd.forward(req, resp);		
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	

}
