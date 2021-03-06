﻿using System;

namespace HP
{
    public delegate void DisplayIndex(int[] arr, int num); // HP 1
    public delegate void DisplayElements(int[] arr); // HP 2
    public delegate void SortAndDisplay(int[] arr); // HP 4
    public delegate string AddExample();

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
            Console.Write("Array: ");
            foreach(int i in arr)
                Console.Write(i+" ");
            Console.Write("\n");
        }

        static string getMessage1(){
            Console.Write("Hello ");
            return "Hello";
        }

        static string getMessage2(){
            Console.Write("World ");
            return "World";
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

            // HP 3
            AddExample d3 = Program.getMessage1;
            d3 += getMessage2;
            Console.WriteLine($"\nAdd Delegate Returned: {d3()}");

            // HP 4
            SortAndDisplay d4 = delegate(int[] arr){
                for(int i=0;i<arr.Length;i++){
                    for(int j=0;j<arr.Length-i-1;j++){
                        if(arr[j]>arr[j+1]){
                            arr[j] ^= arr[j+1]; arr[j+1] ^= arr[j]; arr[j] ^= arr[j+1];
                        }
                    }
                }
                Console.Write("Sorted Array: ");
                foreach(int i in arr)
                    Console.Write(i+" ");
                Console.Write("\n");          
            };
            d4(arr);

            // HP 5
            Console.WriteLine($"Found -7 in array: {Temp.Search(arr, -7)}");
        }
    }
}