using System;

class Salaried:Employee{
    public double salary;

    public double Salary{
        get{ return salary; }
        set {
            if(value>=4000 && value<=20000)
                salary = value;
            else
                Console.WriteLine("Invalid Salary");
        }
    }
}