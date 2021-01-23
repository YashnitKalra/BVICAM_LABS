import java.util.*;

class AP_3{
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
	    System.out.print("Enter Integer Value: ");
	    int i = obj.nextInt();
	    System.out.print("Enter Double Value: ");
        double d = obj.nextDouble();
	    System.out.print("Enter Float Value: ");
        float f = obj.nextFloat();
        System.out.printf("\nint %d to byte %d\n", i, (byte)i);     // i%256
        System.out.printf("double %f to int %d\n", d, (int)d);
        System.out.printf("double %f to byte %d\n", d, (byte)d);    // d%256
        System.out.printf("int %d to char %c\n", i, (char)i);	    // i%256
        System.out.printf("float %f to short %d\n", f, (short)f);	// f%256
    }
}
