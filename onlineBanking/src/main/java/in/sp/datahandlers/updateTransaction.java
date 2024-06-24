package in.sp.datahandlers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;

public class updateTransaction {
	static Connection con=Myconnection.connect();
	
public static int fetchMyBalance(int balance,String id) {	
	try {
		java.sql.PreparedStatement ps_balance=con.prepareStatement("select balance from customer where id=?");
		ps_balance.setString(1, id);
		ResultSet rs = ps_balance.executeQuery();    
		    if (rs.next()) {			      
		        balance = Integer.parseInt(rs.getString("balance"));
		    }
		
	}
	catch (Exception e) {

		System.out.println(e.getMessage());
	}
return balance;
}

public static int updatetransactionTable(String id,String amount,String n_id) {
	
	int count=0;
	LocalDate currentDate=LocalDate.now();
	java.sql.Date date = java.sql.Date.valueOf(currentDate);
	System.out.println(date);

	try {
		java.sql.PreparedStatement ps=con.prepareStatement("insert into transaction values(?,?,?,?)");			
		ps.setString(1, id);
		ps.setDate(2,date);
		ps.setString(3, amount);			
		ps.setString(4, n_id);
       count=	ps.executeUpdate();
	
	} catch (Exception e) {
		System.out.println("Exception in UPDATING MY TRANSACTION "+e.getMessage());
	}
	

	return count;
	
	
}
public static void updateMyBalance(int balance,String amount,String id) {
	
	try {
	
			java.sql.PreparedStatement updatePs = con.prepareStatement("Update customer set balance=? WHERE id=?");
			balance=balance-Integer.parseInt(amount);
			String updatedBalance = String.valueOf(balance);
	        updatePs.setString(1,updatedBalance ); 
	        updatePs.setString(2, id);
			updatePs.execute();
	}
	catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

public static void updateNomineeBalance(int balance,String amount,String n_id) {
	try {
			
			java.sql.PreparedStatement updatePs = con.prepareStatement("Update customer set balance=? WHERE id=?");
			balance=balance+Integer.parseInt(amount);
			String updatedBalance = String.valueOf(balance);
	        updatePs.setString(1,updatedBalance ); // Set the amount
	        updatePs.setString(2, n_id); 
			updatePs.execute();		
		 		 
}
	catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error in updating Nominiee"+ e.getMessage());
	}
}
}

