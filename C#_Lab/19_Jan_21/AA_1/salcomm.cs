using System;

class salcomm:Salaried{
    public int article_nu;
    public double unit_price;
    public double comm_rate;
    public double calculate_salary(){
        return base.calculate_salary() + article_nu*unit_price*comm_rate/100;
    }
}