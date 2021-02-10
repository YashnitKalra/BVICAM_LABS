using System;

namespace CP
{
    class Program
    {
        static void Main(string[] args)
        {
            GSM gsm = new GSM();
            int choice;
            do{
                Console.WriteLine("\n1. Add Call\n2. Delete Call\n3. Clear History\n4. Print History\n5. Calculate Amount\nEnter Choice: ");
                choice = Convert.ToInt16(Console.ReadLine());
                switch(choice){
                    case 1:
                        Console.WriteLine("Enter Date Time of Call (YYYY MM DD hh mm ss): ");
                        string[] temp = Console.ReadLine().Split(" ");
                        int[] arr = new int[temp.Length];
                        for(int i=0;i<arr.Length;i++)
                            arr[i] = Convert.ToInt32(temp[i]);
                        Console.WriteLine("Enter Duration (in sec): ");
                        long d = Convert.ToInt32(Console.ReadLine());
                        gsm.AddCall(new DateTime(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]), d);
                        break;
                    case 2:
                        gsm.Delete(); break;
                    case 3:
                        gsm.DeleteAll(); break;
                    case 4:
                        gsm.PrintHistory(); break;
                    case 5:
                        Console.WriteLine("Enter Price (in Rs/sec): ");
                        float price = float.Parse(Console.ReadLine());
                        gsm.CalcAmount(price); break;
                }
            }while(choice>0 && choice<6);
        }
    }
}