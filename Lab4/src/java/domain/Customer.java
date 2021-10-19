package domain;

import database.CustomerDA;
import domain.Account;
import exceptions.LoginException;
import exceptions.RecordNotFoundException;

import java.util.ArrayList;

public class Customer {
    private int customerID;
    private String name;
    private long phoneNumber;
    private String userID;
    private String password;
    
    public void add() {
        CustomerDA.add(this);
    }
    
    public static void add(Customer c) {
        CustomerDA.add(c);
    }
    
    public static Customer find(String uid) throws RecordNotFoundException{
        return CustomerDA.find(uid);
    }
    
    public ArrayList<Account> getAccounts() {
        return Account.getCustomerAccounts(customerID);
    }

    public int getCustomerID() {
        return customerID;
    }
    
    public static ArrayList<Customer> getCustomers() {
        return CustomerDA.getCustomers();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    
    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserID() {
        return userID;
    }
    
    public static Customer login(String uid, String pwd) throws LoginException {
        Customer cust = null;
        
        try {
            cust = Customer.find(uid);
            if (cust.getPassword().equals(pwd)){}
            else {
                LoginException ex = new LoginException("Invalid Password");
                throw ex;
            }
        }
        
        catch(RecordNotFoundException e) {
            LoginException ex = new LoginException(e.getMessage());
            throw ex;
        }
        return cust;
    }
    
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    public static void initialize() {
        CustomerDA.inititialize();
    }
    
    public String toString() {
        String returnString = "\nCustomer " + customerID + " " + name + " " + userID + " " + password;
        ArrayList<Account> accounts = getAccounts();
        
        for (int i = 0; i < accounts.size(); i++) {
            returnString = returnString + "\n     " + accounts.get(i);
        }
        
        return returnString;
    }
}