using System;

namespace fib_delegate
{
    public delegate int DelFib(int n);

    class Program
    {
        static void Main(string[] args)
        {
            DelFib f = null;
            f = delegate(int n){
                if(n==0)
                    return 1;
                return n*f(n-1);
            };
            Console.WriteLine(f(0));
            Console.WriteLine(f(4));
            Console.WriteLine(f(7));
            Console.WriteLine(f(10));
        }
    }
}
