import java.sql.*;
import java.util.*;

class DB{
    static String user = "postgres", password = "root", url = "jdbc:postgresql://localhost/bvicam";
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    DB(){
        try{
            // DriverManager.registerDriver(new org.postgresql.Driver());
            // Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void insert(int rno, String name, int score, String city){
        try{
            pst = conn.prepareStatement("INSERT INTO students VALUES (?,?,?,?)");
            pst.setInt(1, rno); pst.setString(2, name);
            pst.setInt(3, score); pst.setString(4, city);
            pst.executeUpdate(); pst.close();
            System.out.println("Record Added Successfully");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public boolean search(int rno){
        try{
            pst = conn.prepareStatement("SELECT * FROM students WHERE Roll=?");
            pst.setInt(1, rno);
            rs = pst.executeQuery();
            if(rs.next()){
                System.out.printf("Roll Number: %d, Name: %s, Score: %d, City: %s\n", rs.getInt("ROll"), rs.getString("Name"), rs.getInt("Score"), rs.getString("City"));
                return true;
            }
            else
                System.out.println("Record Not Found");
        }catch(Exception e){System.out.println(e);}
        return false;
    }

    public void update(int rno, String name, int score, String city){
        try{
            pst = conn.prepareStatement(
                "UPDATE students "+
                "SET Name=?, Score=?, City=? "+
                "WHERE Roll=?"
            );
            pst.setString(1, name); pst.setInt(2, score);
            pst.setString(3, city); pst.setInt(4, rno);
            pst.executeUpdate();
            System.out.println("Update Successfully");
        }catch(Exception e){e.printStackTrace();}
    }

    public void search2(int rno){
        try{
            CallableStatement cs = conn.prepareCall("{CALL search(?)}");
            cs.setInt(1, rno);
            rs = cs.executeQuery();
            while(rs.next()){
                System.out.printf("Name: %s, Score: %d, City: %s\n", rs.getString("name_out"), rs.getInt("score_out"), rs.getString("city_out"));
            }
        }catch(Exception e){e.printStackTrace();}
    }

}

class IP_3 {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int ch;
        DB db = new DB();
        String temp[];
        int rno;
        do{
            System.out.print("1. Add a record\t\t2. Search a record\n3. Modify a record\t4. Get Details Using Stored Function\nEnter Choice: ");
            ch = Integer.parseInt(obj.nextLine());
            switch(ch){
                case 1:
                    System.out.print("Enter student details (Rno,Name,Score,City): ");
                    temp = obj.nextLine().split(",");
                    db.insert(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]), temp[3]);
                    break;
                case 2:
                    System.out.print("Enter Roll Number: ");
                    db.search(Integer.parseInt(obj.nextLine()));
                    break;
                case 3:
                    System.out.print("Enter Roll Number: "); rno = Integer.parseInt(obj.nextLine());
                    if(db.search(rno)){
                        System.out.print("Enter Updated Values (Name,Score,City): ");
                        temp = obj.nextLine().split(",");
                        db.update(rno, temp[0], Integer.parseInt(temp[1]), temp[2]);
                    }
                    break;
                case 4:
                    System.out.print("Enter Roll Number: ");
                    db.search2(Integer.parseInt(obj.nextLine()));
                    break;
            }
            System.out.println();
        }while(ch>=1 && ch<=4);
        try{
            db.conn.close();
        }catch(Exception e){System.out.println(e);}
        obj.close();
    }
}