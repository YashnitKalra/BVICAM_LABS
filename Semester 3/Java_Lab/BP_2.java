import java.util.*;

public class BP_2 {
    public static void main(String[] args){
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Integer> time = new ArrayList<>();
        Scanner obj = new Scanner(System.in);
        String temp[] = obj.nextLine().split(" ");
        while(temp.length==2){
            name.add(temp[0]); time.add(Integer.parseInt(temp[1]));
            temp = obj.nextLine().split(" ");
        }
        String s1="", s2="";
        int t1=10000, t2=10000;
        for(int i=0;i<name.size();i++){
            if(t1>=time.get(i)){
                t2 = t1; s2 = s1;
                t1 = time.get(i); s1 = name.get(i);
            }else if(t2>time.get(i)){
                t2 = time.get(i); s2 = name.get(i);
            }
        }
        System.out.printf("Faster Runner: %s, Time Taken: %d min.\nSecond Fastest Runner: %s, Time Taken: %d min.\n",s1,t1,s2,t2);
    }
}
