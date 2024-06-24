package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Login")
public class LogIn extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=req.getParameter("username");
		String pass=req.getParameter("password");
		PrintWriter out=resp.getWriter();
		
		
	
		String url = "jdbc:mysql://localhost/banking";
        String dbUsername = "root";
        String dbPassword = "root";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
            String sql = "SELECT * FROM customer WHERE id = ? AND pass = ?";
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, pass);
            java.sql.ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
              
                
                // Set user details as request attributes
                req.setAttribute("userId", resultSet.getString("id"));
                req.setAttribute("userName", resultSet.getString("name"));
                req.setAttribute("accno", resultSet.getString("accno"));
                req.setAttribute("acctype", resultSet.getString("acctype"));
                req.setAttribute("balance", resultSet.getString("balance"));
                req.setAttribute("pno", resultSet.getString("pno"));
                
                
                RequestDispatcher rd=req.getRequestDispatcher("/user.jsp");
    			rd.forward(req, resp);
    			
            }
            else if(username.equals("admin") && pass.equals("1234")) {
        		
    			RequestDispatcher rd=req.getRequestDispatcher("/admin.jsp");
    			rd.forward(req, resp);
    	
    		}
    		else {
    			   resp.setContentType("text/html");
    	            out.print("<h3 style='color:red'>UserID and Password not matched</h3>");
    	            RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	        	rd.include(req, resp);
    	        
    	        	
    		
    		}
           
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    
		
		
		
		
		
	
	}
	
	
	

}
