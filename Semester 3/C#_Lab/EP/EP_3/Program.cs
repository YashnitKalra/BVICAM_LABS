using System;
using System.IO;

namespace EP_3
{
    class Program
    {
        static void Main(string[] args)
        {
            try{
                string filename = args[0];
                string text = File.ReadAllText(filename);
                Console.Write(text);
            }catch(FileNotFoundException e){
                Console.WriteLine(e.Message);
            }catch(IOException e){
                Console.WriteLine(e.Message);
            }catch(Exception e){
                Console.WriteLine(e.Message);
            }
        }
    }
}
