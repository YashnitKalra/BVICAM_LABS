package bank;

import javax.ejb.Stateful;

@Stateful
public class BankBean implements BankBeanLocal {

    private double balance;
    
    public BankBean(){
        balance = 0.0;
    }
    
    @Override
    public boolean deposit(double amount) {
        if(amount<0)
            return false;
        balance += amount;
        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        if(amount > balance || amount < 0)
            return false;
        balance -= amount;
        return true;
    }

    @Override
    public double balance() {
        return balance;
    }
}
