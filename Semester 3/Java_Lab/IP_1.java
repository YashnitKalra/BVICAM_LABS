import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.rmi.registry.*;
import java.io.*;

class Student implements Serializable{
    private static final long serialVersionUid = 10l;
    int rno;
    String name, course;
    Student(int rno, String name, String course){
        this.rno = rno; this.name = name; this.course = course;
    }
    public String toString(){
        return String.format("Roll Number: %d\tName: %s\tCourse: %s", rno, name, course);
    }
}

interface SchoolInterface extends Remote{
    public void admit(Student stud) throws RemoteException;
    public String search(int rno) throws RemoteException;
}

class School extends UnicastRemoteObject implements SchoolInterface{
    List<Student> students;
    
    School() throws RemoteException{
        super();
        students = new ArrayList<>();
    }

    public void admit(Student stud) throws RemoteException{
        students.add(stud);
        System.out.println("Student Admitted Successfully");
    }

    public String search(int rno) throws RemoteException{
        System.out.println("Roll Number requested: "+rno);
        for(Student s:students)
            if(s.rno==rno){
                System.out.println("Student Found");
                return s.toString();
            }
        try{
            throw new RemoteException("Invalid Roll Number");
        }catch(RemoteException re){
            System.out.println("Student Not Found");
            return re.getMessage();
        }
    }
}

public class IP_1{
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        String temp[];
        System.out.print("1. Server\n2. Client\nEnter Choice: ");
        int ch = Integer.parseInt(obj.nextLine());
        if(ch==1){  // SERVER
            try{
                School school = new School();
                LocateRegistry.createRegistry(1900);
                Naming.rebind("rmi://localhost:1900/school", school);
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ch==2){    // CLIENT
            try{
                SchoolInterface school = (SchoolInterface)Naming.lookup("rmi://localhost:1900/school");
                do{
                    System.out.print("\n1. Admit Student\n2. Search Student\nEnter Choice: ");
                    ch = Integer.parseInt(obj.nextLine());
                    switch(ch){
                        case 1:
                            System.out.print("Enter Student Details (Roll_Number Student_Name Course): ");
                            temp = obj.nextLine().split(" ");
                            school.admit(new Student(Integer.parseInt(temp[0]), temp[1], temp[2]));
                            break;
                        case 2:
                            System.out.print("Enter Roll Number: ");
                            System.out.println(school.search(Integer.parseInt(obj.nextLine())));
                            break;
                    }
                }while(ch>=1 && ch<=2);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
}