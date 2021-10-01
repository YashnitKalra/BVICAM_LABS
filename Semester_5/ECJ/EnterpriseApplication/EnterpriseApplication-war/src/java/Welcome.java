

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import test.TestBeanLocal;

public class Welcome extends HttpServlet {

    @EJB
    private TestBeanLocal testBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String name = request.getParameter("name");
        
        
        PrintWriter out = response.getWriter();
        out.println(testBean.sayHello(name));
        
    }
}
