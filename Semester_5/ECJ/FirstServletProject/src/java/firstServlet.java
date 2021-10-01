import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author yashnit
 */
@WebServlet(urlPatterns = {"/firstServlet"})
public class firstServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter() ;
            
        int a = Integer.parseInt(request.getParameter("num1"));
        int b = Integer.parseInt(request.getParameter("num2"));
        int c = a+b;

        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet firstServlet</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + a + " + " + b + " = " + c + "</h1>");
        out.println("</body>");
        out.println("</html>");
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter() ;
            
        int a = Integer.parseInt(request.getParameter("num1"));
        int b = Integer.parseInt(request.getParameter("num2"));
        int c = a-b;

        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet firstServlet</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + a + " - " + b + " = " + c + "</h1>");
        out.println("</body>");
        out.println("</html>");
        
    }

}
