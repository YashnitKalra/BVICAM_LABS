import java.util.Scanner;

public class CP_3 {
    public static boolean isPalindrome(String text){
        String s = text.toLowerCase();
        for(int i=0,j=s.length()-1;i<j;i++,j--)
            if(s.charAt(i)!=s.charAt(j))
                return false;
        return true;
    }
    public static void main(String[] args){
        System.out.print("Enter String: ");
        String s = new Scanner(System.in).nextLine();
        System.out.printf("%s is%s a palindrome\n", s, isPalindrome(s)?"":" not");
    }
}