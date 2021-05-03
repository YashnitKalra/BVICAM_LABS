using System;

class Commissioned:Employee{
    public int article_nu;
    public double unit_price;
    public double comm_rate;
    public double calculate_salary(){
        return article_nu*unit_price*comm_rate/100;
    }
}