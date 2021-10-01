import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class AP4 extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Enumeration<String> params = request.getParameterNames();
            String param;
            while(params.hasMoreElements()){
                param = params.nextElement();
                out.println("<strong>" + param.toUpperCase() + ":</strong><br>" + String.join(", ", request.getParameterValues(param)) + "<br><br>");
            }
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
