import java.util.*;

class Student implements Comparable<Student>{
    String name;
    int rno;
    Student(String name, int rno){
        this.name = name; this.rno = rno;
    }

    public int compareTo(Student s){
        return this.rno - s.rno;
    }

    public String toString(){
        return name+" "+rno;
    }
}

class NameCompare implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return s1.name.compareTo(s2.name);
    }
}

public class BP_7 {
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = Integer.parseInt(obj.nextLine());
        Student studs[] = new Student[n];
        String temp[];
        for(int i=0;i<n;i++){
            System.out.printf("Enter name and roll number of student %d: ", i+1);
            temp = obj.nextLine().split(" ");
            studs[i] = new Student(temp[0], Integer.parseInt(temp[1]));
        }
        System.out.println("Sorting according to Roll Number using Comparable");
        Arrays.sort(studs);
        for(Student s: studs)
            System.out.println(s);

        NameCompare nameComp = new NameCompare();
        System.out.println("Sorting according to Name using Comparator");
        Arrays.sort(studs, nameComp);
        for(Student s: studs)
            System.out.println(s);
    }
}