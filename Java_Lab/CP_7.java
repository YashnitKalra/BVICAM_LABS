import java.util.*;

class CP_7{
    public static double getPosition(double a, double v, double x, double t){
        try{
            int temp = (int)v/(int)t;
            return 0.5*a*Math.pow(t,2) + v*t + x;
        }catch(ArithmeticException e){
            throw new NumberFormatException("\nDivide By Zero");
        }
    } 

    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        int choice = 1;
        while(true){
            System.out.print("1. Get Position\n2. Exit\nEnter Choice: ");
            choice = obj.nextInt();
            if(choice==1){
                System.out.print("Enter Time (in sec): ");
                try{
                    System.out.println("\nPosition: " + getPosition(-9.81, 0, 0, obj.nextDouble()) + " m");
                }catch(NumberFormatException nfe){
                    System.out.println(nfe.getMessage());
                    System.out.println("Caught by NumberFormatException catch block");
                }finally{System.out.println("Finally called\n");}
            }else if(choice==2) break;
            else continue;
        }
    }
}