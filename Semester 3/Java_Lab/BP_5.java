import java.util.Scanner;

public class BP_5 {
    public static void main(String[] args){
        System.out.print("Enter number of rows: ");
        int n = new Scanner(System.in).nextInt();
        int arr[][] = new int[n][];
        for(int i=0;i<n;i++){
            arr[i] = new int[i+1];
            for(int j=0;j<n-1;j++)
                System.out.print(" ");
            for(int j=0;j<arr[i].length;j++){
                arr[i][j] = j+1;
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++)
                System.out.print(" ");
            for(int j:arr[i])
                System.out.print(j);
            System.out.println();
        }
    }
}
