import java.util.*;

class Result{
    String Rollno, Semester;
    float marks[];
    Result(String Rollno, String Semester, float marks[]){
        this.Rollno = Rollno; this.Semester = Semester; this.marks = marks;
    }
    public String toString(){
        float sum=0f;
        StringBuffer res = new StringBuffer();
        res.append(String.format("RollNo: %s\n", Rollno));
        res.append(String.format("Sem: %s |",Semester));
        for(float m:marks){
            sum += m;
            res.append(" "+m);
        }
        res.append(" | "+sum);
        res.append("\nTotal: "+sum/marks.length);
        return res.toString();
    }
}

public class EP_1 {
    public static void main(String[] args){
        TreeSet<Result> set = new TreeSet<>(new Comparator<Result>(){
            public int compare(Result a, Result b){
                int res1 = a.Semester.compareTo(b.Semester);
                if(res1==0)
                    return a.Rollno.compareTo(b.Rollno);
                return res1;
            }
        });

        // Creating Result Objects
        for(int sem=1;sem<5;sem++){
            for(int rno=1;rno<=2;rno++){
                float marks[] = new float[5];
                for(int i=0;i<5;i++)
                    marks[i] = (float)Math.random() * 100;
                set.add(new Result(Integer.toString(rno), Integer.toString(sem), marks));
            }
        }

        for(Result r: set)
            System.out.println(r);
    }
}
