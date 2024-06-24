package in.sp.datahandlers;

import java.sql.Date;

public class Statement {
    private String id;
    private Date date;
    private String amount;
    private String account;

    public Statement(String id,Date date, String amount,String account) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.account=account;
    }

    // Getters and setters for id, status, and amount
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getAccount() {
        return account;
    }

    public void setAccout(String account) {
        this.account = account;
    }
}
