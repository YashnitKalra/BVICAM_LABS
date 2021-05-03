import java.util.Arrays;

public class BP_4 {
    public static void main(String[] args){
        String s1 = "This is String 1";
        String s2 = "This is String 2";
        String s3 = "This is String 1";
        System.out.printf("String s1: %s\nString s2: %s\nString s3: %s\n", s1, s2, s3);
        System.out.printf("Character at index 5 of String s1: %s\n", s1.charAt(5));
        System.out.printf("Check if String s1 contains \"hello\": %b\n", s1.contains("hello"));
        System.out.printf("Using equals():\ns1 and s2 are equal: %b\ns1 and s3 are equal: %b\n", s1.equals(s2), s1.equals(s3));
        System.out.printf("Using ==:\ns1 and s2 are equal: %b\ns1 and s3 are equal: %b\n", s1==s2, s1==s3);
        System.out.printf("Checking index of \"ing\" in s1 using indexOf: %d\n", s1.indexOf("ing"));
        System.out.printf("Splitting s1 with space: %s\n", Arrays.toString(s1.split(" ")));
        System.out.printf("Upper Case of s1: %s\n", s1.toUpperCase());
    }
}
