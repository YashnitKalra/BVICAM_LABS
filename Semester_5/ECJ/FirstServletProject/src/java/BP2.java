import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BP2 extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession();
        if(sess.getAttribute("username")==null)
            response.sendRedirect("BP2.html");
        else
            try (PrintWriter out = response.getWriter()) {
                out.println("<h1>Login Authentication</h1>");
                out.println("<h2>Welcome " + sess.getAttribute("username") + "</h2>");
                out.println(
                        "<form action='BP2' method='Post'>"+
                        "<input type='hidden' name='logout' value='yes'>"+
                        "<input type='submit' value='Logout'>"+
                        "</form>"
                );
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        if(request.getParameter("logout")!=null && request.getParameter("logout").equals("yes")){
            request.getSession().invalidate();
            response.sendRedirect("BP2.html");
        }
        else{
            DB db = DB.getObject();
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            if(db.userExists(email, password)){
                HttpSession sess = request.getSession();
                sess.setAttribute("username", db.getUserName(email));
                response.sendRedirect("BP2");
            }
            else
                try (PrintWriter out = response.getWriter()) {
                    out.println("<h1>Login Authentication</h1>");
                    out.println("<h3>Incorrect Email/Password</h3>");
                }
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
