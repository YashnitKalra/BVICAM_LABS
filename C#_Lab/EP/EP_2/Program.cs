using System;

namespace EP_2
{
    class Program
    {
        static int ReadNumber(int start, int end){
            Console.Write("Enter Number in range [{0},{1}]: ",start,end);
            int num = int.Parse(Console.ReadLine());
            if(num<start || num>end)
                throw new Exception("Number out of range");
            return num;
        }
        static void Main(string[] args)
        {
            try{
                int[] arr = new int[11];
                arr[0] = -1;
                for(int i=1;i<11;i++){
                    arr[i] = ReadNumber(arr[i-1]+1, 100);
                }
            }catch(Exception e){
                Console.WriteLine(e.Message);
            }
        }
    }
}
