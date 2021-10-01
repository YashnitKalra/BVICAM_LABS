package Beans;

import java.io.Serializable;
import java.sql.*;

public class User implements Serializable {
    private String email, password, name, phone;
    private static String user = "postgres", dbPassword = "root", url = "jdbc:postgresql://localhost/wt";
    private static Connection conn;
    
    public User(){
        email = password = name = phone = null;
        try{
            DriverManager.registerDriver(new org.postgresql.Driver());
            conn = DriverManager.getConnection(url, user, dbPassword);
        }
        catch(SQLException e){}
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getName(){
        if(name!=null)
            return name;
        try{
            PreparedStatement pst = conn.prepareStatement("SELECT name FROM users WHERE email=?;");
            pst.setString(1, email); 
            ResultSet rs = pst.executeQuery();
            rs.next();
            name = rs.getString("name");
            rs.close();
            pst.close();
        }
        catch(SQLException e){}
        return name;
    }
    
    public String getPhone(){
        if(phone!=null)
            return phone;
        try{
            PreparedStatement pst = conn.prepareStatement("SELECT contact_number FROM users WHERE email=?;");
            pst.setString(1, email); 
            ResultSet rs = pst.executeQuery();
            rs.next();
            phone = rs.getString("contact_number");
            rs.close();
            pst.close();
        }
        catch(SQLException e){}
        return phone;
    }
    
    public boolean validate(){
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
        }
        catch(SQLException e){}
        return count>0;
    }
    
    public boolean emailOrPhoneExists(){
        int count = 0;
        try{
            PreparedStatement pst = conn.prepareStatement("SELECT COUNT(*) FROM users WHERE email=? OR contact_number=?;");
            pst.setString(1, email);
            pst.setString(2, phone);
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("count");
            rs.close();
            pst.close();
        }
        catch(SQLException e){}
        return count>0;
    }
    
    public void save(){
        try{
            PreparedStatement pst = conn.prepareStatement("INSERT INTO users VALUES(?, ?, ?, ?);");
            pst.setString(1, name);
            pst.setString(2, password);
            pst.setString(3, email);
            pst.setString(4, phone);
            pst.executeUpdate();
            pst.close();
        }
        catch(SQLException e){}
    }
}