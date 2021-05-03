using System;

class salcomm:Employee{
    public int articles;
    public double unit_price;
    public double salary;
    
    public double Salary{
        get{ return salary; }
        set {
            double temp = value + articles*unit_price*0.1;
            if(temp<=25000)
                salary = value;
            else
                Console.WriteLine("Error: Total Income Exceeded 25k/week");
        }
    }
    public int Articles{
        get{ return articles; }
        set {
            double temp = salary + value*unit_price*0.1;
            if(temp<=25000)
                articles = value;
            else
                Console.WriteLine("Error: Total Income Exceeded 25k/week");
        }
    }
    public double Unit_price{
        get{ return unit_price; }
        set {
            double temp = salary + articles*value*0.1;
            if(temp<=25000)
                unit_price = value;
            else
                Console.WriteLine("Error: Total Income Exceeded 25k/week");
        }
    }

    public double getIncome(){return salary + articles*unit_price*0.1;}
}