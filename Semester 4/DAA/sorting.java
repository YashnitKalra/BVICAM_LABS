import java.util.Scanner;

public class sorting {
    static void printArray(int[] arr){
        System.out.print("Array: ");
        for(int i: arr)
            System.out.print(i + " ");
        System.out.println();
    }
    
    static void swap(int[] arr, int i, int j){
        if(i==j)
            return;
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }
    
    static void selectionSort(int[] arr){
        int minIndex;
        for(int i=0; i<arr.length-1; i++){
            minIndex = i;
            for(int j=i+1; j<arr.length; j++)
                if(arr[minIndex] > arr[j])
                    minIndex = j;
            swap(arr, i, minIndex);
        }
        printArray(arr);
    }

    static void bubbleSort(int[] arr){
        for(int i=0; i<arr.length; i++)
            for(int j=0; j<arr.length-1-i; j++)
                if(arr[j]>arr[j+1])
                    swap(arr, j, j+1);
        printArray(arr);
    }

    static void insertionSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            int key = arr[i], j;
            for(j=i-1; j>=0 && arr[j]>key; j--)
                arr[j+1] = arr[j];
            arr[j+1] = key;
        }
        printArray(arr);
    }

    // quick sort start ********************************
    static void quickSort(int[] arr){
        quicksort(arr, 0, arr.length-1);
        printArray(arr);
    }

    static void quicksort(int[] arr, int l, int r){
        if(l < r){
            int m = partition(arr, l, r);
            quicksort(arr, l, m-1);
            quicksort(arr, m+1, r);
        }
    }

    static int partition(int[] arr, int l, int r){
        int pivot = arr[r];
        int i = l;
        for(int j=l; j < r; j++)
            if(arr[j] < pivot)
                swap(arr, i++, j);
        swap(arr, i, r);
        return i;
    }
    // quick sort end ***********************************

    // merge sort start *********************************
    static void mergeSort(int[] arr){
        mergesort(arr, 0, arr.length-1);
        printArray(arr);
    }

    static void mergesort(int[] arr, int l, int r){
        if(l < r){
            int m = l + (r-l)/2;
            mergesort(arr, l, m);
            mergesort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r){
        int n1 = m-l+1, n2 = r-m;

        int[] L = new int[n1], R = new int[n2];

        for(int i=0; i<n1; i++)
            L[i] = arr[l+i];
        for(int i=0; i<n2; i++)
            R[i] = arr[m+i+1];

        int i = 0, j = 0, k = l;

        while(i<n1 && j<n2){
            if(L[i] <= R[j])
                arr[k] = L[i++];
            else
                arr[k] = R[j++];
            k++;
        }
        while(i<n1)
            arr[k++] = L[i++];
        while(j<n2)
            arr[k++] = R[j++];
    }
    // merge sort end ***********************************

    static void heapSort(int[] arr){

    }

    static void countSort(int[] arr){
        int min = 0, max = Integer.MIN_VALUE;
        for(int i: arr){
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        min = Math.abs(min);
        
        int count[] = new int[max + min + 1];
        for(int i: arr)
            count[i+min]++;
        for(int i=1; i<count.length; i++)
            count[i] += count[i-1];
        
        int output[] = new int[arr.length];
        for(int i = arr.length - 1; i>=0; i--)
            output[count[arr[i] + min] - 1] = arr[i];
        
        printArray(output);
    }

    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        int choice, size;
        int[] arr = new int[]{-5, 2, 10, -70, 90};
        do{
            System.out.print("\n1. New Array\t\t2. Print Array\n3. Selection Sort\t4. Bubble Sort\n5. Insertion Sort\t6. Quick Sort\n7. Merge Sort\t\t8. Heap Sort\n9. Count Sort\n\nEnter Choice: ");
            choice = obj.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter Size: "); 
                    size = obj.nextInt();
                    arr = new int[size];
                    System.out.println("Enter elemets:");
                    for(int i=0; i<size; i++)
                        arr[i] = obj.nextInt();
                    break;
                case 2:
                    printArray(arr); break;
                case 3:
                    selectionSort(arr.clone()); break;
                case 4:
                    bubbleSort(arr.clone()); break;
                case 5:
                    insertionSort(arr.clone()); break;
                case 6:
                    quickSort(arr.clone()); break;
                case 7:
                    mergeSort(arr.clone()); break;
                case 8:
                    break;
                case 9:
                    countSort(arr); break;
            }
        }while(choice>0 && choice<10);
        obj.close();
    }
}
