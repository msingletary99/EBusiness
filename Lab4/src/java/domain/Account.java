package domain;

import database.AccountDA;
import java.util.Date;
import java.util.ArrayList;

public abstract class Account {
    private int accountNumber;
    private int customerID;
    private String accountName;
    private Date dateOpened;
    
    public void add() {
        AccountDA.add(this);
    }

    public String getAccountName() {
        return accountName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    
    public static ArrayList<Account> getCustomerAccounts(int custID) {
        return AccountDA.getCustomerAccounts(custID);
    }

    public int getCustomerID() {
        return customerID;
    }

    public Date getDateOpened() {
        return dateOpened;
    }
    
    public ArrayList<Transaction> getTransactions() {
        return Transaction.getAccountTransactions(accountNumber);
    }
    
    public static void initialize() {
        AccountDA.initialize();
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }
    
    public String toString() {
        ArrayList<Transaction> transactions = getTransactions();
        double sum = 0.0;
        
        String returnString = "Account: " + accountNumber + " " + accountName + " " + dateOpened;
        for (int i = 0; i < transactions.size(); i++){
            sum = sum+= transactions.get(i).getAmount();
            returnString = returnString + "\n          " + transactions.get(i) + "  " + sum;
        }
        
        return returnString;
    }

}
