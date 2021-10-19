package database;

import domain.Transaction;

import java.util.ArrayList;
import java.util.Date;

public class TransactionDA {
    private static ArrayList<Transaction> transactions = new ArrayList<Transaction>(5);
    
    public static void add(Transaction trans) {
        trans.setTransactionID(transactions.size() + 1);
        transactions.add(trans);
    }
    
    public static ArrayList<Transaction> getAccountTransactions(int accNo){
        ArrayList<Transaction> accountTransactions = new ArrayList<Transaction>(5);
        Transaction trans;
        
        for (int i = 0; i < transactions.size(); i++) {
            trans = transactions.get(i);
            if (accNo == trans.getAccountNumber())
                accountTransactions.add(trans);
        }
        return accountTransactions;
    }
    
    public static void initialize() {
        Transaction t;
        Date today = new Date();
        
        t = new Transaction();
        t.setAccountNumber(10101);
        t.setTransactionDate(today);
        t.setDescription("Transaction 1");
        t.setAmount(100);
        t.add();
        
        t = new Transaction();
        t.setAccountNumber(10101);
        t.setTransactionDate(today);
        t.setDescription("Transaction 2");
        t.setAmount(-21.95);
        t.add();
        
        t = new Transaction();
        t.setAccountNumber(10101);
        t.setTransactionDate(today);
        t.setDescription("Transaction 3");
        t.setAmount(16.25);
        t.add();
        
        t = new Transaction();
        t.setAccountNumber(10102);
        t.setTransactionDate(today);
        t.setDescription("Transaction 1");
        t.setAmount(50.00);
        t.add();
        
        t = new Transaction();
        t.setAccountNumber(10102);
        t.setTransactionDate(today);
        t.setDescription("Transaction 2");
        t.setAmount(250.00);
        t.add();
        
        t = new Transaction();
        t.setAccountNumber(10102);
        t.setTransactionDate(today);
        t.setDescription("Transaction 3");
        t.setAmount(-10.00);
        t.add();
        
        t = new Transaction();
        t.setAccountNumber(10202);
        t.setTransactionDate(today);
        t.setDescription("Transaction 1");
        t.setAmount(500.00);
        t.add();
        
        t = new Transaction();
        t.setAccountNumber(10202);
        t.setTransactionDate(today);
        t.setDescription("Transaction 2");
        t.setAmount(-50.00);
        t.add();
        
        t = new Transaction();
        t.setAccountNumber(10202);
        t.setTransactionDate(today);
        t.setDescription("Transaction 3");
        t.setAmount(25.00);
        t.add();
        
        t = new Transaction();
        t.setAccountNumber(10201);
        t.setTransactionDate(today);
        t.setDescription("Transaction 1");
        t.setAmount(49.75);
        t.add();
        
        t = new Transaction();
        t.setAccountNumber(10201);
        t.setTransactionDate(today);
        t.setDescription("Transaction 2");
        t.setAmount(16.25);
        t.add();
        
        t = new Transaction();
        t.setAccountNumber(10201);
        t.setTransactionDate(today);
        t.setDescription("Transaction 3");
        t.setAmount(-25.0);
        t.add();
    }
}