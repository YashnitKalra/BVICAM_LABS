public class DP_5 {
    static String message;

    private static class CorrectorThread extends Thread {
        public void run() {
            try {
                sleep(1000);
            } catch (InterruptedException e) {}
            // Key statement 1:
            message = "Mares do eat oats.";
        }
    }

    public static void main(String args[]) throws InterruptedException {
        (new CorrectorThread()).start();
        message = "Mares do not eat oats.";
        Thread.sleep(2000);
        // Key statement 2:
        System.out.println(message);
    }
}
// Most of the times "Mares do eat oats" will be printed
// But there is no gaurantee that key statement 1 will execute after 1000ms
// Since sleep() might throw InterruptedException
// No it will not help to change the two invocations of sleep
// To make all the changes visible to main thread we need a happens before relationship so we should instead use join() 