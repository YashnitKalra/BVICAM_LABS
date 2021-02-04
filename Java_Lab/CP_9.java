import java.util.InputMismatchException;
import java.util.Scanner;

public class CP_9 {
    public static void getInput(Scanner obj) throws InputMismatchException{
        System.out.print("Enter a number between 1 and 10: "); int num = obj.nextInt();
    }
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        try{
            System.out.print("Enter a number between 1 and 10: "); int num = obj.nextInt();
            System.out.println("Using Throws"); getInput(obj);
            System.out.println("Using Throw");
            System.out.print("Enter a number between 1 and 10: "); float n = obj.nextFloat();
            if(Math.ceil(n)!=Math.floor(n))
                throw new InputMismatchException();
        }catch(InputMismatchException e){
            e.printStackTrace();
        }
    }
}
