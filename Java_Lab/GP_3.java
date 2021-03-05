import java.io.*;
import java.util.*;

class Student implements Externalizable{
    private static final long serialVersionUid = 10l;
    int id;
    String name, phone;
    transient String school;
    
    public Student(){}

    Student(int id, String name, String phone, String school){
        this.id = id; this.name = name; this.phone = phone; this.school = school;
    }

    public String toString(){
        return String.format("ID: %d, Name: %s, Phone: %s, School: %s", id, name, phone, school);
    }

    public void writeExternal(ObjectOutput out) throws IOException{
        out.writeInt(id); out.writeObject(name); out.writeObject(phone);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException{
        id = in.readInt(); name = (String)in.readObject(); phone = (String)in.readObject();
    }
}

class IdSort implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return s1.id - s2.id;
    }
}

class NameSort implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return s1.name.compareTo(s2.name);
    }
}

public class GP_3 {
    public static void main(String[] args) throws Exception{
        Student s[] = new Student[]{new Student(2, "pqr", "999999999", "PQR School"), new Student(1, "xyz", "888888888", "XYZ School")};
        FileOutputStream fos = new FileOutputStream("studentSerialize.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s[0]); oos.writeObject(s[1]);
        oos.close(); fos.close();

        FileInputStream fis = new FileInputStream("studentSerialize.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s[0] = (Student)ois.readObject(); s[1] = (Student)ois.readObject();
        ois.close();

        System.out.println("Sort according to ID:");
        Arrays.sort(s, new IdSort());
        System.out.println(s[0]+"\n"+s[1]);

        System.out.println("\nSort according to Name:");
        Arrays.sort(s, new NameSort());
        System.out.println(s[0]+"\n"+s[1]);
    }
}