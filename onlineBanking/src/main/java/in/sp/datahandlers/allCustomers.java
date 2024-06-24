package in.sp.datahandlers;

public class allCustomers {
	   private String id;
	    private String name;
	    private String accno;
	    private String acctype;
	    private String balance;
	    private String pno;
	    private String pass;
	    public allCustomers(String id,String name, String accno ,String acctype,String balance,String pno,String pass) {
	        this.id = id;
	        this.name=name;
	        this.accno=accno;
	        this.acctype=acctype;
	        this.balance=balance;
	        this.pno=pno;
	        this.pass=pass;
	    }
	    
//	    id
	    public String getId() {
	        return id;
	    }
	    public void setId(String id) {
	        this.id = id;
	    }
	    
//	  NAME  
	    
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.id = name;
	    }

//	    ACCNO
	    public String getAccno() {
	        return id;
	    }

	    public void setAccno(String accno) {
	        this.accno = accno;
	    }
	   
//ACC TYPE
	    public void setAcctype(String acctype) {
	        this.acctype = acctype;
	    }
	    public String getAcctype()
	    {
	    	return acctype;
	    }
	    
	    
//BALANCE
	    public void setBalance(String balance) {
	        this.balance = balance;
	    }
	    public String getBalance()
	    {
	    	return balance;
	    }
//PNO
	    
	    public String getPno() {
	        return pno;
	    }

	    public void setPno(String pno) {
	        this.pno = pno;
	    }
//PASS
	    
	    public String getPass() {
	        return pass;
	    }

	    public void setPass(String pass) {
	        this.pass = pass;
	    }

}



