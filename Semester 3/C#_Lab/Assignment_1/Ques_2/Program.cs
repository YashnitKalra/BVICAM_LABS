using System;

namespace Ques_2
{

    class Human{
        string first_name, last_name;
        public string First_name{
            get{ return first_name; }
            set{ first_name=value; }
        }
        public string Last_name{
            get{ return last_name; }
            set{ last_name=value; }
        }
    }

    class Student:Human{
        int mark;
        public int Mark{
            get{ return mark; }
            set{ mark=value; }
        }
        public Student(string first_name, string last_name, int mark){
            First_name = first_name;
            Last_name = last_name;
            Mark = mark;
        }
    }

    class Worker:Human{
        double wage;
        int hours_worked;
        public int Hours_worked{
            get{ return hours_worked; }
            set{ hours_worked=value; }
        }
        public double Wage{
            get{ return wage; }
            set{ wage=value; }
        }

        public Worker(string first_name, string last_name, int hours_worked, double wage){
            First_name = first_name;
            Last_name = last_name;
            Hours_worked = hours_worked;
            Wage = wage;
        }

        public double calculateHourlyWage(){
            return wage/hours_worked;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Student s = new Student("ABC", "SRT", 85);
            Worker w = new Worker("XYZ", "PQR", 5, 2100);
            Console.WriteLine("Student Name: {0} {1}, Marks: {2}",s.First_name,s.Last_name,s.Mark);
            Console.WriteLine("Worker Name: {0} {1}, Pay Rate: Rs. {2}/hr",w.First_name,w.Last_name,w.calculateHourlyWage());
        }
    }
}