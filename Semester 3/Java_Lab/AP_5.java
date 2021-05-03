import java.util.*;

class AP_5{
    public static void combinations(int arr[], boolean visited[], int iteration, int temp[]){
        if(iteration==3){
            for(int i:temp)
                System.out.print(i);
            System.out.println();
        }
        else{
            for(int i=0;i<3;i++)
                if(!visited[i]){
                    visited[i] = true;
                    temp[iteration] = arr[i];
                    combinations(arr, visited, iteration+1, temp);
                    visited[i] = false;
                }
        }
    }

    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter 3 digits:");
        int arr[] = new int[3];
        for(int i=0;i<3;i++)
            arr[i] = obj.nextInt();
        boolean visited[] = new boolean[3];
        System.out.println("\nPossible Combinations:");
        combinations(arr, visited, 0, new int[3]);
    }
}