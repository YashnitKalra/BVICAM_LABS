import java.util.Scanner;

class AP_8{
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter number of hours: ");
        double hours = obj.nextDouble();
        System.out.print("Enter wage: $");
        double wage = obj.nextDouble();
        if(wage<8)
            System.out.println("Wage should not be less than $8.00 an hour");
        else if(hours>60)
            System.out.println("Hours cannot be greater than 60");
        else
            System.out.println("Pay: $"+(Math.min(hours,40)*wage + Math.max(hours-40, 0)*wage*1.5));
    }
}