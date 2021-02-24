import java.util.*;
import java.io.*;

public class GP_1 {
    static Set<Character> vow = new HashSet<>();

    public static void main(String[] args) throws IOException{
        for(char i: new char[]{'a','e','i','o','u','A','E','I','O','U'})
            GP_1.vow.add(i);
        BufferedReader br = new BufferedReader(new FileReader("inputFile.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("outputFile1.txt"));

        String line;
        
        // using FileReader and FileWriter
        while((line=br.readLine())!=null){
            int v=0, c=0, s=0;
            for(int i=0;i<line.length();i++)
                if(Character.isAlphabetic(line.charAt(i))){
                    if(vow.contains(line.charAt(i))) v++;
                    else c++;
                }else if(line.charAt(i)==' ') s++;
            bw.write(String.format("%s(vowels-%d, consonants-%d, space-%d)\n", line, v, c, s));
        }
        br.close();
        bw.close();
    }
}
