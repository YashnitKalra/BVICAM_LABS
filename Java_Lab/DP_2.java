class BankingSync implements Runnable{
    SavingsAccount sa;

    public BankingSync(int id, float amount){
        sa = new SavingsAccount(id, amount);
    }

    public void deposit(float amount){
        synchronized(sa){
            sa.deposit(amount);
        }
    }

    public void withdraw(float amount){
        synchronized(sa){
            sa.withdraw(amount);
        }
    }

    public void run(){
        deposit(1500);
        withdraw(900);
    }
}

public class DP_2 {
    public static void main(String[] args){
        Thread obj1 = new Thread(new BankingSync(1, 1000));
        obj1.start();
    }
}
