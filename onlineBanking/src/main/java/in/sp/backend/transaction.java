package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import in.sp.datahandlers.Myconnection;
import in.sp.datahandlers.updateTransaction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/transaction")
public class transaction extends HttpServlet{

	

		@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String amount=req.getParameter("amount");
		String n_id=req.getParameter("n_id");
		PrintWriter out=resp.getWriter();
		int balance=updateTransaction.fetchMyBalance(0, id);
		int nomineBalance=updateTransaction.fetchMyBalance(0, n_id);
		Connection con=Myconnection.connect();

		try {
		int count=updateTransaction.updatetransactionTable(id, amount, n_id);
		if(count>0) {
			
			updateTransaction.updateMyBalance( balance, amount, id);	
			updateTransaction.updateNomineeBalance( nomineBalance, amount, n_id);
			resp.setContentType("text/html");
            out.print("<h3 style='color:green'>Transaction Completed</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("/user.jsp");
         	rd.include(req, resp);         		
		}		
		else {
			resp.setContentType("text/html");
            out.print("<h3 style='color:red'>Error: Transaction failed</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("/user.jsp");
        	rd.include(req, resp);
        	
		}
	}
	catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception"+e.getMessage());
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'>Error: "+e.getMessage()+"</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/user.jsp");
			rd.include(req, resp);
			
			
		}
		
	}

}
