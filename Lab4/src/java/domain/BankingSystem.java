package domain;
import exceptions.LoginException;

public class BankingSystem {
    
    public static void initialize(){
        Customer.initialize();
        Account.initialize();
        Transaction.initialize();
    }
    
    public static Customer login(String uid, String pass) throws LoginException{
        return Customer.login(uid, pass);
    }    
    
    public static Transaction transaction(string uid, String pass){
        return Account.accountNumber;
    }
}
