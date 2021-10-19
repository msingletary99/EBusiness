package database;

import domain.Account;
import domain.Asset;
import domain.Liability;

import java.util.ArrayList;
import java.util.Date;

public class AccountDA {
    public static ArrayList<Account> accounts = new ArrayList<Account>(5);
    
    public static void add(Account acc) {
        accounts.add(acc);
    }
    
    public static ArrayList<Account> getCustomerAccounts(int custID) {
        Account acc;
        ArrayList<Account> customerAccounts = new ArrayList<Account>(5);
        
        for(int i = 0; i < accounts.size(); i++) {
            acc = accounts.get(i);
            if (acc.getCustomerID() == custID)
                customerAccounts.add(acc);
        }
        
        return customerAccounts;
    }
    
    public static void initialize(){
        Account a;
        Date today = new Date();
        
        a = new Asset();
        a.setAccountNumber(10101);
        a.setCustomerID(101);
        a.setAccountName("Customer One Checking Account");
        a.setDateOpened(today);
        a.add();
        
        a = new Asset();
        a.setAccountNumber(10102);
        a.setCustomerID(101);
        a.setAccountName("Customer One Savings Account");
        a.setDateOpened(today);
        a.add();
        
        a = new Asset();
        a.setAccountNumber(10201);
        a.setCustomerID(102);
        a.setAccountName("Savings Account");
        a.setDateOpened(today);
        a.add();
        
        a = new Liability();
        a.setAccountNumber(10202);
        a.setCustomerID(102);
        a.setAccountName("Customer Two Credit Card");
        a.setDateOpened(today);
        a.add();
    }
}
