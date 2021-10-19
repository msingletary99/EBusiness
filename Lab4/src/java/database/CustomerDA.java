package database;

import domain.Customer;
import exceptions.RecordNotFoundException;

import java.util.ArrayList;

public class CustomerDA {
    private static ArrayList<Customer> customers = new ArrayList<Customer>(5);
    
    public static void add(Customer c) {
        customers.add(c);
    }
    
    public static ArrayList<Customer> getCustomers() {
        return customers;
    }
    
    public static Customer find(String uid) throws RecordNotFoundException{
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getUserID().equals(uid))
                return customers.get(i);
        }
        
        RecordNotFoundException e = new RecordNotFoundException("Customer " + uid + " not found");
        throw e;
    }
    
    public static void inititialize() {
        Customer c;
        
        if (customers.size() <= 0) {
        
            c = new Customer();
            c.setCustomerID(101);
            c.setName("Customer One");
            c.setPhoneNumber(5551212);
            c.setUserID("Cust1");
            c.setPassword("cust1");
            c.add();
        
            c = new Customer();
            c.setCustomerID(102);
            c.setName("Customer Two");
            c.setPhoneNumber(4442323);
            c.setUserID("Cust2");
            c.setPassword("cust2");
            c.add();
        
            c = new Customer();
            c.setCustomerID(103);
            c.setName("Customer Three");
            c.setPhoneNumber(4442323);
            c.setUserID("Cust3");
            c.setPassword("cust3");
            c.add();
        }       
    }
}