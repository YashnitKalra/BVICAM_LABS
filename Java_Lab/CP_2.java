import java.util.*;

public class CP_2 {
    public static StringBuffer caesarCipher(String s, int shift){
        StringBuffer res = new StringBuffer(s.length());
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                if(Character.isUpperCase(s.charAt(i)))
                    res.append((char)((s.charAt(i)-65+shift)%26 + 65));
                else
                    res.append((char)((s.charAt(i)-97+shift)%26 + 97));
            }else res.append(s.charAt(i));
        }
        return res;
    }
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter string consisting of only alphabets: ");
        String s = obj.nextLine();
        System.out.print("Enter shift value: "); int shift = Integer.parseInt(obj.nextLine());
        System.out.println("Ceasar Ciphered String: "+ caesarCipher(s, shift));
    }
}
