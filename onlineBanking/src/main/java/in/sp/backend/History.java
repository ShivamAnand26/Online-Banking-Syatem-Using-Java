package in.sp.backend;

import java.io.IOException;
import java.sql.Date;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import in.sp.datahandlers.Statement;
@WebServlet("/History")
public class History extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String accno=req.getParameter("accno");
        PrintWriter out = resp.getWriter();
        List<Statement> statements = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/banking", "root", "root");
            PreparedStatement ps = con.prepareStatement("select * from transaction where id=? OR  n_id=?");
            ps.setString(1, id);
            ps.setString(2,id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String transactionId = rs.getString("id");
                Date date = rs.getDate("date");
                String amount = rs.getString("amount");
                String account=rs.getString("n_id");
                Statement st= new Statement(transactionId, date, amount,account);
                statements.add(st);
            }

            rs.close();
            ps.close();
            con.close();
           

            req.setAttribute("transactions", statements);

            RequestDispatcher rd = req.getRequestDispatcher("/History.jsp");
            rd.forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            resp.setContentType("text/html");
            out.print("<h3 style='color:red'>Error: " + e.getMessage() + "</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("/user.jsp");
            rd.include(req, resp);
        }
    }
}
