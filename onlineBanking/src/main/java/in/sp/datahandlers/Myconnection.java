package in.sp.datahandlers;

import java.sql.Connection;
import java.sql.DriverManager;

public class Myconnection {
	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/banking", "root", "262802");
			System.out.println("Connection successful");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return con;
	}
}
