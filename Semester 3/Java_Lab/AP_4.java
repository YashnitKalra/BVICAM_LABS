import java.util.*;

class AP_4{
    public static void main(String[] args){
        String text = "To be or not to be, that is the question;"
        +"Whether this nobler in the mind to suffer"
        +" the slings and arrows of outrageous fortune,"
        +" or to take arms against a sea of troubles,"
        +" and by opposing end them?";
        int spaces = 0, vowels = 0, letters = 0;
        
        Set<Character> vow = new HashSet<>();
        for(char i: new char[]{'a','e','i','o','u','A','E','I','O','U'})
            vow.add(i);

        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i)==' ')
                spaces++;
            else if(text.charAt(i)>='a' && text.charAt(i)<='z' || text.charAt(i)>='A' && text.charAt(i)<='Z'){
                if(vow.contains(text.charAt(i)))
                    vowels++;
                letters++;
            }
        }

        System.out.printf("The text contained :-\nVowels: %d\nConsonants: %d\nSpaces: %d\n", vowels, letters-vowels, spaces);
    }
}