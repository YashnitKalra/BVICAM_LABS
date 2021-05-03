using System;
using System.IO;

namespace EP_4
{
    class Program
    {
        static void WriteFile(string source, string dest){
            File.Copy(source, dest);
        } 
        static void Main(string[] args)
        {
            string filename = args[0];
            byte[] arr = File.ReadAllBytes(filename);
            foreach(byte b in arr)
                Console.Write("{0} ",b);
            Console.Write("\n");
            WriteFile(filename, "demoBinaryFile2.bin");
        }
    }
}
