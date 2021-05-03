import java.io.*;
import java.util.*;

class Time implements Serializable{
    private String font, color;
    public Time(){
        font = ""; color = "";
    }
    public String getFont(){return font;}
    public void setFont(String font){this.font = font;}
    public String getColor(){return color;}
    public void setColor(String color){this.color = color;}
    public void printTime(){
        Date obj = new Date();
        System.out.printf("%d:%d:%d\b\b\b\b\b\b\b\b", obj.getHours(), obj.getMinutes(), obj.getSeconds());
    }
}

public class IP_2 {
    public static void main(String[] args) throws Exception{
        Time t = new Time();
        for(;;){
            t.printTime();
            Thread.sleep(1000);
        }
    }
}
