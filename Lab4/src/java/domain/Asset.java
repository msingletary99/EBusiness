package domain;


public class Asset extends Account{
    
    double interestRate;
    
    
    public double getInterestRate(){
      return interestRate;  
    }
    
    public void setInterestRate(double interestRate){
        this.interestRate= interestRate;
    }
}
