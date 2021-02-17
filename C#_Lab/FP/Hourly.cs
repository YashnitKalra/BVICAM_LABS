using System;

class Hourly:Employee{
    public double hours;
    public double payment;

    public double Hours{
        get{ return hours; }
        set {
            if(value>=30 && value<=50)
                hours = value;
            else
                Console.WriteLine("Invalid Hours");
        }
    }
    public double Payment{
        get{ return payment; }
        set {
            if(value>=200 && value<=400)
                payment = value;
            else
                Console.WriteLine("Invalid Payment");
        }
    }

    public double getSalary(){return Hours*Payment;}
}