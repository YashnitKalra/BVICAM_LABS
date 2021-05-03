import java.util.Scanner;

public class CP_4 {
    public static void main(String args[]){
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter number of students: "); int numStudents = obj.nextInt();
        int grades[] = new int[numStudents];
        System.out.println("Enter marks in range (0-100):");
        double sum = 0;
        int max=-1,min=101;
        for(int i=0;i<numStudents;i++){
            System.out.printf("Enter marks of Student %d\n", i+1); grades[i] = obj.nextInt();
            max = Math.max(max, grades[i]); min = Math.min(min, grades[i]); sum += grades[i];
        }
        System.out.printf("Average marks: %s\nMaximum Marks: %d\nMinimum Marks: %d\n", String.format("%.2f", sum/numStudents), max, min);
    }
}
