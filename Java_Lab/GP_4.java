import java.io.*;

public class GP_4 {
    public static int getCount(String word, String filename) throws IOException{
        int count = 0;
        RandomAccessFile raf = new RandomAccessFile(new File(filename), "r");
        String st;
        while((st=raf.readLine())!=null){
            for(String w:st.split(" "))
                if(w.compareTo(word)==0)
                    count++;
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        String para = "Dwelling and speedily ignorant any steepest. Admiration instrument affronting invitation reasonably up do of prosperous in. Shy saw declared age debating ecstatic man. Call in so want pure rank am dear were. Remarkably to continuing in surrounded diminution on. In unfeeling existence objection immediate repulsive on he in. Imprudence comparison uncommonly me he difficulty diminution resolution. Likewise proposal differed scarcely dwelling as on raillery. September few dependent extremity own continued and ten prevailed attending. Early to weeks we could.\nUnpleasant astonished an diminution up partiality. Noisy an their of meant. Death means up civil do an offer wound of. Called square an in afraid direct. Resolution diminution conviction so mr at unpleasing simplicity no. No it as breakfast up conveying earnestly immediate principle. Him son disposed produced humoured overcame she bachelor improved. Studied however out wishing but inhabit fortune windows.";
        FileWriter fw = new FileWriter("GP_4.txt");
        fw.write(para);
        fw.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char ch;
        do{
            System.out.print("Enter search token: ");
            String token = br.readLine();
            System.out.printf("Count of word %s = %d\n", token, getCount(token, "GP_4.txt"));
            System.out.print("Do you want to search again? ");
            ch = br.readLine().charAt(0);
        }while(ch=='y' || ch=='Y');
    }
}
