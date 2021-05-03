import java.util.*;

class Employee{
    static int counter=0;
    int id, salary, age;
    String name;
    Date joining;
    public Employee(int salary, int age, String name, Date joining){
        this.id = ++counter; this.salary = salary;
        this.age = age; this.name = name;
        this.joining = joining;
    }

    static void printEmployees(List<Employee> list){
        System.out.println("ID\tName\tAge\tJoining Date\t\t\tSalary");
        for(Employee e: list)
            System.out.printf("%d\t%s\t%d\t%s\t%d\n", e.id, e.name, e.age, e.joining.toString(), e.salary);
        System.out.println();
    }
}

class EP_2{

    public static Employee createEmployeeObject(Scanner obj){
        System.out.print("\nEnter Name: "); String name = obj.next();
        System.out.print("Enter Age: "); int age = obj.nextInt();
        System.out.print("Enter Joining Date (YY MM DD): ");
        Date joinDate = new Date(obj.nextInt(), obj.nextInt(), obj.nextInt());
        System.out.print("Enter Salary: "); int sal = obj.nextInt();
        System.out.println();
        return new Employee(sal, age, name, joinDate);
    }
    public static void main(String[] args){
        List<Employee> list = new ArrayList<>();
        Scanner obj = new Scanner(System.in);
        int choice;
        do{
            System.out.print("1. Create New Employee\n2. Sort according to name\n3. Sort according to age\n4. Sort according to salary\n5. Sort according to date of joining\nEnter Choice: ");
            choice = obj.nextInt();
            switch(choice){
                case 1:
                    list.add(createEmployeeObject(obj)); break;
                case 2:
                    Collections.sort(list, (a,b)->{return a.name.compareTo(b.name);}); Employee.printEmployees(list); break;
                case 3:
                    Collections.sort(list, (a,b)->{return a.age-b.age;}); Employee.printEmployees(list); break;
                case 4:
                    Collections.sort(list, (a,b)->{return a.salary-b.salary;}); Employee.printEmployees(list); break;
                case 5:
                    Collections.sort(list, (a,b)->{return a.joining.compareTo(b.joining);}); Employee.printEmployees(list); break;
            }
        }while(choice>=1 && choice<=5);
    }
}