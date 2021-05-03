import java.util.*;

public class CA_3 {

    public static int getProperDivisorSum(int n){
        int s = 0;
        if(n==1) return s;
        for(int i=1;i<=(int)Math.pow(n,0.5);i++){
            if(n%i==0){
                s += i;
                if(n/i!=i && i!=1)
                    s += n/i;
            }
        }
        return s;
    }

    public static boolean isPerfect(int n, int sum){
        return sum==n;
    }

    public static boolean isDeficient(int n, int sum){
        return sum<n;
    }

    public static void main(String[] args){
        System.out.print("Enter upper bound: ");
        int n = new Scanner(System.in).nextInt();
        ArrayList<Integer> perfectNum = new ArrayList<>();
        ArrayList<Integer> neither = new ArrayList<>();
        for(int i=1;i<=n;i++){
            int s = getProperDivisorSum(i);
            if(isPerfect(i,s))
                perfectNum.add(i);
            else if(!isDeficient(i, s))
                neither.add(i);
        }
        System.out.printf("Perfect Numbers: %s\n", perfectNum.toString());
        System.out.printf("Numbers that are neither perfect nor deficient: %s\n", neither.toString());
    }
}
