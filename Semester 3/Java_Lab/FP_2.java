import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class FP_2 {

    public static String data(byte[] a){
        if(a==null)
            return null;
        StringBuilder res = new StringBuilder(a.length);
        int i=0;
        while(a[i]!=0)
            res.append((char)a[i++]);
        return res.toString();
    }

    public static String formatDate(Date date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try{
            return sdf.format(date);
        }catch(Exception e){
            return date.toString();
        }
    }

    public static void startUdpServer(int port) throws Exception{
        DatagramSocket ds = new DatagramSocket(port);
        byte[] received = new byte[65535];
        DatagramPacket dp = new DatagramPacket(received, received.length);
        ds.receive(dp);
        String format = data(received);
        System.out.println("Date Format Received: " + format);
        String formattedDate = formatDate(new Date(), format);
        InetAddress address = dp.getAddress();
        int port2 = dp.getPort();
        byte buffer[] = formattedDate.getBytes();

        DatagramPacket dpSend = new DatagramPacket(buffer, buffer.length, address, port2);
        ds.send(dpSend);
        ds.close();
    }

    public static void createUdpClient(int port) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();
        System.out.print("Enter Date Format: ");
        String format = br.readLine();
        byte buffer[] = format.getBytes();
        System.out.println("Sending Date Format...");
        DatagramPacket dpSend = new DatagramPacket(buffer, buffer.length, ip, port);
        ds.send(dpSend);
        byte received[] = new byte[65535];
        DatagramPacket dpReceive = new DatagramPacket(received, received.length);
        ds.receive(dpReceive);
        System.out.println("Formatted Date Received: " + data(received));
        ds.close(); br.close();
    }

    public static void main(String[] args) throws Exception{
        System.out.print("1. Server\n2. Client\nEnter choice: ");
        switch(new BufferedReader(new InputStreamReader(System.in)).readLine()){
            case "1":
                startUdpServer(5000); break;
            case "2":
                createUdpClient(5000); break;
        }
    }
}
