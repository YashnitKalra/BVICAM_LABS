import ecj.ArithmeticBeanRemote;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArithmeticServlet extends HttpServlet {

    @EJB
    private ArithmeticBeanRemote arithmeticBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int a = Integer.parseInt(request.getParameter("a"));
        int b  = Integer.parseInt(request.getParameter("b"));
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<table style='text-align:center; border:1px solid black;'>");
            out.println("<thead><tr><th colspan='2'  style='border-bottom:1px solid black'>Arithmetic Operations</th></tr></thead>");
            out.println("<tr><td>Addition</td><td>"+ arithmeticBean.addition(a, b) +"</td></tr>");
            out.println("<tr><td>Subtraction</td><td>"+ arithmeticBean.subtraction(a, b) +"</td></tr>");
            out.println("<tr><td>Multiplication</td><td>"+ arithmeticBean.multiply(a, b) +"</td></tr>");
            out.println("<tr><td>Division</td><td>"+ arithmeticBean.divide(a, b) +"</td></tr>");
            out.println("</table>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
