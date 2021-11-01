package hp1;

import java.sql.*;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author yashnit
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/myQueue")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class NewsBean implements MessageListener {
    
    private static String user = "postgres", dbPassword = "root", url = "jdbc:postgresql://localhost/wt";
    
    public NewsBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage)message;
        try{
            String[] temp = tm.getText().split("\n", 2);
        
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection conn = DriverManager.getConnection(url, user, dbPassword);
            PreparedStatement pst = conn.prepareCall("INSERT INTO news (heading, content) VALUES (?, ?);");
            pst.setString(1, temp[0]);
            pst.setString(2, temp[1]);
            pst.execute();
            pst.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println("Error: " + e.toString());
        }
    }
    
}
