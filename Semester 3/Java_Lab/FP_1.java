import java.net.*;
import java.io.*;

class Employee{
    String empName, empDept;
    int empId;

    public Employee(String empName, String empDept, int empId){
        this.empName = empName; this.empDept = empDept; this.empId = empId;
    }

    public String toString(){
        return String.format("ID: %d\nName: %s\nDepartment: %s", empId, empName, empDept);
    }
}

public class FP_1 {

    public static void startServer(int port) throws Exception{
        Employee emp[] = new Employee[]{new Employee("ABC", "AI", 1), new Employee("PQR", "Dev Ops", 2), new Employee("XYZ", "Testing", 3)};
        
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server Started");
        
        Socket socket = server.accept();
        System.out.println("Connection Established");

        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String id = dis.readUTF();
        int i = Integer.parseInt(id);

        for(Employee e:emp){
            if(e.empId==i){
                dos.writeUTF(e.toString()); break;
            }
        }
        dos.close();
        dis.close();
        socket.close();
        server.close();
    }

    public static void createClient(String address, int port) throws Exception{
        Socket socket = new Socket(address, port);
        System.out.println("Connected With Server");

        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter Employee ID: ");
        String id = br.readLine();
        dos.writeUTF(id);
        
        String empInfo = dis.readUTF();
        System.out.println(empInfo);

        br.close(); dos.close(); dis.close(); socket.close();

    }

    public static void main(String[] args) throws Exception{
        System.out.print("1. Server\n2. Client\nEnter choice: ");
        switch(new BufferedReader(new InputStreamReader(System.in)).readLine()){
            case "1":
                startServer(5000); break;
            case "2":
                createClient("localhost", 5000); break;
        }
    }
}
