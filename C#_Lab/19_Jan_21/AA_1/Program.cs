using System;

namespace AA_1
{
    class Program
    {
        static void Main(string[] args)
        {
            Employee employee = new Employee();
            salcomm sal = new salcomm();
            Hourly hourly = new Hourly();
            Commissioned commissioned = new Commissioned();
            Salaried salaried = new Salaried();

            employee.name = "A";
            employee.id = 1;
            employee.basic_sal = 15000;

            salaried.name = "B";
            salaried.id = 2;
            salaried.basic_sal = 15000;

            hourly.name = "C";
            hourly.id = 3;
            hourly.hours = 50;
            hourly.ren_h = 500;

            commissioned.name = "D";
            commissioned.id = 4;
            commissioned.article_nu = 10;
            commissioned.unit_price = 500;
            commissioned.comm_rate = 10;

            sal.name = "E";
            sal.id = 5;
            sal.article_nu = 10;
            sal.unit_price = 500;
            sal.comm_rate = 10;
            sal.basic_sal = 15000;

            Console.WriteLine(employee.id+"  " + employee.name+"  " +employee.calculate_salary());
            Console.WriteLine(salaried.id+"  " + salaried.name+"  " +salaried.calculate_salary());
            Console.WriteLine(hourly.id+"  " + hourly.name+"  " +hourly.calculate_salary());
            Console.WriteLine(commissioned.id+"  " + commissioned.name+"  " +commissioned.calculate_salary());
            Console.WriteLine(sal.id+"  " + sal.name+"  " +sal.calculate_salary());
        }
    }
}