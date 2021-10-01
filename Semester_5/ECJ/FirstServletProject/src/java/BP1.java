import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BP1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        
        if(cookies==null)
            response.sendRedirect("BP1.html");
        else{
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                for(Cookie ck: cookies)
                    out.println(ck.getName()+ ": " + ck.getValue() + "<br>");
                response.setHeader("Refresh", "120; https://google.com/");
                out.println("<br>You will redirected to <i>https://google.com</i> in 2 minutes!!");
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> params = request.getParameterNames();
        while(params.hasMoreElements()){
            String param = params.nextElement();
            Cookie ck = new Cookie(param.toUpperCase(), request.getParameter(param));
            ck.setMaxAge(60);
            response.addCookie(ck);
        }
        response.sendRedirect("BP1");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
