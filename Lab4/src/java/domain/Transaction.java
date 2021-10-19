package domain;

import database.TransactionDA;

import java.util.ArrayList;
import java.util.Date;

public class Transaction {
    private double amount;
    private int transactionID;
    private Date transactionDate;
    private int accountNumber;
    private String description;
    
    public void add() {
        TransactionDA.add(this);
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public static ArrayList<Transaction> getAccountTransactions(int accNo) {
        return TransactionDA.getAccountTransactions(accNo);
    }
    
    public String getDescription() {
        return description;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public int getTransactionID() {
        return transactionID;
    }
    
    public static void initialize() {
        TransactionDA.initialize();
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public void setDescription(String Description) {
        this.description = Description;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }
    
    public String toString() {
        return "" + transactionID + " " + transactionDate + " " + description + "  " + amount;
    }
    
    
}