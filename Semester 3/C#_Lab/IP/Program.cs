using System;
using System.Collections.Generic;

namespace IP
{
    public class Employee{
        static int count=0;
        public int id,salary,age;
        public string name,department;
        public Employee(string name, int age, int salary, string department){
            this.id = ++count; this.salary = salary; this.age = age; this.name = name; this.department = department;
        }
        public override string ToString(){
            return $"Employee ID: {id}\tName: {name}\tAge: {age}\tSalary: {salary}\tDepartment: {department}";
        }
    }

    public class MyList<T>:List<T>{
        public MyList():base(){}
        public void Add(T obj){
            base.Add(obj);
        }
        public T Find(Predicate<T> p){
            return base.Find(p);
        }
        public List<T> FindAll(Predicate <T> p){
            return base.FindAll(p);
        }
        public int IndexOf(T obj){
            return base.IndexOf(obj);
        }
        public int LastIndexOf(T obj){
            return base.LastIndexOf(obj);
        }
        public int FindIndex(Predicate<T> p){
            return base.FindIndex(p);
        }
        public bool Remove(T obj){
            return base.Remove(obj);
        }
        public int RemoveAll(Predicate<T> match){
            return base.RemoveAll(match);
        }
    }

    class Program
    {
        static string input(string msg){
            Console.Write(msg);
            return Console.ReadLine();
        }

        static void Main(string[] args){
            MyList<Employee> ml = new MyList<Employee>();
            Employee emp;
            int n, choice;
            string[] temp;
            string t;
            do{
                Console.Write("\n*****MENU*****\n1. Add Employee\t\t2. Find Employee\t\t3. Find Employees\t4. Find Employee Index\n5. Index of Employee\t6. Last Index of Employee\t7. Remove Employee\t8. Remove Employees\nEnter Choice: ");
                choice = int.Parse(Console.ReadLine());
                switch (choice){
                    case 1:
                        n = int.Parse(input("Enter number of employees: "));
                        for(int i=0;i<n;i++){
                            temp = input("Enter Employee Details (Name Age Salary Department): ").Split(" ");
                            ml.Add(new Employee(temp[0], int.Parse(temp[1]), int.Parse(temp[2]), temp[3]));
                        }
                        break;
                    case 2:
                        t = input("Employee Name Contains: ");
                        Console.WriteLine(ml.Find(delegate(Employee e){return e.name.Contains(t);}));
                        break;
                    case 3:
                        t = input("Employee Name Contains: ");
                        foreach(Employee obj in ml.FindAll(delegate(Employee e){return e.name.Contains(t);}))
                            Console.WriteLine(obj);
                        break;
                    case 4:
                        t = input("Employee Name Contains: ");
                        Console.WriteLine($"Index: {ml.FindIndex(delegate(Employee e){return e.name.Contains(t);})}");
                        break;
                    case 5:
                        temp = input("Enter Employee Details (Name Age Salary Department): ").Split(" ");
                        emp = new Employee(temp[0], int.Parse(temp[1]), int.Parse(temp[2]), temp[3]);
                        emp = ml.Find(e => (e.name.CompareTo(emp.name)==0 && e.salary==emp.salary && e.age==emp.age && e.department.CompareTo(emp.department)==0));
                        Console.WriteLine($"Index: {ml.IndexOf(emp)}");
                        break;
                    case 6:
                        temp = input("Enter Employee Details (Name Age Salary Department): ").Split(" ");
                        emp = new Employee(temp[0], int.Parse(temp[1]), int.Parse(temp[2]), temp[3]);
                        emp = ml.Find(e => (e.name.CompareTo(emp.name)==0 && e.salary==emp.salary && e.age==emp.age && e.department.CompareTo(emp.department)==0));
                        Console.WriteLine($"Index: {ml.LastIndexOf(emp)}");
                        break;
                    case 7:
                        temp = input("Enter Employee Details (Name Age Salary Department): ").Split(" ");
                        emp = new Employee(temp[0], int.Parse(temp[1]), int.Parse(temp[2]), temp[3]);
                        emp = ml.Find(e => (e.name.CompareTo(emp.name)==0 && e.salary==emp.salary && e.age==emp.age && e.department.CompareTo(emp.department)==0));
                        Console.WriteLine($"Removed: {ml.Remove(emp)}");
                        break;
                    case 8:
                        t = input("Employee Name Contains: ");
                        Console.WriteLine($"Removed: {ml.RemoveAll(e => e.name.Contains(t))}");
                        break;
                }
            }while(choice>=1 && choice<=8);
        }
    }
}