import java.util.*;

class AP_2{

    public static double getSum(double n){
        if(n==1)
            return 1;
        return 1/n + getSum(n-1);
    }
    
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter length of series: ");
        int n = obj.nextInt();
        for(int i=1;i<=n-1;i++)
            System.out.print("1/" + i + " + ");
        System.out.println("1/" + n + " = "+getSum((double)n));
    }
}