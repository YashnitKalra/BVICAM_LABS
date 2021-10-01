import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import marks.MarkBeanLocal;

public class Marks extends HttpServlet {

    @EJB
    private MarkBeanLocal markBean;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Result</title>");
            out.println("<style>body{background-color:#d7d7d7; padding:50px;}</style>");
            out.println("</head>");
            out.println("<body>");
            try{
                float marks1 = Float.parseFloat(request.getParameter("marks1"));
                float marks2 = Float.parseFloat(request.getParameter("marks2"));
                float marks3 = Float.parseFloat(request.getParameter("marks3"));
                float percentage = markBean.getPercentage(marks1, marks2, marks3);
                out.println("<h2 style='color:green'>Percentage: "+ percentage +"%<br>Divisision: "+ markBean.getDivision(percentage) +" </h2>");
            }catch(Exception e){
                out.println("<h2 style='color:red'>Error: Invalid Marks</h2>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
