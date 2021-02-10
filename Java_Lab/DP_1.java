class Palindrome1 extends Thread{
    public void run(){
        System.out.println("Using Thread Class");
        for(int i=100;i<=1000;i++)
            if(DP_1.isPalindromeNumber(i))
                System.out.print(i+" ");
    }
}

class Palindrome2 implements Runnable{
    public void run(){
        try{
            Thread.sleep(100);
        }catch(Exception e){}
        System.out.println("\nUsing Runnable Interface");
        for(int i=100;i<=1000;i++)
            if(DP_1.isPalindromeNumber(i))
                System.out.print(i+" ");
        System.out.println();
    }
}

public class DP_1 {
    public static boolean isPalindromeNumber(int n){
        int m = 0;
        int p = n;
        while(p>0){
            m*=10;
            m+=p%10;
            p/=10;
        }
        return n==m;
    } 
    public static void main(String[] args){
        Palindrome1 p1 = new Palindrome1();
        Thread p2 = new Thread(new Palindrome2());
        p1.start();
        p2.start();
    }
}
