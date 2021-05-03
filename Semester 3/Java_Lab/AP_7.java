import java.util.Scanner;

class AP_7{
    public static void main(String[] args){
        System.out.print("Enter Sentence: ");
        String s = new Scanner(System.in).nextLine();
        int start = 0,end=0;
        for(int i=0;i<s.length();i++){
            if(Character.isAlphabetic(s.charAt(i))){
                int j=i+1;
                while(j<s.length() && Character.isAlphabetic(s.charAt(j)))
                    j++;
                for(int k=j-1;k>=i;k--)
                    System.out.print(s.charAt(k));
                i=j-1;
            }
            else System.out.print(s.charAt(i));
        }
        System.out.println();       
    }
}