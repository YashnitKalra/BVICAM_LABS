using System;

namespace FP
{
    class Program
    {
        static void Main(string[] args)
        {
            salcomm sal = new salcomm();
            Hourly hourly = new Hourly();
            Commissioned commissioned = new Commissioned();
            Salaried salaried = new Salaried();

            salaried.Name = "B";
            salaried.Id = 2;
            salaried.Salary = 15000;

            hourly.Name = "C";
            hourly.Id = 3;
            hourly.Hours = 50;
            hourly.Payment = 400;

            commissioned.Name = "D";
            commissioned.Id = 4;
            commissioned.Articles = 10;
            commissioned.Unit_price = 500;

            sal.Name = "E";
            sal.Id = 5;
            sal.Articles = 10;
            sal.Unit_price = 500;
            sal.Salary = 15000;

            Console.WriteLine(salaried.Id+"  " + salaried.Name+"  " +salaried.Salary);
            Console.WriteLine(hourly.Id+"  " + hourly.Name+"  " +hourly.getSalary());
            Console.WriteLine(commissioned.Id+"  " + commissioned.Name+"  " +commissioned.getCommision());
            Console.WriteLine(sal.Id+"  " + sal.Name+"  " +sal.getIncome());
        }
    }
}