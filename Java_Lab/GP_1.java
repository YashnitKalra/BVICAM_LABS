import java.util.*;
import java.io.*;

public class GP_1 {
    static Set<Character> vow = new HashSet<>();

    public static int[] count(StringTokenizer s){
        int c[] = {0, 0, 0};    // vowels consonants spaces
        while(s.hasMoreTokens()){
            c[2]++;
            String temp = s.nextToken();
            for(int i=0; i<temp.length(); i++)
                if(Character.isAlphabetic(temp.charAt(i))){
                    if(vow.contains(temp.charAt(i)))
                        c[0]++;
                    else c[1]++;
                }
        }
        c[2] = Math.max(0, c[2]-1);     // spaces are one less than the number of words
        return c;
    }
    public static void main(String[] args) throws IOException{
        for(char i: new char[]{'a','e','i','o','u','A','E','I','O','U'})
            GP_1.vow.add(i);
        FileReader fr = new FileReader("inputFile.txt");
        FileWriter fw = new FileWriter("outputFile1.txt");

        String line;
        char a[] = new char[1];
        
        // using FileReader and FileWriter
        while(fr.read(a)!=-1){
            
        }

        fr.close();
        fw.close();
    }
}
