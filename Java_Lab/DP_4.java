class SharedCounterThread implements Runnable{
    static int counter = 0;
    public void run(){
        for(int i=0;i<10;i++){
            if(i%5==0) Thread.yield();
            counter++;
        }
    }
}

public class DP_4 {
    public static void main(String[] args){
        for(int i=0;i<10;i++)
            new Thread(new SharedCounterThread()).start();
        System.out.println(SharedCounterThread.counter);
    }
}
