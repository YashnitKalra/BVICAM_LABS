import java.util.*;

interface Account{
    void withdraw(float amount);
    void deposit(float amount);
    void transfer(Account a, float amount);
}

class SavingsAccount implements Account{
    private int accountNumber;
    private float amount;

    static SavingsAccount getAccount(ArrayList<SavingsAccount> accounts, int account_num){
        for(SavingsAccount a: accounts)
            if(a.accountNumber==account_num)
                return a;
        return null;
    }
    static boolean openAccount(ArrayList<SavingsAccount> accounts, int a_no, float money){
        // zero-balance account can be opened
        if(money>=0){
            accounts.add(new SavingsAccount(a_no, money));
            System.out.printf("New Account Opened, Account Number: %d\n",a_no);
            return true;
        }
        return false;
    }
    static void closeAccount(ArrayList<SavingsAccount> accounts, int account_number){
        for(int i=0;i<accounts.size();i++)
            if(accounts.get(i).accountNumber==account_number){
                accounts.remove(i);
                System.out.println("Account Closed Successfully.");
                break;
            }
    }
    SavingsAccount(int account_num, float amount){
        accountNumber = account_num; this.amount = amount;
    }
    public void withdraw(float money){
        // money can be withdrawn within range 1-50k
        if(money>0 && money<50000 && amount>=money){
            amount -= money;
            System.out.printf("Rs. %f withdrawn from Account %d, Remaining Balance: %f\n",money, accountNumber, amount);
        }else System.out.println("ERROR: Not enough Balance");
    }
    public void deposit(float money){
        if(money>0)
            amount += money;
        System.out.printf("Account Number: %d, Updated Balance: %f\n",accountNumber, amount);
    }
    public void transfer(Account account, float money){
        // transfer rate is 1%
        float transferCharges = money*0.1f, pay = money+transferCharges;
        if(pay<=amount){
            amount -= pay;
            account.deposit(money);
            System.out.printf("Transferred Rs. %f from Account %d, Transfer Charges: %f, Remaining Balance: %f\n", money, accountNumber, transferCharges, amount);
        }else System.out.println("ERROR: Not enough Balance");
    }
}

class CurrentAccount implements Account{
    private int accountNumber;
    private float amount;

    static CurrentAccount getAccount(ArrayList<CurrentAccount> accounts, int account_num){
        for(CurrentAccount a: accounts)
            if(a.accountNumber==account_num)
                return a;
        return null;
    }
    static boolean openAccount(ArrayList<CurrentAccount> accounts, int a_no, float money){
        // minimum balance should be 1k
        if(money>=1000){
            accounts.add(new CurrentAccount(a_no, money));
            System.out.printf("New Account Opened, Account Number: %d\n",a_no);
            return true;
        }
        return false;
    }
    static void closeAccount(ArrayList<CurrentAccount> accounts, int account_number){
        for(int i=0;i<accounts.size();i++)
            if(accounts.get(i).accountNumber==account_number){
                accounts.remove(i);
                System.out.println("Account Closed Successfully.");
                break;
            }
    }
    CurrentAccount(int account_num, float amount){
        accountNumber = account_num; this.amount = amount;
    }
    public void withdraw(float money){
        // money can be withdrawn without limit
        if(amount>=money){
            amount -= money;
            System.out.printf("Rs. %f withdrawn from Account %d, Remaining Balance: %f\n",money, accountNumber, amount);
        }else System.out.println("ERROR: Not enough Balance");
    }
    public void deposit(float money){
        if(money>0)
            amount += money;
        System.out.printf("Account Number: %d, Updated Balance: %f\n",accountNumber, amount);
    }
    public void transfer(Account account, float money){
        // no transfer rate
        float pay = money;
        if(pay<=amount){
            amount -= pay;
            account.deposit(money);
            System.out.printf("Transferred Rs. %f from Account %d, Transfer Charges: %f, Remaining Balance: %f\n", money, accountNumber, 0f, amount);
        }else System.out.println("ERROR: Not enough Balance");
    }
}

public class BP_10 {
    public static void main(String args[]){
        Scanner obj = new Scanner(System.in);
        int choice,choice2;
        String menu1 = "1. Open Savings Account\n2. Open Current Account\n3. Close Savings Account\n4. Close Current Account\n5. Deposit\n6. Withdraw\n7. Transfer\n8. Exit\nEnter Choice: ";
        ArrayList<SavingsAccount> savingsAccounts = new ArrayList<>();
        ArrayList<CurrentAccount> currentAccounts = new ArrayList<>();
        int count = 1, temp;
        SavingsAccount sa,sb;
        CurrentAccount ca,cb;
        do{
            System.out.print(menu1);
            choice = obj.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter Initial Amount: "); if(SavingsAccount.openAccount(savingsAccounts, count, obj.nextFloat())) count++;
                    break;
                case 2:
                    System.out.print("Enter Initial Amount: "); if(CurrentAccount.openAccount(currentAccounts, count, obj.nextFloat())) count++;
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    SavingsAccount.closeAccount(savingsAccounts, obj.nextInt());
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    CurrentAccount.closeAccount(currentAccounts, obj.nextInt());
                    break;
                case 5:
                    System.out.print("Enter Account Number: "); temp = obj.nextInt();
                    sa = SavingsAccount.getAccount(savingsAccounts, temp);
                    if(sa!=null){
                        System.out.print("Enter Amount: "); sa.deposit(obj.nextFloat()); break;
                    }
                    ca = CurrentAccount.getAccount(currentAccounts, temp);
                    if(ca!=null){
                        System.out.print("Enter Amount: "); ca.deposit(obj.nextFloat());
                    }
                    break;
                case 6:
                    System.out.print("Enter Account Number: "); temp = obj.nextInt();
                    sa = SavingsAccount.getAccount(savingsAccounts, temp);
                    if(sa!=null){
                        System.out.print("Enter Amount: "); sa.withdraw(obj.nextFloat()); break;
                    }
                    ca = CurrentAccount.getAccount(currentAccounts, temp);
                    if(ca!=null){
                        System.out.print("Enter Amount: "); ca.withdraw(obj.nextFloat());
                    }
                    break;
                case 7:
                    System.out.print("Enter Your Account Number: "); temp = obj.nextInt();
                    sa = SavingsAccount.getAccount(savingsAccounts, temp);
                    if(sa!=null){
                        System.out.print("Transfer Money - Enter Account Number: "); temp = obj.nextInt();
                        sb = SavingsAccount.getAccount(savingsAccounts, temp);
                        if(sb!=null){
                            if(sb!=sa){
                                System.out.print("Enter Amount: "); sa.transfer(sb, obj.nextFloat()); break;
                            }
                        }else{
                            cb = CurrentAccount.getAccount(currentAccounts, temp);
                            if(cb!=null){
                                System.out.print("Enter Amount: "); sa.transfer(cb, obj.nextFloat()); break;
                            }
                        }
                    }
                    ca = CurrentAccount.getAccount(currentAccounts, temp);
                    if(ca!=null){
                        System.out.print("Transfer Money - Enter Account Number: "); temp = obj.nextInt();
                        sb = SavingsAccount.getAccount(savingsAccounts, temp);
                        if(sb!=null){
                            System.out.print("Enter Amount: "); ca.transfer(sb, obj.nextFloat()); break;
                        }
                        else{
                            cb = CurrentAccount.getAccount(currentAccounts, temp);
                            if(cb!=null){
                                if(ca!=cb){
                                    System.out.print("Enter Amount: "); sa.transfer(cb, obj.nextFloat()); break;
                                }
                            }
                        }
                    }
                    break;
            }
        }while(choice!=8);
    }
}