import java.util.Scanner;

class InvalidNumeralException extends Exception{
    InvalidNumeralException(String msg){
        super(msg);
    }
}

class Calculator{
    static int add(int a, int b){return a+b;}
}

public class CP_8 {
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        int a,b;
        try{
            try{
                System.out.print("Enter Number 1: "); a = obj.nextInt();
                System.out.print("Enter Number 2: "); b = obj.nextInt();
                System.out.print(Calculator.add(a,b));
            }catch(Exception e){throw new InvalidNumeralException("Invalid Numeral");}
        }catch(InvalidNumeralException e){
            System.out.println(e.getMessage());
        }
    }
}
