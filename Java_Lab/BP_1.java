class BP_1{
    public static void main(String args[]){
        for(int i=0;i<args.length-1;i++){
            int index = i;
            for(int j=i+1;j<args.length;j++)
                if(args[index].compareTo(args[j])>0){
                    index = j;
                }
            String temp = args[i];
            args[i] = args[index];
            args[index] = temp;
        }
        System.out.println(String.join(" ", args));
    }
}