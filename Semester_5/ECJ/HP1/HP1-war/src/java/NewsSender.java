import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewsSender extends HttpServlet {

    @Resource(mappedName = "jms/myQueue")
    private Queue queue;
    
    @Resource(mappedName = "jms/myQueueFactory")
    private QueueConnectionFactory conFactory;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String heading = request.getParameter("heading");
        String content = request.getParameter("content");
        
        try (PrintWriter out = response.getWriter()) {
            try{
                Connection con = conFactory.createConnection();
                Session ses = con.createSession();
                MessageProducer mp = ses.createProducer(queue);
                
                TextMessage tm = ses.createTextMessage();
                tm.setText(heading + "\n" + content);
                
                mp.send(tm);
                response.sendRedirect("index.html");
            }
            catch(Exception e){
                out.println("Error: " + e.getMessage());
            }
        }
    } 
}
