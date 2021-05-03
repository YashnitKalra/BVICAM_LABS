using System;

namespace _12_Jan_21
{
    class Program
    {
        static void Main(string[] args)
        {
            byte b = 10;
            b++;
            byte c = 10;
            byte d = (byte)(b + c);
            Console.WriteLine(d);
            float f = 2.78F;
            double e = 2.78;
            decimal g = 2.78m;
            Console.WriteLine(f);
            Console.WriteLine(e);
            Console.WriteLine(g);
            string str = "Hello World";
            Console.WriteLine(str);
            var i = "hello";
            Console.WriteLine(i.GetType());
            object o = b;
            b++;
            Console.WriteLine(b);
            Console.WriteLine(o);
        }
    }
}
