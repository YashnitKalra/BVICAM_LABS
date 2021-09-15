import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BP5 extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String books = request.getParameter("sessionBooks");
        if(books==null)
            books = "";
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BP5</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form method='Post' action='BP5'>");
            out.println("<input type='hidden' name='sessionBooks' value='" + books + "'>");
            out.println("<select name='book'>");
            out.println("<option value='Harry Potter'>Harry Potter</option>");
            out.println("<option value='Jaws'>Jaws</option>");
            out.println("<option value='Stuart Little'>Stuart Little</option>");
            out.println("<option value='The Shining'>The Shining</option>");
            out.println("</select>");
            out.println("<input type='submit' name='submit' value='Add'>");
            out.println("</form>");
            out.println("<br><form method='Post' action='BP5'>");
            out.println("<input type='hidden' name='sessionBooks' value='" + books + "'>");
            out.println("<input type='submit' name='submit' value='Display Cart'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String books = request.getParameter("sessionBooks");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BP5</title>");            
            out.println("</head>");
            out.println("<body>");
            if(request.getParameter("submit").equals("Add")){
                books += "," + request.getParameter("book");
                out.println("<h2>Book Added to Cart</h2>");
            }
            else{
                String[] names = books.substring(1).split(",");
                out.println("<h2>Shopping Cart</h2>");
                out.println("<ul>");
                for(String name: names)
                    out.println("<li>" + name + "</li>");
                out.println("</ul>");
            }
            out.println("<form method='GET' action='BP5'>");
            out.println("<input type='hidden' name='sessionBooks' value='" + books + "'>");
            out.println("<input type='submit' value='Back'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
