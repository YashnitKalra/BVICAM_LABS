using System;

class Hourly:Employee{
    public double hours;
    public double ren_h;
    public double calculate_salary(){
        if(hours>40){
            return 40*ren_h;
        }else{
            return hours*ren_h;
        }
    }
}