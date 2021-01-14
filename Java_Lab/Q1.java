class Adder{
    private int numbers[];

    public Adder(String nums[]){
        numbers = new int[nums.length];
        for(int i=0;i<nums.length;i++)
            numbers[i] = Integer.parseInt(nums[i]);
    }

    public int getSum(){
        int s = 0;
        for(int i:numbers)
            s += i;
        return s;
    }
}

class Q1{
    public static int adder(String nums[]){
        int s = 0;
        for(String num:nums)
            s += Integer.parseInt(num);
        return s; 
    }

    public static void main(String[] args){
        System.out.println("Using Main: " + adder(args));
        
        Adder obj = new Adder(args);
        System.out.println("Using Class: " + obj.getSum());
    }
}