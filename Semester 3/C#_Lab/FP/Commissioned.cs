using System;

class Commissioned:Employee{
    public int articles;
    public double unit_price;

    public int Articles{
        get{ return articles; }
        set {
            if(unit_price*value*0.1<=20000)
                articles = value;
            else
                Console.WriteLine("Comission cannot exceed Rs. 20000");
        }
    }
    public double Unit_price{
        get{ return unit_price; }
        set {
            if(articles*value*0.1<=20000)
                unit_price = value;
            else
                Console.WriteLine("Comission cannot exceed Rs. 20000");
        }
    }

    public double getCommision(){
        return articles*unit_price*0.1;
    }

}