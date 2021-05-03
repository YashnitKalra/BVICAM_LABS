using System;

namespace Assignment_3
{
    interface DepositInterface{
        public void Deposit(double amount);
    }

    abstract class Account{
        public int account_no, account_type;
        public double balance;
        public abstract double CalculateInterest(int months);
    }

    class Deposit_Account:Account,DepositInterface{
        static int count = 0;
        static double interest_rate = 0.5;
        public Deposit_Account(double balance){
            account_no = ++count;
            this.balance = balance;
            account_type = 0;
        }
        public override double CalculateInterest(int months){
            return balance*months*interest_rate/100;
        }
        public void Deposit(double amount){
            if(amount>0) balance += amount;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Deposit_Account a = new Deposit_Account(1000);
            a.Deposit(1200);
        }
    }
}
