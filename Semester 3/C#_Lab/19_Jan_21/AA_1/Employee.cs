using System;

class Employee{
    public string name;
    public int id;
    public double basic_sal;
    public double net_sal;
    public double calculate_salary(){
        // net_sal = basic_sal + da + hra + ta
        // da = basic_sal * 1.5
        // hra = basic_sal * 0.3
        // ta = basic_sal * 0.1
        return basic_sal + basic_sal*1.5 + basic_sal*0.3 + basic_sal*0.1;
    }
}