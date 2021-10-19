package domain;

public class Liability extends Account{
    double interestRate;
    double monthlyPayment;
    
        
    public double getInterestRate(){
      return interestRate;  
    }
    
    public double getMonthlyPayment(){
        return monthlyPayment;
    }
    
    
    public void setInterestRate(double interestRate){
        this.interestRate= interestRate;
    }
    
    public void setMonthlyPayment(double monthlyPayment){
        this.monthlyPayment = monthlyPayment;
}
}
