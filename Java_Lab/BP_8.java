import java.util.Arrays;

public class BP_8 {
    public static void main(String[] args){
        float marks[][] = new float[10][5];
        for(int i=0;i<10;i++)
            for(int j=0;j<5;j++)
                marks[i][j] = (float)Math.random()*100;
        int index=0;
        float avgMarks = 0;
        for(int i=0;i<10;i++){
            System.out.printf("Student %d: %s\n", i+1, Arrays.toString(marks[i]));
            float s=0;
            for(int j=0;j<5;j++)
                s+=marks[i][j];
            s/=5;
            if(avgMarks<s){
                avgMarks = s;
                index = i;
            }
        }
        System.out.printf("Best student according to average marks:\nStudent %d %s = %f\n",(index+1), Arrays.toString(marks[index]), avgMarks);
    }
}
