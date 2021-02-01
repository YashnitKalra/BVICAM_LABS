abstract class Student  {
    String name = "ABC";
    abstract void printName();
}

interface Student2{
    String name = "XYZ";
    void printName();
}

public class CP_6 {
    public static void main(String[] args){
        Student s = new Student(){
            @Override
            void printName() {System.out.println(name);};
        };
        s.printName();
        
        Student2 s2 = new Student2(){
            @Override
            public void printName(){System.out.println(name);};
        };
        s2.printName();
    }
}
