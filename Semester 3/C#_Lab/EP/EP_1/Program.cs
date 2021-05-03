using System;

namespace EP_1
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter a Positive Number: ");
            try{
                int num = int.Parse(Console.ReadLine());
                if(num<0)
                    throw new Exception("Squre Root of negative number is imaginary");
                Console.WriteLine("Sqaure Root of {0} is {1}", num, Math.Sqrt(num));
            }catch(Exception e){
                Console.WriteLine(e.Message);
            }finally{
                Console.WriteLine("Good Bye");
            }
        }
    }
}