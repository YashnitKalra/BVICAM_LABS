import java.util.*;

class AA_1{
    public static double getPosition(double a, double v, double x, double t){
        return 0.5*a*Math.pow(t,2) + v*t + x;
    } 

    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        int choice = 1;
        while(true){
            System.out.print("1. Get Position\n2. Exit\nEnter Choice: ");
            choice = obj.nextInt();
            if(choice==1){
                System.out.print("Enter Time (in sec): ");
                System.out.println("Position: " + getPosition(-9.81, 0, 0, obj.nextDouble()) + " m\n");
            }else if(choice==2) break;
            else continue;
        }
    }
}