using System;

namespace HP
{
    public delegate void DisplayIndex(int[] arr, int num); // HP 1
    public delegate void DisplayElements(int[] arr); // HP 2
    public delegate void SortAndDisplay(int[] arr); // HP 4

    class Temp{
        public static Func<int[], int, bool> Search = (arr, num) => {
            foreach(int i in arr)
                if(i==num) return true;
            return false;
        };
    }

    class Program
    {
        static void Index(int[] arr, int num){
            for(int i=0;i<arr.Length;i++)
                if(arr[i]==num){
                    Console.WriteLine("Index of {0} is {1}", num, i); break;
                }
        }

        static void Display(int[] arr){
            foreach(int i in arr)
                Console.Write(i+" ");
            Console.Write("\n");
        }

        static void Main(string[] args)
        {
            int[] arr = {5,2,8,1,-8};
            // HP 1
            DisplayIndex d1 = Program.Index;
            d1(arr, 1);

            // HP 2
            DisplayElements d2 = Program.Display;
            d2(arr);

            // HP 4
            SortAndDisplay d4 = delegate(int[] arr){
                for(int i=0;i<arr.Length;i++){
                    for(int j=0;j<arr.Length-i-1;j++){
                        if(arr[j]>arr[j+1]){
                            arr[j] ^= arr[j+1]; arr[j+1] ^= arr[j]; arr[j] ^= arr[j+1];
                        }
                    }
                }
                foreach(int i in arr)
                    Console.Write(i+" ");
                Console.Write("\n");          
            };
            d4(arr);

            // HP 5
            Console.WriteLine(Temp.Search(arr, -8));
        }
    }
}
