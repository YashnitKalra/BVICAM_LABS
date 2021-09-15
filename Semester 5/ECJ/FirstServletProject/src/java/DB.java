import java.sql.*;

public class DB {
    private String user = "postgres", password = "root", url = "jdbc:postgresql://localhost/wt";
    private static Connection conn;
    private static DB db;
    private DB(){
        try{
            DriverManager.registerDriver(new org.postgresql.Driver());
            conn = DriverManager.getConnection(url, user, password);
        }
        catch(Exception e){}
    }
    public static DB getObject(){
        if(conn==null)
            db = new DB();
        return db;
    }
    
    boolean userExists(String email, String password){
        int count = 0;
        try{
            PreparedStatement pst = conn.prepareStatement("SELECT COUNT(*) FROM users WHERE email=? AND password=?;");
            pst.setString(1, email); 
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("count");
            rs.close();
            pst.close();
        }catch(Exception e){}
        return count==1;
    }
    
    String getUserName(String email){
        String name = "";
        try{
            PreparedStatement pst = conn.prepareStatement("SELECT name FROM users WHERE email=?;");
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            rs.next();
            name = rs.getString("name");
            rs.close(); pst.close();
        }catch(Exception e){}
        return name;
    }
    
    ResultSet getNurseData(){
        ResultSet rs = null;
        try{
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM nurse;");
        }catch(Exception e){}
        return rs;
    }
}
