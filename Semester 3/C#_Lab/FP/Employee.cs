using System;

class Employee{
    public string name;
    public int id;
    public int age;

    public int Id{
        get{ return id; }
        set { id = value; }
    }
    public string Name{
        get{ return  name; }
        set{ name = value; }
    }
    public int Age{
        get{ return age; }
        set{
            if(age>=18 && age<=60)
                age = value;
            else
                Console.WriteLine("Invalid Age");
        }
    }
}