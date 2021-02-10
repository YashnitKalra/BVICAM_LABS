class ThreadDemo implements Runnable{
    static int count = 0;
    
    public void run(){
        try{
            count++;
            Thread.currentThread().setName(Integer.toString(count));
            if(count<50){
                Thread t = new Thread(new ThreadDemo());
                t.start();
                t.join();
            }
            System.out.printf("Hello from thread %s!\n", Thread.currentThread().getName());
        }
        catch(InterruptedException e){System.out.println(e);}
    }
}

public class DP_3 {
    public static void main(String[] args){
        Thread t = new Thread(new ThreadDemo());
        t.start();
    }
}
